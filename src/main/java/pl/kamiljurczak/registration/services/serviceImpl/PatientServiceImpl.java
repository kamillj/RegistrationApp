package pl.kamiljurczak.registration.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.repositories.PatientRepository;
import pl.kamiljurczak.registration.services.PatientService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        patientRepository.savePatient(patient);
    }

    @Override
    public void updatePatient(Patient patient, Integer id) {
        patientRepository.updatePatient(patient, id);
    }

    @Override
    public Patient getPatient(Integer id) {
        return patientRepository.getPatient(id);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.deletePatient(patient);
    }

    @Override
    public List<Patient> getPatients() {
       return patientRepository.getPatients();
    }

    @Override
    public Optional<Patient> getPatientByPesel(String pesel) {
        return patientRepository.getPatientByPesel(pesel);
    }

    @Override
    public boolean isPeselExists(String pesel) {
        return patientRepository.isPeselExists(pesel);
    }

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);
        if (!fieldName.equals("pesel")) {
            throw new UnsupportedOperationException("Field name not supported");
        }
        return value != null && patientRepository.isPeselExists((String) value);
    }


}
