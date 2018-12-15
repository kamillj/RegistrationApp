package pl.kamiljurczak.registration.domain;


public class Clinic {

    private int id;
    private String name;

    public Clinic(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
