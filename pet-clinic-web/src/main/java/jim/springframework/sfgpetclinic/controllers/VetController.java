package jim.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    public static final String BASE_URL = "/vets";

    @RequestMapping({VetController.BASE_URL, VetController.BASE_URL +"/index", VetController.BASE_URL+"/index.html"})
    public String listVets() {
        return "vets/index";
    }

}
