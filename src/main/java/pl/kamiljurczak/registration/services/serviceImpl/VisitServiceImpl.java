package pl.kamiljurczak.registration.services.serviceImpl;

import org.springframework.stereotype.Service;
import pl.kamiljurczak.registration.domains.Visit;
import pl.kamiljurczak.registration.services.VisitService;

import java.util.Set;

@Service
public class VisitServiceImpl implements VisitService {
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
