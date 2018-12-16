package pl.kamiljurczak.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.Visit;
import pl.kamiljurczak.registration.domains.repositories.repositoriesImpl.PatientRepositoryImpl;
import pl.kamiljurczak.registration.services.serviceImpl.PatientServiceImpl;

@Component
public class Starter implements CommandLineRunner {

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

    }
}
