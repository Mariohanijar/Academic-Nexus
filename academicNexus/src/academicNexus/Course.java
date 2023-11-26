package academicNexus;

import java.util.ArrayList;

public class Course extends Academy {
    private String description;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Professor professor;
    private static final long serialVersionUID = 1l;
    
    public Course(String name, int ID, int yearOfFoundation, String description, Professor professor) {
        super(name, ID, yearOfFoundation);
        this.description = description;
        this.professor = professor;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Student> getStudents() {
        return students;
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
    public double getClassAverage() {
    	double sum = 0;
        for (Student student : this.students) {
            sum += student.getGradeAverage(this);
        }

        double average = sum / this.students.size();
        return average;
    }
    
    public double getClassStandardDeviation() {
    	double sum = 0;
        for (Student student : this.students) {
            sum += student.getGradeAverage(this);
        }

        double average = sum / this.students.size();
        
        double sumOfSquares = 0;
        
        for (Student student : this.students) {
        	sumOfSquares += (student.getGradeAverage(this) - average);
        }
        sumOfSquares /= this.students.size();
        
        return Math.sqrt(sumOfSquares);
    }

    public void printRelatory() {
        System.out.println("Students: ");
        this.printStudents();

        System.out.println("Exams: ");

        for (Student student : this.students) {
            System.out.println(student.getName() + ": ");
            student.printExams(this);
        }

        System.out.println("Grade average: ");
        double sum = 0;
        for (Student student : this.students) {
            sum += student.getGradeAverage(this);
        }

        double average = sum / this.students.size();

        System.out.println(average);

        sum = 0;
        
        System.out.println("Standard Deviation: ");
        for (Student student : this.students) {
            sum += Math.pow(student.getGradeAverage(this) - average, 2);
        }
        double standardDeviation = Math.sqrt(sum / this.students.size());

        System.out.println(standardDeviation);
    }

	@Override
	public String toString() {
		return "Course " + getName() + ", ID:" + getID()
		+ ", Year Of Foundation: " + getYearOfFoundation() + ", description: " + description + ", professor: " + professor;
	}  
}
