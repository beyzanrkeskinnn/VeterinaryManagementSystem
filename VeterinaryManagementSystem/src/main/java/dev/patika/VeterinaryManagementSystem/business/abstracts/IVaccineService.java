package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.vaccine.VaccineSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.vaccine.VaccineUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.vaccine.VaccineResponse;
import dev.patika.VeterinaryManagementSystem.entity.Vaccine;

import java.time.LocalDate;
import java.util.List;

public interface IVaccineService {
    ResultData<VaccineResponse> save(VaccineSaveRequest vaccineSaveRequest);
    Vaccine get(int id);
    ResultData<CursorResponse<VaccineResponse>> cursor(int page, int pageSize);
    ResultData<List<VaccineResponse>> findByAnimalId(int id);
    ResultData<List<VaccineResponse>> findByDate(LocalDate entryDate, LocalDate exitDate);
    List<Vaccine> findByCodeAndName(String code, String name);
    ResultData<VaccineResponse> update(VaccineUpdateRequest vaccineUpdateRequest);
    boolean delete(int id);
}
