package Services;

import Entity.Student;
import Repository.StudentRepository;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    String answer = "";
    Integer number = 0;
    Boolean status;

    public void sigUp(Student student) {
        try {
            studentRepository.signUpStudent(student);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void remove(Integer index) {
        try {
            studentRepository.removeStudent(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void edit(Integer index, String firstName, String lastName, String username, String password) {
        try {
            studentRepository.editStudent(index, firstName, lastName, username, password);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public void studentInfo(Integer index) {
        try {
            studentRepository.studentInfo(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public String scoreAvg(Integer index) {
        try {
            answer = studentRepository.scoreAverage(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return answer;
    }

    public Boolean passCourseCheck(Integer index, String courseName) {
        try {
            status = studentRepository.passCourseCheck(index, courseName);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return status;
    }

    public String viewCourseAndScoresToStudent(Integer index) {
        try {
            answer = studentRepository.viewCoursesAndScoresToStudent(index);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return answer;
    }

    public void scoreRegister(Integer index, String courseName, Integer score) {
        try {
            studentRepository.scoreRegister(index, courseName, score);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
    }

    public Integer studentCheck(String username, String password) {
        try {
            number = studentRepository.studentCheck(username, password);
        } catch (Exception e) {
            System.out.println("an error has occur! ");
        }
        return number;
    }

}
