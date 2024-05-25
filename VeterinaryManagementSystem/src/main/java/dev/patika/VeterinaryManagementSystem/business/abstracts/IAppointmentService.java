package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.appointment.AppointmentSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.appointment.AppointmentUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.appointment.AppointmentResponse;
import dev.patika.VeterinaryManagementSystem.entity.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IAppointmentService{
    ResultData<AppointmentResponse> save(AppointmentSaveRequest appointmentSaveRequest);
    Appointment get(int id);
    ResultData<CursorResponse<AppointmentResponse>> cursor(int page, int pageSize);
    ResultData<AppointmentResponse> update(AppointmentUpdateRequest appointmentUpdateRequest);
    boolean delete(int id);
    List<Appointment> findByDateTime(LocalDateTime localDateTime);
    ResultData<List<AppointmentResponse>> findByDoctorIdAndDateTimeBetween(int id, LocalDate entryDate, LocalDate exitDate);
    ResultData<List<AppointmentResponse>> findByAnimalIdAndDateTimeBetween(int id, LocalDate entryDate, LocalDate exitDate);
    Optional<Appointment> findByValueForValid(LocalDateTime dateTime, Integer doctorId, Integer animalId);

}