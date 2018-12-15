package pl.kamiljurczak.registration.domains.repositories;

import pl.kamiljurczak.registration.domains.Patient;

public interface PatientRepository {

    void savePatient(Patient patient);

    void updatePatient(int id);

    void getPatient(int id);

    void deletePatient(int id);
}
