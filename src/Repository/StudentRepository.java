package Repository;

import Entity.Student;

public class StudentRepository {
    private Student[] student = new Student[1000];
    private Integer studentIndex = 0;

    public void signUpStudent(Student student) {
        this.student[studentIndex] = student;
        studentIndex++;
    }

    public void removeStudent(Integer index) {
        this.student[index] = student[studentIndex];
        student[studentIndex] = null;
        studentIndex--;
    }

    public void editStudent(Integer index, String firstName, String lastName, String username, String password) { // ************ Need Edit
        student[index].setFirstName(firstName);
        student[index].setLastName(lastName);
        student[index].setUserName(username);
        student[index].setPassword(password);
    }

    public void studentInfo(Integer studentIndex) {
        System.out.println(student[studentIndex]);
    }

    public String scoreAverage(Integer studentIndex) {
        int avg = 0;
        String stats;
        int i;
        for (i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            avg += student[studentIndex].getScoresAndCourses()[i].getScore();
        }
        avg = avg / ++i;
        if (avg >= 18)
            stats = "you can take upto 24 units";
        else stats = "you can take upto 20 units";
        return stats;
    }

    public Boolean passCourseCheck(Integer studentIndex, String courseName) {
        boolean stats = true;
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            if (student[studentIndex].getScoresAndCourses()[i].getCourse().equals(courseName)
                    && student[studentIndex].getScoresAndCourses()[i].getScore() < 10) {
                stats = false;
                break;
            }
        }
        return stats;
    }

    public String viewCoursesAndScoresToStudent(Integer studentIndex) {   //namaayesh dars ha va nomarate student
        String showTakkenCoursesAndScores = "";
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            showTakkenCoursesAndScores += student[studentIndex].getScoresAndCourses()[i].getCourse() + ": " +
                    student[studentIndex].getScoresAndCourses()[i].getScore() + " \n";

        }
        return showTakkenCoursesAndScores;
    }

    public void scoreRegister(Integer studentIndex, String courseName, Integer score) {
        for (int i = 0; i < student[studentIndex].getScoresAndCourses().length; i++) {
            if (student[studentIndex].getScoresAndCourses()[i].getCourse().equals(courseName) &&
                    student[studentIndex].getScoresAndCourses()[i].getScore().equals(null)) {
                student[studentIndex].getScoresAndCourses()[i].setScore(score);
            }
        }
    }

    public Integer studentCheck(String username, String password) {
        int checkStats = 0;
        for (int i = 0; i < studentIndex; i++) {
            if (student[i].getUserName().equals(username) && student[i].getPassword().equals(password))
                checkStats = 1;
        }
        return checkStats;
    }
}
