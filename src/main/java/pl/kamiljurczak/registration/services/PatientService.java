package pl.kamiljurczak.registration.services;

import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.validators.FieldValueExists;

import java.util.List;
import java.util.Optional;

public interface PatientService extends FieldValueExists {

    void savePatient(Patient patient);

    void updatePatient(Patient patient, Integer id);

    Patient getPatient(Integer id);

    void deletePatient(Patient patient);

    List<Patient> getPatients();

    Optional<Patient> getPatientByPesel(String pesel);

    boolean isPeselExists(String pesel);
}
