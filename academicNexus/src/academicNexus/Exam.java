package academicNexus;

import java.io.Serializable;

public class Exam implements Serializable {
    private Course course;
    private int[] grades = new int[2];
    

    public Exam(Course course, int grade1, int grade2) {
        this.course = course;
        this.grades[0] = grade1;
        this.grades[1] = grade2;
    }

    public Course getCourse() {
        return course;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGrade(int[] grades) {
        this.grades = grades;
    }

    @Override

    public String toString() {
        return "Course: " + course.getName() + ", Grades: " + grades[0] + ", " + grades[1] + "\n";
    } 
}
