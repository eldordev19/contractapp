package uz.rtmc.contractapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.TypeService;

import java.util.List;

@Controller(value = "/type")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/all")
    public String getAllTypes(Model model) {
        List<Type> types = typeService.getAllTypes();

        model.addAttribute("types", types);
        return "";
    }

    @GetMapping("/add")
    public String  getAddPage(Model model) {

        model.addAttribute("type", new Type());
        return "type-add-page";
    }

}
