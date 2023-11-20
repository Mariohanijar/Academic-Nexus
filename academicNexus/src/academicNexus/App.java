package academicNexus;

public class App {

	public static void main(String[] args) {
		
		
		//Professor
		Professor eliane = new Professor("Eliane", "cálculod/dx2x@hotmail.com", 213345, "022320045", "2010");
		Professor giras = new Professor("Giras", "Giras@outlook.com", 3345, "00045", "2012");
		Professor fabiTypeScript = new Professor("Fabio", "typescript@outlook.com", 332345, "0098345", "2016");
		Professor leo = new Professor("Leonardo", "leonardo@gmail.com", 123345, "02340045", "2019");
		
		 
		
		//Course
		Course engenhariaDaComputação = new Course("Engenharia da Computação", 3324235, 2005, "mo bom esse curso", giras);
		
		
		//Students
		Student johnArts = new Student("John Arts", "arts@gmail.com", 23902333, "29394235", "2023", "2 semestre", engenhariaDaComputação);
		
		
		//diretores
		Director alessandra = new Director("Alessandra", "Alessandra@gmail.com", 2345678, "4321098", "2010");
		
		//Instituições
		School cesupa = new School("Cesupa","Alcindo Cancela", 2330003, 1990, alessandra);
		
		
		cesupa.addProfessor(fabiTypeScript);
		cesupa.addProfessor(giras);
		cesupa.addProfessor(eliane);
		cesupa.printProfessors();
		System.out.println(alessandra);
		System.out.println(engenhariaDaComputação);
		System.out.println(cesupa);
		System.out.println(johnArts);
		
	}

}
