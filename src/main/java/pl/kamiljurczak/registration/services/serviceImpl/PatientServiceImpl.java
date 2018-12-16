package pl.kamiljurczak.registration.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.repositories.PatientRepository;
import pl.kamiljurczak.registration.services.PatientService;


import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public void updatePatient(int id) {

    }

    @Override
    public Patient getPatient(int id) {
        return null;
    }

    @Override
    public void deletePatient(int id) {

    }

    @Override
    public List<Patient> getPatientList() {
        return null;
    }
}
