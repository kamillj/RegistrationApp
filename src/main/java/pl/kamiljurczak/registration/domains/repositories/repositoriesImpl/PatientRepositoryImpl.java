package pl.kamiljurczak.registration.domains.repositories.repositoriesImpl;

import org.springframework.stereotype.Repository;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.repositories.PatientRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public class PatientRepositoryImpl implements PatientRepository {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        em.persist(patient);
    }

    @Override
    @Transactional
    public void updatePatient(Patient patient, Integer id) {
        Patient patientTmp = em.find(Patient.class, id);
        patientTmp.setFirstName(patient.getFirstName());
        patientTmp.setLastName(patient.getLastName());
        patientTmp.setPesel(patient.getPesel());
        patientTmp.setCountry(patient.getCountry());
        patientTmp.setCity(patient.getCity());
        patientTmp.setZipCode(patient.getZipCode());
        patientTmp.setAddress(patient.getAddress());
        em.merge(patientTmp);
    }

    @Override
    public Patient getPatient(Integer id) {
        return em.find(Patient.class, id);
    }

    @Override
    @Transactional
    public void deletePatient(Patient patient) {
        em.remove(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return em.createQuery("from Patient p order by p.lastName", Patient.class).getResultList();
    }

    @Override
    public Optional<Patient> getPatientByPesel(String pesel) {
        Patient patient = em.createQuery("from Patient p where p.pesel=:pesel", Patient.class)
                .setParameter("pesel", pesel).getSingleResult();
        return Optional.ofNullable(patient);
    }
}
