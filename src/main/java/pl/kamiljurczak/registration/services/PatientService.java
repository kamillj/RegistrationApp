package pl.kamiljurczak.registration.services;

import pl.kamiljurczak.registration.domains.Patient;

public interface PatientService {

    void savePatient(Patient patient);

    void updatePatient(int id);

    void getPatient(int id);

    void deletePatient(int id);
}
