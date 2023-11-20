package academicNexus;

import java.util.Arrays;

public class Student extends Academic {
    public String level;
    public Course course;
    public int[] grades = new int[5];

    public Student(String name, String email, int ID, String CPF, String inscriptionDate, String level, Course course) {
        super(name, email, ID, CPF, inscriptionDate);
        this.level = level;
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public Course getCourse() {
        return course;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setLevel(String level) {
        if (level.length() > 0) {
            this.level = level;
        }
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

	@Override
	public String toString() {
		return "Name: "	+ getName() + ", Email: " + getEmail() + ", ID: " + getID() + ", CPF: " + getCPF()
				+ ", Inscription Date: " + getInscriptionDate() + "level: " + level + ", course: " + course + ", grades; ";
		//JOAO NÃO SE ESQUECA DO ARRAY DE GRADES QUE FOI RETIRADO PARA VC CONSERTAR
	}
    
}

