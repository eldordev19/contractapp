package uz.rtmc.contractapp.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.ContractService;
import uz.rtmc.contractapp.service.TypeService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/con")
public class ContractController {

    @Autowired
    ContractService contractService;

    @Autowired
    TypeService typeService;

    @GetMapping("/by-type/{typeId}")
    public String getContractsByType(Model model, @PathVariable String typeId) {
        List<Contract> contracts = contractService.getContractsByTypeId(typeId);
        model.addAttribute("contracts", contracts);
        model.addAttribute("typeId", typeId);
        return "contract/view";
    }

    @GetMapping("/add/{typeId}")
    public String getAddPage(Model model, @PathVariable String typeId) {
        Contract contract = new Contract();
        Type type = typeService.getTypeById(typeId);
        contract.setType(type);

        model.addAttribute("contract", contract);
        return "contract/contract-add-page";
    }

    @PostMapping("/add-finish")
    public void addFinish(@ModelAttribute("contract") Contract contract, HttpServletResponse response) throws IOException {
        contractService.addContract(contract);
        response.sendRedirect("/pc/finishTask/" + contract.getType().getId() + "");
    }
}
