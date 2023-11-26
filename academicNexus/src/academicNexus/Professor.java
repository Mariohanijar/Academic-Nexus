package academicNexus;

public class Professor extends Academic {
    
	private static final long serialVersionUID = 1l;
	
    public Professor(String name, String email, int ID, String CPF, String inscriptionDate) {
        super(name, email, ID, CPF, inscriptionDate);
    }

	@Override
	public String toString() {
		return "Professor " + getName() + ", email: " + getEmail() + ", ID: " + getID()
				+ ", CPF: " + getCPF() + ", inscription date: " + getInscriptionDate() ;
	}
    
}

