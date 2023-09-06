package uz.rtmc.contractapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.TypeService;

import java.util.List;

@Controller(value = "/")
public class HomeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/")
    public String getAllTypes(Model model) {
        List<TypeDto> typeDtoS = typeService.getAllTypes();

        model.addAttribute("types", typeDtoS);
        return "new-index";
    }
}
