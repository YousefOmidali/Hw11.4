package Services;

import Entity.Employee;
import Repository.EmployeeRepository;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public void signUp(Employee employee){
        try{
            employeeRepository.signUpEmployee(employee);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }
    public void removeEmployee(Integer index) {
        try{
            employeeRepository.removeEmployee(index);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }
    public void editEmployee(Integer index, Employee employee) {
        try{
            employeeRepository.editEmployee(index,employee);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }
    public void viewEmployeeSalaryAndInfo(Integer index) {
        try{
            employeeRepository.viewEmployeeSalaryAndInfo(index);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }

    }
    public Integer employeeCheck(String username, String password) {
        Integer id=0;
        try{
             id = employeeRepository.employeeCheck(username, password);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
        return id;
    }
}
