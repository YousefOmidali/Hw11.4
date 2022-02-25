package Repository;

import Entity.ScoresAndCourses;

public class ScoreAndCoursesRepository {
    private ScoresAndCourses[] listOfCourses = new ScoresAndCourses[50000];
    private Integer listOfCoursesIndex = 0;

    public void addCourse(String courseName, Integer unit) {
        this.listOfCourses[listOfCoursesIndex].setCourse(courseName);
        listOfCourses[listOfCoursesIndex].setUnit(unit);
        listOfCoursesIndex++;
    }

    public void editCourse(Integer courseIndex, String newCurseName, Integer unit) {
        listOfCourses[courseIndex].setCourse(newCurseName);
        listOfCourses[courseIndex].setUnit(unit);
    }

    public void removeCourse(Integer courseIndex) {
        listOfCourses[courseIndex] = listOfCourses[listOfCoursesIndex];
        listOfCourses[listOfCoursesIndex] = null;
        listOfCoursesIndex--;
    }

    public void viewCourseList() {
        for (int i = 0; i < listOfCoursesIndex; i++) {
            System.out.println(listOfCourses[i].getCourse());
        }
    }
}
