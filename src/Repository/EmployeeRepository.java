package Repository;

import Entity.Employee;

public class EmployeeRepository {
    private Employee[] employee = new Employee[1000];
    private Integer employeeIndex = 0;


    public void signUpEmployee(Employee employee) {
        this.employee[employeeIndex] = employee;
        employeeIndex++;
    }

    public void removeEmployee(Integer index) {
        employee[index] = employee[employeeIndex];
        employee[employeeIndex] = null;
        employeeIndex--;
    }

    public void editEmployee(Integer index, Employee employee) {
        this.employee[index].setFirstName(employee.getFirstName());
        this.employee[index].setLastName(employee.getLastName());
        this.employee[index].setUserName(employee.getUserName());
        this.employee[index].setPassword(employee.getPassword());
        this.employee[index].setSalary(employee.getSalary());
    }

    public void viewEmployeeSalaryAndInfo(Integer index) {
        System.out.println(employee[index].toString());
    }

    public Integer employeeCheck(String username, String password) {
        int checkStats = 0;
        for (int i = 0; i < employeeIndex; i++) {
            if (employee[i].getUserName().equals(username) && employee[i].getPassword().equals(password))
                checkStats = 1;
        }
        return checkStats;
    }
}
