package pl.kamiljurczak.registration.domains.repositories;

import pl.kamiljurczak.registration.domains.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    void savePatient(Patient patient);

    void updatePatient(Patient patient, Integer id);

    Patient getPatient(Integer id);

    void deletePatient(Patient patient);

    List<Patient> getPatients();

    Optional<Patient> getPatientByPesel(String pesel);
}
