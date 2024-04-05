package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.exceptions.types.BusinessException;
import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.Car;
import com.java_spring.java_spring_crud.entities.Customer;
import com.java_spring.java_spring_crud.entities.Employee;
import com.java_spring.java_spring_crud.repositories.CustomerRepository;
import com.java_spring.java_spring_crud.repositories.EmployeeRepository;
import com.java_spring.java_spring_crud.services.abstracts.CustomerService;
import com.java_spring.java_spring_crud.services.abstracts.EmployeeService;
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.AddEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.DeleteEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.GetEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.requests.UpdateEmployeeRequest;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeeByRelationResponse;
import com.java_spring.java_spring_crud.services.dtos.employee.responses.GetEmployeePhoneResponse;
import com.java_spring.java_spring_crud.services.rules.EmployeeBusinessRule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CustomerService customerService;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;
    private final EmployeeBusinessRule employeeBusinessRule;

    @Override
    public Result add(AddEmployeeRequest request) {

        employeeBusinessRule.checkEmployeeNameLength(request.getName());

        Employee employee = this.modelMapperService.forRequest().map(request,Employee.class);
        Customer customer = customerService.getById(request.getCustomer_relation());
        employee.setCustomer_relation(customer);
        employeeRepository.save(employee);

        return new SuccessResult(messageService.getMessage(Messages.Employee.employeeAddSuccess));
    }

    @Override
    public Result deleteById(DeleteEmployeeRequest request) {
        employeeBusinessRule.existsById(request.getId());
        employeeRepository.deleteById(request.getId());
        return new SuccessResult(messageService.getMessage(Messages.Employee.employeeDeleteSuccess));
    }

    @Override
    public Result update(UpdateEmployeeRequest request) {
        employeeBusinessRule.existsById(request.getId());

        Employee employeeToUpdate = this.modelMapperService.forRequest().map(request,Employee.class);
        employeeToUpdate.setPhone(request.getPhone());

        Customer customer = customerService.getById(request.getCustomer_relation());
        employeeToUpdate.setCustomer_relation(customer);

        employeeRepository.save(employeeToUpdate);

        return new SuccessResult(messageService.getMessage(Messages.Employee.employeeUpdateSuccess));
    }

    @Override
    public Employee getById(GetEmployeeRequest request) {
        return employeeRepository.findById(request.getId())
                .orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.Employee.employeeNotFoundMessage)));
    }

    @Override
    public List<String> getAll() {
        return employeeRepository.findAll().stream()
                .map(Employee::getName)
                .toList();
    }

    @Override
    public List<GetEmployeePhoneResponse> getByPhone(String phone) {

        return employeeRepository.getByPhone(phone).stream().map((employee) -> new GetEmployeePhoneResponse(
                employee.getPhone(), employee.getName(),employee.getSurname(), employee.getId()
        )).toList();
    }

    @Override
    public List<GetEmployeeByRelationResponse> getByRelation(int id) {
        return employeeRepository.getByRelation(id);
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new BusinessException(messageService.getMessage(Messages.Employee.employeeNotFoundMessage)));
    }
}
