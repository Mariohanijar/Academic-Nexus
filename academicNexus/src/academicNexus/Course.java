package academicNexus;

import java.util.ArrayList;
import java.util.Arrays;

public class Course extends Academy {
    private String description;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Professor professor;
    private String[] subjects = new String[5];

    public Course(String name, int ID, int yearOfFoundation, String description, Professor professor) {
        super(name, ID, yearOfFoundation);
        this.description = description;
        this.professor = professor;
    }

    public String getDescription() {
        return description;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

    public void setDescription(String description) {
        if (description.length() > 0) {
            this.description = description;
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
    public void printStudents() {
        for (Student student : this.students) {
            System.out.println(student);
        }
    }

	@Override
	public String toString() {
		return "Course " + getName() + ", ID:" + getID()
		+ ", Year Of Foundation: " + getYearOfFoundation() + ", description: " + description + ", professor: " + professor;
	}

    
    
}

