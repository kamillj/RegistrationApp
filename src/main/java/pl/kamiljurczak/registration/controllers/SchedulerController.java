package pl.kamiljurczak.registration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kamiljurczak.registration.services.SchedulerService;

@Controller
public class SchedulerController {

    private SchedulerService schedulerService;

    @Autowired
    public void setSchedulerService(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @RequestMapping("/registration")
    public String showSchedulerWithActualDate(Model model) {
        return "scheduler";
    }
}
