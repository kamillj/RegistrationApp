package pl.kamiljurczak.registration.services;

import pl.kamiljurczak.registration.domains.Patient;

import java.util.List;

public interface PatientService {

    void savePatient(Patient patient);

    void updatePatient(int id);

    Patient getPatient(int id);

    void deletePatient(int id);

    List<Patient> getPatients();
}
