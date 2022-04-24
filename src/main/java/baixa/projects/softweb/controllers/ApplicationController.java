package baixa.projects.softweb.controllers;

import baixa.projects.softweb.classes.Application;
import baixa.projects.softweb.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequestMapping
@Controller
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/application")
    public String application(@RequestParam String id, Model model) {
        List<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(applications::add);
        Application current = applications.stream().filter(app -> Objects.equals(app.getId(), Long.parseLong(id))).findFirst().orElse(null);
        model.addAttribute("app", current);
        return "application";
    }
}
