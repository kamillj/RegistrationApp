package pl.kamiljurczak.registration.configs;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kamiljurczak.registration.domains.repositories.repositoriesImpl.PatientRepositoryImpl;
import pl.kamiljurczak.registration.services.serviceImpl.PatientServiceImpl;


@Configuration
@EntityScan("pl.kamiljurczak.registration.domains")
public class ApplicationConfig {

    @Bean(name = "patientRepositoryImpl")
    public PatientRepositoryImpl createRepository(){
        return new PatientRepositoryImpl();
    }

    @Bean(name = "patientServiceImpl")
    public PatientServiceImpl createService(){
        return new PatientServiceImpl();
    }
}
