package dev.patika.VeterinaryManagementSystem.business.abstracts;

import dev.patika.VeterinaryManagementSystem.core.result.ResultData;
import dev.patika.VeterinaryManagementSystem.dto.CursorResponse;
import dev.patika.VeterinaryManagementSystem.dto.request.customer.CustomerSaveRequest;
import dev.patika.VeterinaryManagementSystem.dto.request.customer.CustomerUpdateRequest;
import dev.patika.VeterinaryManagementSystem.dto.response.customer.CustomerResponse;
import dev.patika.VeterinaryManagementSystem.entity.Customer;

import java.util.List;

public interface ICustomerService {
    ResultData<CustomerResponse> save(CustomerSaveRequest customerSaveRequest);
    Customer get(int id);
    ResultData<CursorResponse<CustomerResponse>> cursor(int page, int pageSize);
    ResultData<CustomerResponse> update(CustomerUpdateRequest customerUpdateRequest);
    ResultData<List<CustomerResponse>> findByName(String name);
    List<Customer> findByNameAndMailAndPhone(String name, String mail, String phone);
    boolean delete(int id);
}
