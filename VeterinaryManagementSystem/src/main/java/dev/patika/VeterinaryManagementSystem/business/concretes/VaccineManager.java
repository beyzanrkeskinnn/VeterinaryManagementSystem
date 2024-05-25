package dev.patika.VeterinaryManagementSystem.business.concretes;
import dev.patika.VeterinaryManagementSystem.business.abstracts.IAnimalService;
import dev.patika.VeterinaryManagementSystem.business.abstracts.IVaccineService;
import dev.patika.VeterinaryManagementSystem.core.config.ConvertEntityToResponse;
import dev.patika.VeterinaryManagementSystem.core.config.modelMapper.IModelMapperService;
import dev.patika.VeterinaryManagementSystem.core.exception.DataAlreadyExistException;
import dev.patika.VeterinaryManagementSystem.core.exception.NotFoundException;
import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.core.utilies.Msg;
import dev.patika.VeterinaryManagementSystem.core.utilies.ResultHelper;
import dev.patika.VeterinaryManagementSystem.dao.VaccineRepo;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.vaccine.VaccineResponse;
import dev.patika.VeterinaryManagementSystem.entity.Animal;
import dev.patika.VeterinaryManagementSystem.entity.Vaccine;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaccineManager implements IVaccineService {
    private final VaccineRepo vaccineRepo;
    private final IModelMapperService modelMapperService;
    private final IAnimalService animalService;
    private final ConvertEntityToResponse<Vaccine, VaccineResponse> convert;
    @Override
    public ResultData<VaccineResponse> save(VaccineSaveRequest vaccineSaveRequest) {

        List<Vaccine> existVaccines = this.findByCodeAndName(vaccineSaveRequest.getCode(), vaccineSaveRequest.getName());

        Animal animal = this.animalService.get(vaccineSaveRequest.getAnimalId());
        vaccineSaveRequest.setAnimalId(null);

        Vaccine saveVaccine = this.modelMapperService.forRequest().map(vaccineSaveRequest, Vaccine.class);
        saveVaccine.setAnimal(animal);
        if (!existVaccines.isEmpty() && existVaccines.get(0).getProtectionFnshDate().isAfter(LocalDate.now())){
            return ResultHelper.error("Aynı koda sahip aşının bitiş tarihi bitmemiş! ");
        }
        if (!existVaccines.isEmpty()){
            throw new DataAlreadyExistException(Msg.getEntityForMsg(Vaccine.class));
        }
        return ResultHelper.created(this.modelMapperService.forResponse().map(this.vaccineRepo.save(saveVaccine), VaccineResponse.class));
    }

    @Override
    public Vaccine get(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public ResultData<CursorResponse<VaccineResponse>> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Vaccine> vaccinePage = this.vaccineRepo.findAll(pageable);
        Page<VaccineResponse> vaccineResponsePage = vaccinePage.map(vaccine -> this.modelMapperService.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponsePage);
    }

    @Override
    public ResultData<List<VaccineResponse>> findByAnimalId(int id) {
        List<Vaccine> vaccineList = this.vaccineRepo.findByAnimalId(id);
        List<VaccineResponse> vaccineResponseList = this.convert.convertToResponseList(vaccineList, VaccineResponse.class);
        return ResultHelper.success(vaccineResponseList);
    }

    @Override
    public ResultData<List<VaccineResponse>> findByDate(LocalDate entryDate, LocalDate exitDate) {
        List<Vaccine> vaccineList = this.vaccineRepo.findByprotectionFnshDateBetween(entryDate, exitDate);
        List<VaccineResponse> vaccineResponseList = this.convert.convertToResponseList(vaccineList, VaccineResponse.class);
        return ResultHelper.success(vaccineResponseList);
    }

    @Override
    public List<Vaccine> findByCodeAndName(String code, String name) {
        return this.vaccineRepo.findByCodeAndName(code,name);
    }

    @Override
    public ResultData<VaccineResponse> update(VaccineUpdateRequest vaccineUpdateRequest) {
        this.get(vaccineUpdateRequest.getId());
        Vaccine updateVaccine = this.modelMapperService.forRequest().map(vaccineUpdateRequest, Vaccine.class);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateVaccine, VaccineResponse.class));
    }

    @Override
    public boolean delete(int id) {
        Vaccine vaccine = this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }
    public boolean isTrue(){
        return true;
    }

}
