package pl.kamiljurczak.registration.domains.repositories.repositoriesImpl;

import org.springframework.stereotype.Repository;
import pl.kamiljurczak.registration.domains.Visit;
import pl.kamiljurczak.registration.domains.repositories.VisitRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

@Repository
public class VisitRepositoryImpl implements VisitRepository {

    private EntityManager em;

    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveVisit(Visit visit) {

    }

    @Override
    public void updateVisit(int id) {

    }

    @Override
    public Visit getVisit(int id) {
        return null;
    }

    @Override
    public void deleteVisit(int id) {

    }

    @Override
    public Set<Visit> getVisits() {
        return null;
    }
}
