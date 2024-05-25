package dev.patika.VeterinaryManagementSystem.business.abstracts;


import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.availableDate.AvailableDateSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.availableDate.AvailableDateUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.availableDate.AvailableDateResponse;
import dev.patika.VeterinaryManagementSystem.entity.AvailableDate;

public interface IAvailableDateService {
    ResultData<AvailableDateResponse> save(AvailableDateSaveRequest availableDateSaveRequest);
    AvailableDate get(int id);
    ResultData<CursorResponse<AvailableDateResponse>> cursor(int page, int pageSize);
    ResultData<AvailableDateResponse> update(AvailableDateUpdateRequest availableDateUpdateRequest);
    boolean delete(int id);
}
