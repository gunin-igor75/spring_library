package pro.sky.spring_library.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.spring_library.domain.Employee;
import pro.sky.spring_library.exeptions.EmployeeAlreadyAddedException;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @Override
    public Employee addEmployee(String firstname, String lastName, int departmentId, double salary) {
        if (checkFirstName(firstname) && checkLastName(lastName)) {
            Employee employee = new Employee(StringUtils.capitalize(firstname.trim()),
                    StringUtils.capitalize(lastName.trim()),departmentId, salary);
            employees.put(employee.getFullName(), employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException("Не валидные данные работника");
    }

    private boolean checkFirstName(String string) {
        return  StringUtils.isAlpha(string);
    }

    private boolean checkLastName(String string) {
        boolean flagChar = StringUtils.isAlpha(string);
        boolean flagLastname = false;
        if (string.contains("-")) {
            String[] lastname = string.split("-");
            flagLastname = (lastname.length == 2) && StringUtils.isAlpha(lastname[0])
                    && StringUtils.isAlpha(lastname[1]);
        }
        return flagChar || flagLastname;
    }
}
