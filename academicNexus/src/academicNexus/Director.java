package academicNexus;

public class Director extends Academic {
	
	private static final long serialVersionUID = 1l;
	
    public Director(String name, String email, int ID, String CPF, String inscriptionDate) {
        super(name, email, ID, CPF, inscriptionDate);
    }

	@Override
	public String toString() {
		return getName() + "\nEmail:" + getEmail() + "\nID: " + getID()
				+ "\nCPF: " + getCPF() + "\nData de inscrição: " + getInscriptionDate();
	}
}

