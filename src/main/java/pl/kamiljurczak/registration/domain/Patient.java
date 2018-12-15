package pl.kamiljurczak.registration.domain;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private int id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String city;
    private String zipCode;
    private String address;
    private String country;
    private List<Visit> visitList = new ArrayList<>();

    public Patient(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public void bookForAnVisit(Visit visit) {
        visitList.add(visit);
    }

    private String getAllPatientsVisits() {
        StringBuilder visitListString = new StringBuilder();
        for (Visit visit : visitList) {
            visitListString.append("\n").append(visit.getClinic().toString()).append(": ").append(visit.toString());
        }
        return visitListString.toString();
    }

    @Override
    public String toString() {
        return "Pacjent: " + firstName + " " + lastName + " (" + pesel + ")." + "\nZaplanowane wizyty:" + getAllPatientsVisits();
    }
}
