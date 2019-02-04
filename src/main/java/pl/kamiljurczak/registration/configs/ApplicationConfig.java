package pl.kamiljurczak.registration.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kamiljurczak.registration.domains.repositories.repositoriesImpl.PatientRepositoryImpl;
import pl.kamiljurczak.registration.domains.repositories.repositoriesImpl.SchedulerRepositoryImpl;
import pl.kamiljurczak.registration.services.serviceImpl.PatientServiceImpl;
import pl.kamiljurczak.registration.services.serviceImpl.SchedulerServiceImpl;


@Configuration
@EntityScan("pl.kamiljurczak.registration.domains")
public class ApplicationConfig {

    @Bean(name = "patientRepositoryImpl")
    public PatientRepositoryImpl createPatientRepository(){
        return new PatientRepositoryImpl();
    }

    @Bean(name = "patientServiceImpl")
    public PatientServiceImpl createPatientService(){
        return new PatientServiceImpl();
    }

    @Bean(name = "schedulerRepositoryImpl")
    public SchedulerRepositoryImpl createSchedulerRepository() {
        return new SchedulerRepositoryImpl();
    }

    @Bean(name = "schedulerServiceImpl")
    public SchedulerServiceImpl createSchedulerService() {
        return new SchedulerServiceImpl();
    }
}
