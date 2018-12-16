package pl.kamiljurczak.registration.domains.repositories;

import pl.kamiljurczak.registration.domains.Visit;

import java.util.Set;

public interface VisitRepository {

    void saveVisit(Visit visit);

    void updateVisit(int id);

    Visit getVisit(int id);

    void deleteVisit(int id);

    Set<Visit> getVisits();
}
