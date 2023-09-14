package uz.rtmc.contractapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.TypeService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeService typeService;

//    @GetMapping("/all")
//    public String getAllTypes(Model model) {
//        List<TypeDto> types = typeService.getAllTypes();
//
//        model.addAttribute("types", types);
//        return "type/view";
//    }

//    @GetMapping("/add")
//    public String getAddPage(Model model) {
//
//        model.addAttribute("type", new Type());
//        return "type/type-add-page";
//    }

    @PostMapping("/add-type")
    public String addType(@ModelAttribute("type") Type type) {
        typeService.addType(type);
        return "redirect:/";
    }

//    @GetMapping("/edit/{typeId}")
//    public String getEditPage(@PathVariable String typeId, Model model) {
//        Type type = typeService.getTypeById(typeId);
//        model.addAttribute("type", type);
//        return "type/type-edit-page";
//    }

    @PostMapping("/edit-finish")
    public String editFinish(@RequestParam(name = "id", required = false) UUID id,
                             @RequestParam(name = "name") String name) {
        typeService.editType(id, name);
        return "redirect:/";
    }

    @GetMapping("/delete/{typeId}")
    public String deleteType(@PathVariable String typeId) {
        typeService.deleteType(typeId);
        return "redirect:/";
    }

}
