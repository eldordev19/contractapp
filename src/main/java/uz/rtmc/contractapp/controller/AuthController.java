package uz.rtmc.contractapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import uz.rtmc.contractapp.model.LoginRequest;

import java.io.IOException;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/loginPost")
    public void Login(@ModelAttribute("loginRequest") LoginRequest loginRequest) {
    }
}
