package pl.kamiljurczak.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pl.kamiljurczak.registration.domain.Clinic;
import pl.kamiljurczak.registration.domain.Patient;
import pl.kamiljurczak.registration.domain.Visit;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan({"pl.kamiljurczak.registration"})
public class RegistrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(RegistrationApplication.class, args);
        String[] beans = ctx.getBeanDefinitionNames();
        for (String bean : beans) {
            if (ctx.getBean(bean).getClass().toString().contains("pl.kamiljurczak")) {
                Object beanTemp = ctx.getBean(bean);
                System.out.println("bean: " + beanTemp.getClass().getSimpleName());
            }
        }
    }

}

