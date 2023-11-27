package academicNexus;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	private static ArrayList<Director> directorsList = new ArrayList<>();
	private static ArrayList<School> schoolsList = new ArrayList<>();
	private static ArrayList<Professor> professorsList = new ArrayList<>();
	private static ArrayList<Student> studentList = new ArrayList<>();
	private static ArrayList<Course> courseList = new ArrayList<>();
    
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		try (ObjectInputStream schoolInput = new ObjectInputStream(new FileInputStream("data/schools.bin"))) {
		    while (true) {
		        School school = (School) schoolInput.readObject();
		        schoolsList.add(school);
		    }
		} catch (EOFException e) {
		    
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		try (ObjectInputStream directorInput = new ObjectInputStream(new FileInputStream("data/directors.bin"))) {
		    while (true) {
		        Director director = (Director) directorInput.readObject();
		        directorsList.add(director);
		    }
		} catch (EOFException e) {
		    
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		try (ObjectInputStream professorInput = new ObjectInputStream(new FileInputStream("data/professors.bin"))) {
		    while (true) {
		        Professor professor = (Professor) professorInput.readObject();
		        professorsList.add(professor);
		    }
		} catch (EOFException e) {
		   
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		try (ObjectInputStream studentInput = new ObjectInputStream(new FileInputStream("data/students.bin"))) {
		    while (true) {
		        Student student = (Student) studentInput.readObject();
		        studentList.add(student);
		    }
		} catch (EOFException e) {
		   
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
		try (ObjectInputStream courseInput = new ObjectInputStream(new FileInputStream("data/courses.bin"))) {
		    while (true) {
		        Course course = (Course) courseInput.readObject();
		        courseList.add(course);
		    }
		} catch (EOFException e) {
		    
		} catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}    

        JFrame frame = new JFrame("ACADEMIC NEXUS");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color myGrey = new Color(220, 220, 220);

        JPanel cardPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Painel Inicial
        JPanel initialPanel = new JPanel();
        initialPanel.setLayout(null);
        initialPanel.setBackground(myGrey);

        JLabel label = new JLabel("ACADEMIC NEXUS");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        label.setBounds(39, 22, 700, 100);

        JButton cadastrarButton = new JButton("Realizar Cadastros");
        JButton verificarButton = new JButton("Verificar Cadastros");

        cadastrarButton.setBounds(122, 200, 200, 50);
        verificarButton.setBounds(458, 200, 200, 50);

        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        verificarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Verificacao");
            }
        });

        initialPanel.add(label);
        initialPanel.add(cadastrarButton);
        initialPanel.add(verificarButton);

        cardPanel.add(initialPanel, "Inicial");

        // Painel de Cadastro
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(null);
        cadastroPanel.setBackground(myGrey);

        JLabel cadastroLabel = new JLabel("Painel de Cadastro");
        cadastroLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        cadastroLabel.setBounds(272, 23, 300, 30);

        JButton voltarInicialButton = new JButton("Voltar");
        voltarInicialButton.setBounds(124, 398, 100, 30);

        voltarInicialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Inicial");
            }
        });

        cadastroPanel.add(cadastroLabel);
        cadastroPanel.add(voltarInicialButton);

        cardPanel.add(cadastroPanel, "Cadastro");
        
        JButton btnNewButton = new JButton("Cadastrar Instituição");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(cardPanel, "InstCad");
        	}
        });
        btnNewButton.setBounds(62, 76, 224, 57);
        cadastroPanel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Cadastrar Professores");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(cardPanel, "profCad");
        	}
        });
        btnNewButton_1.setBounds(62, 167, 224, 57);
        cadastroPanel.add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Cadastrar Alunos");
        btnNewButton_3.setBounds(417, 76, 224, 57);
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(cardPanel, "alunoCad");
        	}
        });
        cadastroPanel.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Criar Cursos");
        btnNewButton_4.setBounds(417, 167, 224, 57);
        btnNewButton_4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
    		cardLayout.show(cardPanel, "courseCad");
    	}
    });
        cadastroPanel.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Inscrever Alunos");
        btnNewButton_5.setBounds(417, 264, 224, 57);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		cardLayout.show(cardPanel, "associarAlunoCurso");
        	}
        });
        cadastroPanel.add(btnNewButton_5);
        
        JButton btnNewButton_2 = new JButton("Gerar Relatório");
        btnNewButton_2.setBounds(62, 264, 224, 57);
         btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		cardLayout.show(cardPanel, "RelatorioCursoPanel");
        	}
        });
        cadastroPanel.add(btnNewButton_2);
        
     // Subpainel Cadastrar instituição
        JPanel instCad = new JPanel();
        instCad.setLayout(null);
        instCad.setBackground(myGrey);

        // Campos de entrada para o diretor
        JLabel nomeDirLabel = new JLabel("Nome do Diretor:");
        nomeDirLabel.setBounds(50, 80, 120, 20);
        JTextField nomeDirField = new JTextField();
        nomeDirField.setBounds(170, 80, 150, 20);

        JLabel idDirLabel = new JLabel("ID do Diretor:");
        idDirLabel.setBounds(50, 110, 120, 20);
        JTextField idDirField = new JTextField();
        idDirField.setBounds(170, 110, 150, 20);
        
     

        JLabel dataContratacaoLabel = new JLabel("Data de Contratação:");
        dataContratacaoLabel.setBounds(50, 201, 150, 20);
        JTextField dataContratacaoField = new JTextField();
        dataContratacaoField.setBounds(198, 201, 120, 20);

        // Campos de entrada para a instituição
        JLabel nomeInstLabel = new JLabel("Nome da Instituição:");
        nomeInstLabel.setBounds(400, 80, 150, 20);
        JTextField nomeInstField = new JTextField();
        nomeInstField.setBounds(540, 80, 150, 20);

        JLabel enderecoInstLabel = new JLabel("Endereço da Instituição:");
        enderecoInstLabel.setBounds(400, 110, 150, 20);
        JTextField enderecoInstField = new JTextField();
        enderecoInstField.setBounds(540, 110, 150, 20);

        JLabel idInstLabel = new JLabel("ID da Instituição:");
        idInstLabel.setBounds(400, 140, 120, 20);
        JTextField idInstField = new JTextField();
        idInstField.setBounds(540, 140, 150, 20);

        JLabel anoFundacaoInstLabel = new JLabel("Ano de Fundação:");
        anoFundacaoInstLabel.setBounds(400, 171, 138, 20);
        JTextField anoFundacaoInstField = new JTextField();
        anoFundacaoInstField.setBounds(540, 171, 109, 20);
        
        JLabel cpfDirLabel = new JLabel("CPF do Diretor:");
        cpfDirLabel.setBounds(50, 140, 120, 20);
        JTextField cpfDirField = new JTextField();
        cpfDirField.setBounds(170, 140, 150, 20);

        JLabel emailDirLabel = new JLabel("E-mail do Diretor:");
        emailDirLabel.setBounds(50, 170, 120, 20);
        JTextField emailDirField = new JTextField();
        emailDirField.setBounds(170, 170, 150, 20);

        // Botão para enviar
        JButton enviarButton = new JButton("Enviar");
        enviarButton.setBounds(50, 300, 100, 30);

        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
            	if (camposCadastroPreenchidos(nomeDirField, idDirField, cpfDirField, emailDirField, dataContratacaoField, nomeInstField, enderecoInstField, idInstField, anoFundacaoInstField)) {

					Director director = new Director(nomeDirField.getText(), emailDirField.getText(),
							Integer.parseInt(idDirField.getText()), cpfDirField.getText(),
							dataContratacaoField.getText());

					School school = new School(nomeInstField.getText(), enderecoInstField.getText(),
						    Integer.parseInt(idInstField.getText()), Integer.parseInt(anoFundacaoInstField.getText()), director);
						directorsList.add(director);

						try {
						    ObjectOutputStream directorOutput = new ObjectOutputStream(new FileOutputStream("data/directors.bin"));

						    for (Director d : directorsList) {
						        directorOutput.writeObject(d);
						    }

						    directorOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}

						schoolsList.add(school);

						try {
						    ObjectOutputStream schoolOutput = new ObjectOutputStream(new FileOutputStream("data/schools.bin"));

						    for (School s : schoolsList) {
						        schoolOutput.writeObject(s);
						    }

						    schoolOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
                 
                    
                    JOptionPane.showMessageDialog(null, "        Cadastro Realizado");
                    cardLayout.show(cardPanel, "Cadastro");

                 
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }


            }
        });

        // Botão para voltar
        JButton voltarInicialButton3 = new JButton("Voltar");
        voltarInicialButton3.setBounds(50, 400, 100, 30);

        voltarInicialButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        instCad.add(nomeDirLabel);
        instCad.add(nomeDirField);
        instCad.add(idDirLabel);
        instCad.add(idDirField);
        instCad.add(dataContratacaoLabel);
        instCad.add(dataContratacaoField);
        instCad.add(cpfDirLabel);
        instCad.add(cpfDirField);
        instCad.add(emailDirLabel);
        instCad.add(emailDirField);
        instCad.add(nomeInstLabel);
        instCad.add(nomeInstField);
        instCad.add(enderecoInstLabel);
        instCad.add(enderecoInstField);
        instCad.add(idInstLabel);
        instCad.add(idInstField);
        instCad.add(anoFundacaoInstLabel);
        instCad.add(anoFundacaoInstField);
        instCad.add(enviarButton);
        instCad.add(voltarInicialButton3);

        cardPanel.add(instCad, "InstCad");
        
       
        
     // Subpainel Cadastrar Professores
        JPanel profCad = new JPanel();
        profCad.setLayout(null);
        profCad.setBackground(myGrey);


        JLabel nomeProfLabel = new JLabel("Nome do Professor:");
        nomeProfLabel.setBounds(50, 80, 150, 20);
        JTextField nomeProfField = new JTextField();
        nomeProfField.setBounds(200, 80, 150, 20);

        JLabel idProfLabel = new JLabel("ID do Professor:");
        idProfLabel.setBounds(50, 110, 150, 20);
        JTextField idProfField = new JTextField();
        idProfField.setBounds(200, 110, 150, 20);

        JLabel cpfProfLabel = new JLabel("CPF do Professor:");
        cpfProfLabel.setBounds(50, 140, 150, 20);
        JTextField cpfProfField = new JTextField();
        cpfProfField.setBounds(200, 140, 150, 20);

        JLabel emailProfLabel = new JLabel("E-mail do Professor:");
        emailProfLabel.setBounds(50, 170, 150, 20);
        JTextField emailProfField = new JTextField();
        emailProfField.setBounds(200, 170, 150, 20);

        JLabel dataContratacaoProfLabel = new JLabel("Data de Contratação:");
        dataContratacaoProfLabel.setBounds(50, 201, 150, 20);
        JTextField dataContratacaoProfField = new JTextField();
        dataContratacaoProfField.setBounds(200, 201, 150, 20);
       

      
        JLabel escolaLabel = new JLabel("Escolher Escola:");
        escolaLabel.setBounds(400, 201, 150, 20);

 
        String[] escolasArray = new String[schoolsList.size()];
        for (int i = 0; i < schoolsList.size(); i++) {
            String nomeEscola = schoolsList.get(i).getName();
            escolasArray[i] = nomeEscola;
            System.out.println("Nome da Escola #" + i + ": " + nomeEscola);
        }
  
        JTextField escolherEscola = new JTextField();
        escolherEscola.setBounds(540, 201, 150, 20);

     
        JButton enviarProfButton = new JButton("Enviar");
        enviarProfButton.setBounds(50, 300, 100, 30);

        enviarProfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (camposCadastroPreenchidos(nomeProfField, idProfField, cpfProfField, emailProfField, dataContratacaoProfField)) {
             
                    Professor professor = new Professor(nomeProfField.getText(), emailProfField.getText(), Integer.parseInt(idProfField.getText()), cpfProfField.getText(), dataContratacaoProfField.getText());

                    School escola = null;
                    for (School s : schoolsList) {
                        if (s.getName().equals(escolherEscola.getText())) {
                            escola = s;
                            break;
                        }
                    }

                    
                    if (escola != null) {
                    	professorsList.add(professor);
                        escola.addProfessor(professor);
                        
                        try {
						    ObjectOutputStream professorOutput = new ObjectOutputStream(new FileOutputStream("data/professors.bin"));

						    for (Professor p : professorsList) {
						    	professorOutput.writeObject(p);
						    }

						    professorOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
						
						try {
						    ObjectOutputStream schoolOutput = new ObjectOutputStream(new FileOutputStream("data/schools.bin"));

						    for (School s : schoolsList) {
						        schoolOutput.writeObject(s);
						    }

						    schoolOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
						
                        JOptionPane.showMessageDialog(null, "Cadastro de Professor Realizado na Escola: " + escola.getName());
                        cardLayout.show(cardPanel, "Cadastro");

                     
                    } else {
                        JOptionPane.showMessageDialog(null, "Escola não encontrada.");
                    } }
                    else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });
        
        JButton voltarInicialProfButton = new JButton("Voltar");
        voltarInicialProfButton.setBounds(50, 400, 100, 30);

        voltarInicialProfButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        profCad.add(nomeProfLabel);
        profCad.add(nomeProfField);
        profCad.add(idProfLabel);
        profCad.add(idProfField);
        profCad.add(cpfProfLabel);
        profCad.add(escolaLabel);
        profCad.add(escolherEscola);
        profCad.add(cpfProfField);
        profCad.add(emailProfLabel);
        profCad.add(emailProfField);
        profCad.add(dataContratacaoProfLabel);
        profCad.add(dataContratacaoProfField);
        profCad.add(enviarProfButton);
        profCad.add(voltarInicialProfButton);

        cardPanel.add(profCad, "profCad");
        
     // Subpainel Cadastrar Alunos
        JPanel alunoCad = new JPanel();
        alunoCad.setLayout(null);
        alunoCad.setBackground(myGrey);


        JLabel nomeAlunoLabel = new JLabel("Nome do Aluno:");
        nomeAlunoLabel.setBounds(50, 80, 150, 20);
        JTextField nomeAlunoField = new JTextField();
        nomeAlunoField.setBounds(200, 80, 150, 20);

        JLabel idAlunoLabel = new JLabel("ID do Aluno:");
        idAlunoLabel.setBounds(50, 110, 150, 20);
        JTextField idAlunoField = new JTextField();
        idAlunoField.setBounds(200, 110, 150, 20);

        JLabel cpfAlunoLabel = new JLabel("CPF do Aluno:");
        cpfAlunoLabel.setBounds(50, 140, 150, 20);
        JTextField cpfAlunoField = new JTextField();
        cpfAlunoField.setBounds(200, 140, 150, 20);

        JLabel emailAlunoLabel = new JLabel("E-mail do Aluno:");
        emailAlunoLabel.setBounds(50, 170, 150, 20);
        JTextField emailAlunoField = new JTextField();
        emailAlunoField.setBounds(200, 170, 150, 20);

        JLabel dataInscricaoAlunoLabel = new JLabel("Data de inscrição:");
        dataInscricaoAlunoLabel.setBounds(50, 201, 150, 20);
        JTextField dataInscricaoAlunoField = new JTextField();
        dataInscricaoAlunoField.setBounds(200, 201, 150, 20);

        JLabel studentLevelLabel = new JLabel("Level:");
        studentLevelLabel.setBounds(50, 230, 150, 20);
        JTextField studentLevelField = new JTextField();
        studentLevelField.setBounds(200, 230, 150, 20);
       
       
        JLabel SchoolLabel = new JLabel("Escolher Escola:");
        SchoolLabel.setBounds(400, 201, 150, 20);
        JTextField escolherSchool = new JTextField();
        escolherSchool.setBounds(540, 201, 150, 20);
        alunoCad.add(SchoolLabel);
        alunoCad.add(escolherSchool);
 
        String[] SchoolArray = new String[schoolsList.size()];
        for (int i = 0; i < schoolsList.size(); i++) {
            String nomeEscola = schoolsList.get(i).getName();
            SchoolArray[i] = nomeEscola;
            System.out.println("Nome da Escola #" + i + ": " + nomeEscola);
        }
  
     
        JButton enviarAlunoButton = new JButton("Enviar");
        enviarAlunoButton.setBounds(50, 300, 100, 30);

        enviarAlunoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (camposCadastroPreenchidos(nomeAlunoField, idAlunoField, cpfAlunoField, emailAlunoField, dataInscricaoAlunoField, studentLevelField)) {
             
                    Student student = new Student(nomeAlunoField.getText(), emailAlunoField.getText(), Integer.parseInt(idAlunoField.getText()), cpfAlunoField.getText(), dataInscricaoAlunoField.getText(), studentLevelField.getText());

                    School escola = null;
                    for (School s : schoolsList) {
                        if (s.getName().equals(escolherSchool.getText())) {
                            escola = s;
                            break;
                        }
                    }

                    
                    if (escola != null) {
                    	studentList.add(student);
                        escola.addStudent(student);
                        
                        try {
						    ObjectOutputStream studentOutput = new ObjectOutputStream(new FileOutputStream("data/students.bin"));

						    for (Student st : studentList) {
						    	studentOutput.writeObject(st);
						    }

						    studentOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
						
						try {
						    ObjectOutputStream schoolOutput = new ObjectOutputStream(new FileOutputStream("data/schools.bin"));

						    for (School s : schoolsList) {
						        schoolOutput.writeObject(s);
						    }

						    schoolOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
						
                        JOptionPane.showMessageDialog(null, "Cadastro de Aluno Realizado na Escola: " + escola.getName());
                        cardLayout.show(cardPanel, "Cadastro");

                     
                    } else {
                        JOptionPane.showMessageDialog(null, "Escola não encontrada.");
                    } }
                    else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });
        
        JButton voltarInicialAlunoButton = new JButton("Voltar");
        voltarInicialAlunoButton.setBounds(50, 400, 100, 30);

        voltarInicialAlunoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });
        
        alunoCad.add(studentLevelLabel);
        alunoCad.add(studentLevelField);
        alunoCad.add(nomeAlunoLabel);
        alunoCad.add(nomeAlunoField);
        alunoCad.add(idAlunoLabel);
        alunoCad.add(idAlunoField);
        alunoCad.add(cpfAlunoLabel);
        alunoCad.add(cpfAlunoField);
        alunoCad.add(emailAlunoLabel);
        alunoCad.add(emailAlunoField);
        alunoCad.add(dataInscricaoAlunoField);
        alunoCad.add(dataInscricaoAlunoLabel);
        alunoCad.add(enviarAlunoButton);
        alunoCad.add(voltarInicialAlunoButton);

        cardPanel.add(alunoCad, "alunoCad"); 
        
     // Subpainel Cadastrar Cursos
        JPanel courseCad = new JPanel();
        courseCad.setLayout(null);
        courseCad.setBackground(myGrey);

        JLabel nomeCourseLabel = new JLabel("Nome do Curso:");
        nomeCourseLabel.setBounds(50, 80, 150, 20);
        JTextField nomeCourseField = new JTextField();
        nomeCourseField.setBounds(169, 80, 150, 20);

        JLabel idCourseLabel = new JLabel("ID do Curso:");
        idCourseLabel.setBounds(50, 110, 150, 20);
        JTextField idCourseField = new JTextField();
        idCourseField.setBounds(169, 111, 150, 20);

        JLabel anoFundacaoCourseLabel = new JLabel("Ano de Fundação:");
        anoFundacaoCourseLabel.setBounds(50, 140, 109, 20);
        JTextField anoFundacaoCourseField = new JTextField();
        anoFundacaoCourseField.setBounds(169, 141, 150, 20);

        JLabel descricaoCourseLabel = new JLabel("Descrição do Curso:");
        descricaoCourseLabel.setBounds(50, 170, 150, 20);
        JTextField descricaoCourseField = new JTextField();
        descricaoCourseField.setBounds(169, 170, 150, 20);

        JLabel escolaCourseLabel = new JLabel("Escolher Escola:");
        escolaCourseLabel.setBounds(400, 80, 150, 20);

        String[] SchoolzArray = new String[schoolsList.size()];
        for (int i = 0; i < schoolsList.size(); i++) {
            String nomeEscola = schoolsList.get(i).getName();
            SchoolzArray[i] = nomeEscola;
            System.out.println("Nome da Escola #" + i + ": " + nomeEscola);
        }

        JTextField escolherEscolaCourse = new JTextField();
        escolherEscolaCourse.setBounds(540, 80, 150, 20);

        JLabel professorCourseLabel = new JLabel("Escolher Professor:");
        professorCourseLabel.setBounds(400, 110, 150, 20);

        String[] professoresArray = new String[professorsList.size()];
        for (int i = 0; i < professorsList.size(); i++) {
            String nomeProfessor = professorsList.get(i).getName();
            professoresArray[i] = nomeProfessor;
            System.out.println("Nome do Professor #" + i + ": " + nomeProfessor);
        }

        JTextField escolherProfessorCourse = new JTextField();
        escolherProfessorCourse.setBounds(540, 110, 150, 20);

        JButton enviarCourseButton = new JButton("Enviar");
        enviarCourseButton.setBounds(50, 300, 100, 30);

        enviarCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (camposCadastroPreenchidos(nomeCourseField, idCourseField, anoFundacaoCourseField, descricaoCourseField, escolherEscolaCourse, escolherProfessorCourse)) {
                    Course curso = new Course(nomeCourseField.getText(), Integer.parseInt(idCourseField.getText()), Integer.parseInt(anoFundacaoCourseField.getText()), descricaoCourseField.getText(), null);

                    School escola = null;
                    for (School s : schoolsList) {
                        if (s.getName().equals(escolherEscolaCourse.getText())) {
                            escola = s;
                            break;
                        }
                    }

                    Professor professor = null;
                    for (Professor p : professorsList) {
                        if (p.getName().equals(escolherProfessorCourse.getText())) {
                            professor = p;
                            break;
                        }
                    }

                    if (escola != null && professor != null) {
                        curso.setProfessor(professor);
                        escola.addCourse(curso);
                        courseList.add(curso);
                        
                        try {
						    ObjectOutputStream courseOutput = new ObjectOutputStream(new FileOutputStream("data/courses.bin"));

						    for (Course c : courseList) {
						    	courseOutput.writeObject(c);
						    }

						    courseOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}
						
						try {
						    ObjectOutputStream schoolOutput = new ObjectOutputStream(new FileOutputStream("data/schools.bin"));

						    for (School s : schoolsList) {
						        schoolOutput.writeObject(s);
						    }

						    schoolOutput.close();
						} catch (IOException e1) {
						    e1.printStackTrace();
						}

						
                        JOptionPane.showMessageDialog(null, "Cadastro de Curso Realizado na Escola: " + escola.getName());
                        cardLayout.show(cardPanel, "Cadastro");
                    } else {
                        JOptionPane.showMessageDialog(null, "Escola ou Professor não encontrados.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });

        JButton voltarInicialCourseButton = new JButton("Voltar");
        voltarInicialCourseButton.setBounds(50, 400, 100, 30);

        voltarInicialCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        courseCad.add(nomeCourseLabel);
        courseCad.add(nomeCourseField);
        courseCad.add(idCourseLabel);
        courseCad.add(idCourseField);
        courseCad.add(anoFundacaoCourseLabel);
        courseCad.add(anoFundacaoCourseField);
        courseCad.add(descricaoCourseLabel);
        courseCad.add(descricaoCourseField);
        courseCad.add(escolaCourseLabel);
        courseCad.add(escolherEscolaCourse);
        courseCad.add(professorCourseLabel);
        courseCad.add(escolherProfessorCourse);
        courseCad.add(enviarCourseButton);
        courseCad.add(voltarInicialCourseButton);

        cardPanel.add(courseCad, "courseCad");

     // Subpainel Associar Aluno a Curso
        JPanel associarAlunoCurso = new JPanel();
        associarAlunoCurso.setLayout(null);
        associarAlunoCurso.setBackground(myGrey);

        JLabel alunoLabel = new JLabel("Escolher Aluno:");
        alunoLabel.setBounds(50, 80, 150, 20);

        String[] alunosArray = new String[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            String nomeAluno = studentList.get(i).getName();
            alunosArray[i] = nomeAluno;
            System.out.println("Nome do Aluno #" + i + ": " + nomeAluno);
        }

        JTextField escolherAluno = new JTextField();
        escolherAluno.setBounds(200, 80, 150, 20);

        JLabel schoozLabel = new JLabel("Escolher Escola:");
        schoozLabel.setBounds(50, 141, 150, 20);

        String[] schoozArray = new String[schoolsList.size()];
        for (int i = 0; i < schoolsList.size(); i++) {
            String nomeEscola = schoolsList.get(i).getName();
            schoozArray[i] = nomeEscola;
            System.out.println("Nome da Escola #" + i + ": " + nomeEscola);
        }

        JTextField chooseSchoolz = new JTextField();
        chooseSchoolz.setBounds(200, 141, 150, 20);

        JLabel cursoLabel = new JLabel("Escolher Curso:");
        cursoLabel.setBounds(50, 201, 150, 20);

        String[] cursosArray = new String[courseList.size()];
        for (int i = 0; i < courseList.size(); i++) {
            String nomeCurso = courseList.get(i).getName();
            cursosArray[i] = nomeCurso;
            System.out.println("Nome do Curso #" + i + ": " + nomeCurso);
        }

        JTextField escolherCurso = new JTextField();
        escolherCurso.setBounds(200, 201, 150, 20);

        JLabel nota1Label = new JLabel("Nota 1:");
        associarAlunoCurso.add(nota1Label);
        nota1Label.setBounds(447, 80, 66, 20);

        JTextField nota1Field = new JTextField(5);
        associarAlunoCurso. add(nota1Field);
        nota1Field.setBounds(523, 80, 150, 20);

        JLabel nota2Label = new JLabel("Nota 2:");
        associarAlunoCurso.add(nota2Label);
        nota2Label.setBounds(447, 201, 76, 20);

        JTextField nota2Field = new JTextField(5);
        associarAlunoCurso.add(nota2Field);
        nota2Field.setBounds(523, 201, 150, 20);
        
        JButton associarButton = new JButton("Associar");
        associarButton.setBounds(50, 300, 100, 30);

        associarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (camposCadastroPreenchidos(escolherAluno, chooseSchoolz, escolherCurso, nota1Field, nota2Field)) {
                    Student aluno = null;
                    for (Student s : studentList) {
                        if (s.getName().equals(escolherAluno.getText())) {
                            aluno = s;
                            break;
                        }
                    }

                    School escola = null;
                    for (School s : schoolsList) {
                        if (s.getName().equals(chooseSchoolz.getText())) {
                            escola = s;
                            
                            break;
                        }
                    }
                    
                    Course curso = null;
                    for (Course c : courseList) {
                        if (c.getName().equals(escolherCurso.getText())) {
                            curso = c;
                            break;
                        }
                    }
                    
                   
                    System.out.println(curso.getStudents());
                    
                    if (aluno != null && escola != null && curso != null) {
                        if (escola.getStudents().contains(aluno)) {
                            curso.addStudent(aluno);
                            aluno.addCourse(curso);
                            
                           
                            System.out.println(curso.getStudents());
                            System.out.println(escola);
                            
                            try {
    						    ObjectOutputStream courseOutput = new ObjectOutputStream(new FileOutputStream("data/courses.bin"));

    						    for (Course c : courseList) {
    						    	courseOutput.writeObject(c);
    						    }

    						    courseOutput.close();
    						} catch (IOException e1) {
    						    e1.printStackTrace();
    						}
                            
                            Exam exam = new Exam(curso,Integer.parseInt(nota1Field.getText()),Integer.parseInt(nota2Field.getText()));
                            
                            aluno.addExam(exam);
                            
                            try {
    						    ObjectOutputStream studentOutput = new ObjectOutputStream(new FileOutputStream("data/students.bin"));

    						    for (Student st : studentList) {
    						    	studentOutput.writeObject(st);
    						    }

    						    studentOutput.close();
    						} catch (IOException e1) {
    						    e1.printStackTrace();
    						}
                            
                            try {
    						    ObjectOutputStream schoolOutput = new ObjectOutputStream(new FileOutputStream("data/schools.bin"));

    						    for (School s : schoolsList) {
    						    	schoolOutput.writeObject(s);
    						    }

    						    schoolOutput.close();
    						} catch (IOException e1) {
    						    e1.printStackTrace();
    						}
                            
                            JOptionPane.showMessageDialog(null, "Aluno associado ao Curso com sucesso.");
                            cardLayout.show(cardPanel, "Cadastro");
                        } else {
                            JOptionPane.showMessageDialog(null, "O aluno não está matriculado nesta escola.");
                        }
                    } else if (aluno == null) {
                        JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                    }
                    else if (escola == null) {
                        JOptionPane.showMessageDialog(null, "escola não encontrada.");
                    }else if (curso == null) {
                        JOptionPane.showMessageDialog(null, "curso não encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });

        JButton voltarInicialAssociarButton = new JButton("Voltar");
        voltarInicialAssociarButton.setBounds(50, 400, 100, 30);

        voltarInicialAssociarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        associarAlunoCurso.add(alunoLabel);
        associarAlunoCurso.add(escolherAluno);
        associarAlunoCurso.add(schoozLabel);
        associarAlunoCurso.add(chooseSchoolz);
        associarAlunoCurso.add(cursoLabel);
        associarAlunoCurso.add(escolherCurso);
        associarAlunoCurso.add(associarButton);
        associarAlunoCurso.add(voltarInicialAssociarButton);

        cardPanel.add(associarAlunoCurso, "associarAlunoCurso");

     // Subpainel Relatório do Curso
        
        JPanel relatorioCursoPanel = new JPanel();
        relatorioCursoPanel.setLayout(null);
        relatorioCursoPanel.setBackground(myGrey);

 
        JLabel escolasLabel = new JLabel("Escolher Escola:");
        escolasLabel.setBounds(28, 110, 106, 20);

 
        String[] escolassArray = new String[schoolsList.size()];
        for (int i = 0; i < schoolsList.size(); i++) {
            String nomeEscola = schoolsList.get(i).getName();
            escolassArray[i] = nomeEscola;
            System.out.println("Nome da Escola #" + i + ": " + nomeEscola);
        }
  
        JTextField escolherEscolass = new JTextField();
        escolherEscolass.setBounds(137, 110, 150, 20);

        JLabel escolherCursosLabel = new JLabel("Escolher Curso:");
        escolherCursosLabel.setBounds(421, 110, 95, 20);
        JTextField escolherCursosPanel = new JTextField();
        escolherCursosPanel.setBounds(523, 110, 150, 20);
       

  
        JButton gerarRelatorioButton = new JButton("Gerar Relatório");
        gerarRelatorioButton.setBounds(50, 150, 150, 30);

   
        JTextArea relatorioTextArea = new JTextArea();
        relatorioTextArea.setBounds(28, 209, 700, 200);
        relatorioTextArea.setEditable(false);
      

      
        JButton voltarVerificacaoButton = new JButton("Voltar");
        voltarVerificacaoButton.setBounds(50, 420, 100, 30);

        voltarVerificacaoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro");
            }
        });

        
       
        relatorioCursoPanel.add(escolasLabel);
        relatorioCursoPanel.add(escolherCursosLabel);
        relatorioCursoPanel.add(escolherCursosPanel);
        relatorioCursoPanel.add(escolherEscolass);
        relatorioCursoPanel.add(gerarRelatorioButton);
        relatorioCursoPanel.add(relatorioTextArea);
        relatorioCursoPanel.add(voltarVerificacaoButton);

      
        cardPanel.add(relatorioCursoPanel, "RelatorioCursoPanel");
        
        
        gerarRelatorioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String escolaSelecionada = (String) escolherEscolass.getText();
                String cursoSelecionado = (String) escolherCursosPanel.getText();

                School escola = null;
                for (School s : schoolsList) {
                    if (s.getName().equals(escolaSelecionada)) {
                        escola = s;
                        break;
                    }
                }

                Course curso = null;
                for (Course c : escola.getCourses()) {
                    if (c.getName().equals(cursoSelecionado)) {
                        curso = c;
                        break;
                    }
                }
                
                System.out.println(curso.getClassStandardDeviation());

                if (escola != null && curso != null) {
                    // Gerar o relatório
                    String relatorio = "Relatório do Curso: " + curso.getName() + " na Escola: " + escola.getName() + "\n\n";
                    for (Student aluno : curso.getStudents()) {
                        relatorio += "Aluno: " + aluno.getName() + "\n";
                        relatorio += "Notas Individual: " + aluno.getGradeAverage(curso) + "\n";
                    }
                    relatorio += "Média da Turma: " + curso.getClassAverage() + "\n";
                    relatorio += "Desvio Padrão da Turma: " + curso.getClassStandardDeviation() + "\n\n";
                    relatorioTextArea.setText(relatorio);
                } else {
                    JOptionPane.showMessageDialog(null, "Escola ou Curso não encontrado.");
                }
            }
        });

        
        // Painel de Verificação
        JPanel verificacaoPanel = new JPanel();
        verificacaoPanel.setLayout(null);
        verificacaoPanel.setBackground(myGrey);

        JLabel verificacaoLabel = new JLabel("Painel de Verificação");
        verificacaoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        verificacaoLabel.setBounds(297, 25, 300, 30);

        JButton voltarInicialButton2 = new JButton("Voltar");
        voltarInicialButton2.setBounds(175, 395, 100, 30);

        voltarInicialButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Inicial");
            }
        });

        verificacaoPanel.add(verificacaoLabel);
        verificacaoPanel.add(voltarInicialButton2);

        cardPanel.add(verificacaoPanel, "Verificacao");
        
        JButton btnNewButton_6 = new JButton("Verificar Instituições");
        btnNewButton_6.setBounds(99, 92, 251, 81);
        btnNewButton_6.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder info = new StringBuilder();
              
                info.append("\nInformações das Escolas:\n");
                for (School school : schoolsList) {
                    info.append(school.toString()).append("\n");
                }


                JTextArea infoTextArea = new JTextArea(info.toString());
                infoTextArea.setEditable(false);

                
                JScrollPane scrollPane = new JScrollPane(infoTextArea);

                
                JOptionPane.showMessageDialog(null, scrollPane, "Informações", JOptionPane.PLAIN_MESSAGE);
            
          
        
        	}});
        verificacaoPanel.add(btnNewButton_6);
        
        JButton btnNewButton_7 = new JButton("Verificar Professores");
        btnNewButton_7.setBounds(99, 203, 251, 81);
        btnNewButton_7.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder info = new StringBuilder();
              
                info.append("\nInformações dos professores:\n");
                for (Professor professor : professorsList) {
                    info.append(professor.toString()).append("\n");
                }


                JTextArea infoTextArea = new JTextArea(info.toString());
                infoTextArea.setEditable(false);

                
                JScrollPane scrollPane = new JScrollPane(infoTextArea);

                
                JOptionPane.showMessageDialog(null, scrollPane, "Informações", JOptionPane.PLAIN_MESSAGE);
            
          
        
        	}});
        verificacaoPanel.add(btnNewButton_7);
        
        JButton btnNewButton_8 = new JButton("Verificar Alunos");
        btnNewButton_8.setBounds(445, 92, 251, 81);
        btnNewButton_8.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder info = new StringBuilder();
              
                info.append("\nInformações dos Alunos:\n");
                for (Student student : studentList) {
                    info.append(student.toString()).append("\n");
                }


                JTextArea infoTextArea = new JTextArea(info.toString());
                infoTextArea.setEditable(false);

                
                JScrollPane scrollPane = new JScrollPane(infoTextArea);

                
                JOptionPane.showMessageDialog(null, scrollPane, "Informações", JOptionPane.PLAIN_MESSAGE);
            
          
        
        	}});
        verificacaoPanel.add(btnNewButton_8);
        
        JButton btnNewButton_9 = new JButton("Verificar Cursos");
        btnNewButton_9.setBounds(445, 203, 251, 81);
        btnNewButton_9.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		StringBuilder info = new StringBuilder();
              
                info.append("\nInformações dos Cursos:\n");
                for (Course course : courseList) {
                    info.append(course.toString()).append("\n");
                }


                JTextArea infoTextArea = new JTextArea(info.toString());
                infoTextArea.setEditable(false);

                
                JScrollPane scrollPane = new JScrollPane(infoTextArea);

                
                JOptionPane.showMessageDialog(null, scrollPane, "Informações", JOptionPane.PLAIN_MESSAGE);
            
          
        
        	}});
        verificacaoPanel.add(btnNewButton_9);

        frame.getContentPane().add(cardPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        cadastrarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        verificarButton.setFont(new Font("Arial", Font.PLAIN, 16));
        cadastrarButton.setForeground(myGrey);
        verificarButton.setForeground(myGrey);
        label.setForeground(new Color(150, 70, 250)); 
        frame.getContentPane().setBackground(myGrey); 
        cadastrarButton.setBackground(new Color(150, 70, 250)); 
        verificarButton.setBackground(new Color(150, 70, 250));
    }
    
    private static boolean camposCadastroPreenchidos(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }    
}