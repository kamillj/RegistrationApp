package pl.kamiljurczak.registration.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kamiljurczak.registration.domains.Clinic;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.domains.Visit;

@Configuration
public class ApplicationConfig {

    @Bean
    public Patient patient(){
        return new Patient();
    }

    @Bean
    public Visit visit(){
        return new Visit();
    }

    @Bean
    public Clinic clinic(){
        return new Clinic();
    }
}
