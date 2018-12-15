package pl.kamiljurczak.registration.domains;

public class Clinic {

    private int id;
    private String name;

    public Clinic() {
    }

    public Clinic(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
