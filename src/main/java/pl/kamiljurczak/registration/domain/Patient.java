package pl.kamiljurczak.registration.domain;

public class Patient {

    private String firstName;
    private String lastName;
    private String pesel;
    private String city;
    private String zipCode;
    private String address;
    private String country;
    private Visit visit;

    public Patient(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.visit = new Visit("2018-12-12", "10:00", "10:30");
    }

    @Override
    public String toString() {
        return "Pacjent: " + firstName + " " + lastName + " (" + pesel + "). Zaplanowana wizyta: " + visit.toString();
    }
}
