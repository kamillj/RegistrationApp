package pl.kamiljurczak.registration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.services.PatientService;

import java.util.List;

@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

//    @RequestMapping
//    public String getPatientsList(Model model) {
//        List<Patient> patients = patientService.getPatientList();
//        model.addAttribute("patients", patients);
//        return "patients";
//    }

    @RequestMapping("/patient/add")
    public String getPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "patientForm";
    }
}
