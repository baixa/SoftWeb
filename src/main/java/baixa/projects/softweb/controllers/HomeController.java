package baixa.projects.softweb.controllers;

import baixa.projects.softweb.classes.Application;
import baixa.projects.softweb.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping
@Controller
public class HomeController {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public HomeController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(applications::add);
        fillFeatured(model, applications);
        fillStable(model, applications);
        fillSWUR(model, applications);
        fillOfficial(model, applications);
    }

    private void fillFeatured(Model model, List<Application> applications) {
        model.addAttribute("featuredApp1", applications.get(6));
        model.addAttribute("featuredApp2", applications.get(12));
        model.addAttribute("featuredApp3", applications.get(18));
    }

    private void fillStable(Model model, List<Application> applications) {
        List<Application> featured = applications.stream().filter(application -> application.getDeveloper().getUsername().equals("Stable")).collect(Collectors.toList());
        model.addAttribute("featuredApp4", featured.get(0));
        model.addAttribute("featuredApp5", featured.get(1));
        model.addAttribute("featuredApp6", featured.get(2));
    }

    private void fillSWUR(Model model, List<Application> applications) {
        List<Application> featured = applications.stream().filter(application -> application.getDeveloper().getUsername().equals("SWUR")).collect(Collectors.toList());
        model.addAttribute("featuredApp7", featured.get(0));
        model.addAttribute("featuredApp8", featured.get(1));
        model.addAttribute("featuredApp9", featured.get(2));
    }

    private void fillOfficial(Model model, List<Application> applications) {
        List<Application> featured = applications.stream().filter(application -> application.getDeveloper().getUsername().equals("Official")).collect(Collectors.toList());
        model.addAttribute("featuredApp10", featured.get(0));
        model.addAttribute("featuredApp11", featured.get(1));
        model.addAttribute("featuredApp12", featured.get(2));
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
