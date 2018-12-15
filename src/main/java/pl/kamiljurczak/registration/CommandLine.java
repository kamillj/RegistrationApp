package pl.kamiljurczak.registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kamiljurczak.registration.domain.Patient;

@Component
public class CommandLine implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient("Jan", "Kowalski", "78081455672");
        System.out.println(patient);
    }
}
