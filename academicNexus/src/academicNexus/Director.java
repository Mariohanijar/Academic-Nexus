package academicNexus;

public class Director extends Academic {

    public Director(String name, String email, int ID, String CPF, String inscriptionDate) {
        super(name, email, ID, CPF, inscriptionDate);
    }

	@Override
	public String toString() {
		return "Director " + getName() + ", email:" + getEmail() + ", ID: " + getID()
				+ ", CPF: " + getCPF() + ", inscription date: " + getInscriptionDate();
	}
}

