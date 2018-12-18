package pl.kamiljurczak.registration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kamiljurczak.registration.domains.Patient;
import pl.kamiljurczak.registration.services.PatientService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping("/patients")
    public String getPatientsList(Model model) {
        List<Patient> patients = patientService.getPatients();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @RequestMapping("/patient/add")
    public String getPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }

    @RequestMapping(value = "/patient/add", method = RequestMethod.POST)
    public String savePatient(@ModelAttribute @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + " " + error.getDefaultMessage()));
            return "patientForm";
        } else {
            patientService.savePatient(patient);
        }
        return "redirect:/patients";
    }

    @RequestMapping("/patient/{id}")
    public String getPatient(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.getPatient(id);
        model.addAttribute("patient", patient);
        return "patient";
    }

    @RequestMapping(value = "/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id) {
        patientService.deletePatient(patientService.getPatient(id));
        return "redirect:/patients";
    }

    @RequestMapping(value = "/patient/edit/{id}", method = RequestMethod.POST)
    public String updatePatient(@ModelAttribute @Valid Patient patient, @PathVariable Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + " " + error.getDefaultMessage()));
            return "patient";
        } else {
            patientService.updatePatient(patient, id);
        }
        return "redirect:/patients";
    }
}
