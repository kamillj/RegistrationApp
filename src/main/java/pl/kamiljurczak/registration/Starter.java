package pl.kamiljurczak.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.services.PatientService;
import pl.kamiljurczak.registration.services.VisitService;

@Component
public class Starter implements CommandLineRunner {

    private PatientService patientService;
    private VisitService visitService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        Patient janKowalski = new Patient("Jan", "Kowalski", "75110355782");
        Patient andrzejKania = new Patient("Andrzej", "Kania", "86022466523");
        System.out.println(janKowalski.toString());
        patientService.savePatient(janKowalski);
        patientService.savePatient(andrzejKania);
    }
}
