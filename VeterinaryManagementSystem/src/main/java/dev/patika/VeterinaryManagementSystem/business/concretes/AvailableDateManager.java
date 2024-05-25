package dev.patika.VeterinaryManagementSystem.business.concretes;

import dev.patika.VeterinaryManagementSystem.business.abstracts.IAvailableDateService;

import dev.patika.VeterinaryManagementSystem.business.abstracts.IDoctorService;
import dev.patika.VeterinaryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.VeterinaryManagementSystem.core.exception.DataAlreadyExistException;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.core.utilies.ResultHelper;

import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;

import dev.patika.VeterinaryManagementSystem.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.availableDate.AvailableDateUpdateRequest;

import dev.patika.VeterinaryManagementSystem.dto.response.availableDate.AvailableDateResponse;

import dev.patika.VeterinaryManagementSystem.entity.AvailableDate;

import dev.patika.VeterinaryManagementSystem.dao.AvailableDateRepo;
import dev.patika.VeterinaryManagementSystem.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailableDateManager implements IAvailableDateService {
    private final AvailableDateRepo availableDateRepo;
    private final IModelMapperService modelMapperService;
    private final IDoctorService doctorService;

    @Override
    public ResultData<AvailableDateResponse> save(AvailableDateSaveRequest availableDateSaveRequest) {
        List<AvailableDate> availableDateList = this.availableDateRepo.findByDateAndDoctorId(
                availableDateSaveRequest.getDate(),
                availableDateSaveRequest.getDoctorId());
        if (!availableDateList.isEmpty()) {
            throw new DataAlreadyExistException(Msg.getEntityForMsg(AvailableDate.class));
        }

        Doctor doctor = this.doctorService.get(availableDateSaveRequest.getDoctorId());
        availableDateSaveRequest.setDoctorId(null);

        AvailableDate saveAvailableDate = this.modelMapperService.forRequest().map(availableDateSaveRequest, AvailableDate.class);
        saveAvailableDate.setDoctor(doctor);
        return ResultHelper.created(this.modelMapperService.forResponse().map(this.availableDateRepo.save(saveAvailableDate), AvailableDateResponse.class));
    }

    @Override
    public AvailableDate get(int id) {
        return this.availableDateRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public ResultData<CursorResponse<AvailableDateResponse>> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<AvailableDate> availableDatePage = this.availableDateRepo.findAll(pageable);
        Page<AvailableDateResponse> availableDateResponsePage = availableDatePage.map(availableDate -> this.modelMapperService.forResponse().map(availableDate, AvailableDateResponse.class));
        return ResultHelper.cursor(availableDateResponsePage);
    }

    @Override
    public ResultData<AvailableDateResponse> update(AvailableDateUpdateRequest availableDateUpdateRequest) {
        this.get(availableDateUpdateRequest.getId());
        AvailableDate updateAvailableDate = this.modelMapperService.forResponse().map(availableDateUpdateRequest, AvailableDate.class);
        return ResultHelper.success(this.modelMapperService.forResponse().map(this.availableDateRepo.save(updateAvailableDate), AvailableDateResponse.class));
    }

    @Override
    public boolean delete(int id) {
        AvailableDate availableDate = this.get(id);
        this.availableDateRepo.delete(availableDate);
        return true;
    }
}
