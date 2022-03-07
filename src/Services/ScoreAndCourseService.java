package Services;

import Repository.ScoreAndCoursesRepository;

public class ScoreAndCourseService {
    ScoreAndCoursesRepository scoreAndCoursesRepository = new ScoreAndCoursesRepository();

    public void addCourse(String courseName, Integer unit) {
        try{
            scoreAndCoursesRepository.addCourse(courseName, unit);
        }catch (Exception e){
            System.out.println("an error has occur! "+e.getMessage());
        }

    }

    public void editCourse(Integer courseIndex, String newCurseName, Integer unit) {
        try{
            scoreAndCoursesRepository.editCourse(courseIndex, newCurseName, unit);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }

    public void removeCourse(Integer courseIndex) {
        try{
            scoreAndCoursesRepository.removeCourse(courseIndex);
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }

    public void viewCourseList() {
        try{
            scoreAndCoursesRepository.viewCourseList();
        }catch (Exception e){
            System.out.println("an error has occur! ");
        }
    }
}
