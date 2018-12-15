package pl.kamiljurczak.registration.domain;

import org.springframework.stereotype.Component;

@Component
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

    @Override
    public String toString() {
        return name;
    }
}
