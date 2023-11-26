package academicNexus;

import java.util.ArrayList;

public class School extends Academy {
    private String adress;
    private Director director;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Professor> professors = new ArrayList<Professor>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private static final long serialVersionUID = 1l;

    public School(String name, String adress, int ID, int yearOfFoundation, Director director) {
        super(name, ID, yearOfFoundation);
        this.adress = adress;
        this.director = director;
    }

    public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public String getAdress() {
        return adress;
    }

    public Director getDirector() {
        return director;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public void removeProfessor(Professor professor) {
        this.professors.remove(professor);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public void printCourses() {
        for (Course course : this.courses) {
            System.out.println(course);
        }
    }

    public void printProfessors() {
        for (Professor professor : this.professors) {
            System.out.println(professor);
        }
    }

    public void printStudents() {
        for (Student student : this.students) {
            System.out.println(student);
        }
    }

	@Override
	public String toString() {
		return "Nome: " + getName() + "\nID: " + getID()
		+ "\nAno De Fundação: " + getYearOfFoundation() + "\nEndereço: " + adress + "\nDiretor:" + director + "\nCursos: " + courses + "\nProfessores: "
				+ professors + "\nEstudantes: " + students;
	}

}