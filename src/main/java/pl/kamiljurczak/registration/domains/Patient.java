package pl.kamiljurczak.registration.domains;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String pesel;
    private String country;
    private String city;
    private String zipCode;
    private String address;

    @OneToMany
    private List<Visit> visits = new ArrayList<>();

    public Patient() {
    }

    public Patient(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public Patient(String firstName, String lastName, String pesel, String country, String city, String zipCode, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.country = country;
        this.city = city;
        this.zipCode = zipCode;
        this.address = address;
    }

    public void bookForAnVisit(Visit visit) {
        visits.add(visit);
    }

    private String getAllPatientsVisits() {
        StringBuilder visitListString = new StringBuilder();
        for (Visit visit : visits) {
            visitListString.append("\n").append(visit.toString());
        }
        return visitListString.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    @Override
    public String toString() {
        return "Pacjent: " + firstName + " " + lastName + " (" + pesel + ")." + "\nZaplanowane wizyty:" + getAllPatientsVisits();
    }
}
