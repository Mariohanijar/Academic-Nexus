package academicNexus;

import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		
		//Professor
		Professor eliane = new Professor("Eliane", "cálculod/dx2x@hotmail.com", 213345, "022320045", "2010");
		Professor giras = new Professor("Giras", "Giras@outlook.com", 3345, "00045", "2012");
		Professor fabiTypeScript = new Professor("Fabio", "typescript@outlook.com", 332345, "0098345", "2016");
				 
		//Course
		Course engenhariaDaComputação = new Course("Engenharia da Computação", 3324235, 2005, "mo bom esse curso", giras);
        Course engenhariaDeSoftware = new Course("Engenharia de Software", 3324235, 2005, "mo bom esse curso", giras);
		//Students
        Student johnArts = new Student("John Arts", "email do johnarts", 55555, "00000000000", "2019", "Graduação");
		
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
		
		johnArts.addCourse(engenhariaDaComputação);
        Student maritoAnijar = new Student("Marito Anijar", "email do marito", 55555, "00000000000", "2019", "Graduação");
        engenhariaDaComputação.addStudent(maritoAnijar);
        engenhariaDaComputação.addStudent(johnArts);

        maritoAnijar.addCourse(engenhariaDaComputação);
        johnArts.addCourse(engenhariaDaComputação);

        johnArts.addExam(new Exam(engenhariaDaComputação, 10, 10));

        maritoAnijar.addExam(new Exam(engenhariaDaComputação, 5, 5));

        engenhariaDaComputação.printRelatory();

        johnArts.addExam(new Exam(engenhariaDeSoftware, 100, 53));

        //System.out.println(johnArts);
        

		String path = "C:\\Users\\carol\\Desktop\\data.txt";
		
		String content = "o igor é baitola e esse jogo é multi";
		
		FileWriter writer = new FileWriter(path);
		
		writer.write(cesupa.toString());
		
		writer.close();
		
	}
}

