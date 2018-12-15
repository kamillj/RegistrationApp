package pl.kamiljurczak.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.Visit;
import pl.kamiljurczak.registration.domains.repositories.repositoriesImpl.PatientRepositoryImpl;
import pl.kamiljurczak.registration.services.serviceImpl.PatientServiceImpl;

@Component
public class CommandLine implements CommandLineRunner {

    private PatientRepositoryImpl patientRepositoryImpl;
    private PatientServiceImpl patientServiceImpl;

    @Autowired
    public void setPatientServiceImpl(PatientServiceImpl patientServiceImpl) {
        this.patientServiceImpl = patientServiceImpl;
    }

    @Autowired
    public void setPatientRepositoryImpl(PatientRepositoryImpl patientRepositoryImpl) {
        this.patientRepositoryImpl = patientRepositoryImpl;
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient("Jan", "Kowalski", "78081455672");
        Visit visit1 = new Visit("2018-12-16", "10:00", "10:30", "Poradnia alergologiczna");
        Visit visit2 = new Visit("2018-12-20", "11:00", "11:30", "Poradnia laryngologiczna");
        Visit visit3 = new Visit("2018-12-22", "12:00", "12:30", "Poradnia leczenia uzależnień");
        patient.bookForAnVisit(visit1);
        patient.bookForAnVisit(visit2);
        patient.bookForAnVisit(visit3);
        System.out.println(patient);
    }
}
