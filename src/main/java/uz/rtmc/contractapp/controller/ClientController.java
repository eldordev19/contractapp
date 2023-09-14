package uz.rtmc.contractapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.rtmc.contractapp.dto.ContractMonthDto;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.ContractService;
import uz.rtmc.contractapp.service.TypeService;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    TypeService typeService;

    @Autowired
    ContractService contractService;

    @GetMapping("/")
    public String getAllTypes(Model model) {
        List<TypeDto> types = typeService.getAllTypes();
        model.addAttribute("type", new Type());
        model.addAttribute("types", types);
        return "index-client";
    }

//    @GetMapping("/by-type/{typeId}")
//    public String getContractsByType(Model model, @PathVariable String typeId) {
//        List<ContractMonthDto> dtoS = contractService.getAllContractSMonthDto(typeId);
//        ContractMonthDto dto = new ContractMonthDto();
//        model.addAttribute("dto", dto);
//        model.addAttribute("contracts", dtoS);
//        model.addAttribute("typeId", typeId);
//        return "contract/view-all-contracts";
//    }
}
