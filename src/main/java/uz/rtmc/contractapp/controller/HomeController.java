package uz.rtmc.contractapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.model.User;
import uz.rtmc.contractapp.service.ContractService;
import uz.rtmc.contractapp.service.TypeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller(value = "/")
public class HomeController {

    @Autowired
    TypeService typeService;

    @Autowired
    ContractService contractService;

    @GetMapping("/")
    public String getAllTypes(Model model, HttpServletResponse response) throws IOException {

        User currentUser = contractService.getCurrentUser();

        if (Objects.equals(currentUser.getRole(), "ROLE_USER")) {
            response.sendRedirect("/client/");
        }
        List<TypeDto> types = typeService.getAllTypes();
        model.addAttribute("type", new Type());
        model.addAttribute("types", types);
        return "index";
    }

}
