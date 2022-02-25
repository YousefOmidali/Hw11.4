package Entity;

public class ScoresAndCourses {
    private Integer score;
    private String course;
    private Integer unit;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public ScoresAndCourses(Integer score, String course, Integer unit) {
        this.score = score;
        this.course = course;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ScoresAndCourses{" +
                "score=" + score +
                ", course='" + course + '\'' +
                ", unit=" + unit +
                '}';
    }
}
