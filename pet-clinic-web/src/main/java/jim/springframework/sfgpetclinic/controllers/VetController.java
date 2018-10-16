package jim.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(VetController.BASE_URL)
@Controller
public class VetController {

    public static final String BASE_URL = "/vets";

    @RequestMapping({"", "/index", "/index.html"})
    public String listVets() {
        return "vets/index";
    }

}
