package pl.kamiljurczak.registration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamiljurczak.registration.domains.Patient;

@Controller
public class PatientController {

    @RequestMapping("/registration")
    public String getPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }
}
