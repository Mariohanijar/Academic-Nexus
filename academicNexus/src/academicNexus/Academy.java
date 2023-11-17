package academicNexus;

public abstract class Academy {
    private String name;
    private int ID;
    private int yearOfFoundation;

    public Academy(String name, int ID, int yearOfFoundation) {
        this.name = name;
        this.ID = ID;
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public void setID(int ID) {
        if (ID > 0) {
            this.ID = ID;
        }
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        if (yearOfFoundation > 0) {
            this.yearOfFoundation = yearOfFoundation;
        }
    }
}

