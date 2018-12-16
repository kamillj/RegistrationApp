package pl.kamiljurczak.registration.domains.repositories.repositoriesImpl;

import org.springframework.stereotype.Repository;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.repositories.PatientRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;


@Repository
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
    public List<Patient> getPatients() {
        return em.createQuery("from Patient as p order by p.lastName", Patient.class).getResultList();
    }
}
