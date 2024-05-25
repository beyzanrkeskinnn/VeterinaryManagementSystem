package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.doctor.DoctorSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.doctor.DoctorUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.doctor.DoctorResponse;
import dev.patika.VeterinaryManagementSystem.entity.Doctor;

import java.time.LocalDate;
import java.util.List;

public interface IDoctorService {
    ResultData<DoctorResponse> save(DoctorSaveRequest doctorSaveRequest);
    Doctor get(int id);
    ResultData<CursorResponse<DoctorResponse>> cursor(int page, int pageSize);
    ResultData<DoctorResponse> update(DoctorUpdateRequest doctorUpdateRequest);
    boolean delete(int id);
    List<Doctor> findByIdAndAvailableDateDate(int id, LocalDate localDate);
    List<Doctor> findByNameAndMailAndPhone(String name, String mail, String phone);
}
