package jim.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(OwnerController.BASE_URL)
@Controller
public class OwnerController {

    public static final String BASE_URL = "/owners";

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
