package pro.sky.spring_library.controller.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.spring_library.domain.Employee;
import pro.sky.spring_library.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    Employee add(@RequestParam(value = "firstName", required = false) String firstName,
                 @RequestParam(value = "lastName", required = false) String lastName,
                 @RequestParam(value = "departmentId", required = false) int departmentId,
                 @RequestParam(value = "salary", required = false) double salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }
}
