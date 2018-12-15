package pl.kamiljurczak.registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kamiljurczak.registration.domain.Patient;
import pl.kamiljurczak.registration.domain.Visit;

@Component
public class CommandLine implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient("Jan", "Kowalski", "78081455672");
        Visit visit1 = new Visit("2018-12-16", "10:00", "10:30");
        Visit visit2 = new Visit("2018-12-20", "11:00", "11:30");
        Visit visit3 = new Visit("2018-12-22", "12:00", "12:30");
        patient.bookForAnVisit(visit1);
        patient.bookForAnVisit(visit2);
        patient.bookForAnVisit(visit3);
        System.out.println(patient);
    }
}
