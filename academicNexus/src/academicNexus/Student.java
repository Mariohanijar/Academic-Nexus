package academicNexus;

import java.util.ArrayList;

public class Student extends Academic {
    public String level;
    public ArrayList<Course> courses = new ArrayList<Course>();
    public ArrayList<Exam> exams = new ArrayList<Exam>();

    public Student(String name, String email, int ID, String CPF, String inscriptionDate, String level) {
        super(name, email, ID, CPF, inscriptionDate);
        this.level = level;
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    public void removeExam(Exam exam) {
        exams.remove(exam);
    }

    public double getGradeAverage(Course course) {
        double sum = 0;
        for (Exam exam : this.exams) {
            if(exam.getCourse() == course) {
                for(int i = 0; i < 2; i++) {
                    sum += exam.getGrades()[i];
                }
            }
        }
        return sum / 2;
    }

    public String getLevel() {
        return level;
    }

   public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setLevel(String level) {
        if (level.length() > 0) {
            this.level = level;
        }
    }

    public void printExams(Course course) {
        for (Exam exam : this.exams) {
            if(exam.getCourse() == course) {
                System.out.println(exam);
            }
        }
    }

	@Override
	public String toString() {
		return "\nNome: "	+ getName() + "\nEmail: " + getEmail() + "\nID: " + getID() + "\nCPF: " + getCPF()
				+ "\nData de Matricula: " + getInscriptionDate() + "\nNível: " + level + "\nCursos " + courses + "\nExames: " + exams;
	}
    
}
