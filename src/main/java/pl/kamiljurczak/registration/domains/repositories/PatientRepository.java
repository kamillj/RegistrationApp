package pl.kamiljurczak.registration.domains.repositories;

import pl.kamiljurczak.registration.domains.Patient;

import java.util.List;

public interface PatientRepository {

    void savePatient(Patient patient);

    void updatePatient(int id);

    Patient getPatient(int id);

    void deletePatient(int id);

    List<Patient> getPatientList();
}
