package pro.sky.spring_library.service;

import pro.sky.spring_library.domain.Employee;

public interface EmployeeService {

    Employee addEmployee(String firstname, String lastName, int departmentId, double salary);
}
