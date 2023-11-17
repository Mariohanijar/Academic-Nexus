package academicNexus;

public abstract class Academic {
    private String name;
    private String email;
    private int ID;
    private String CPF;
    private String inscriptionDate;

    public Academic(String name, String email, int ID, String CPF, String inscriptionDate) {
        this.name = name;
        this.email = email;
        this.ID = ID;
        this.CPF = CPF;
        this.inscriptionDate = inscriptionDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getID() {
        return ID;
    }

    public String getCPF() {
        return CPF;
    }

    public String getInscriptionDate() {
        return inscriptionDate;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if (email.length() > 0) {
            this.email = email;
        }
    }

    public void setID(int ID) {
        if (ID > 0) {
            this.ID = ID;
        }
    }

    public void setCPF(String CPF) {
        if (CPF.length() > 0) {
            this.CPF = CPF;
        }
    }

    public void setInscriptionDate(String inscriptionDate) {
        if (inscriptionDate.length() > 0) {
            this.inscriptionDate = inscriptionDate;
        }
    }
}

