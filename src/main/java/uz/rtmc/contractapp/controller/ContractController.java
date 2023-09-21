package uz.rtmc.contractapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.rtmc.contractapp.dto.ContractMonthDto;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.service.ContractService;
import uz.rtmc.contractapp.service.TypeService;

import javax.servlet.http.HttpServletResponse;
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
        List<ContractMonthDto> dtoS = contractService.getAllContractSMonthDto(typeId);
        ContractMonthDto dto = new ContractMonthDto();
        Type typeById = typeService.getTypeById(typeId);
        model.addAttribute("dto", dto);
        model.addAttribute("contracts", dtoS);
        model.addAttribute("typeId", typeId);
        model.addAttribute("type_name", typeById.getName());
        return "contract/view-all-contracts";
    }

    @GetMapping("/add/{typeId}")
    public String getAddPage(Model model, @PathVariable String typeId) {
        ContractMonthDto dto = new ContractMonthDto();
        dto.setType(typeId);
        model.addAttribute("typeID", typeId);
        model.addAttribute("dto", dto);
        return "contract/contract-add-page";
    }

    @PostMapping("/add-finish")
    public void addFinish(@ModelAttribute("dto") ContractMonthDto dto, HttpServletResponse response) throws IOException {
        contractService.addContract(dto);
        response.sendRedirect("/con/by-type/" + dto.getType() + "");
    }

    @GetMapping("/edit/{contractId}")
    public String getEditPage(@PathVariable String contractId, Model model) {
        ContractMonthDto dto = contractService.getContractMonthDto(contractId);
        model.addAttribute("dto", dto);
        return "contract/contract-edit-page";
    }

    @PostMapping("/edit-finish")
    public void editFinish(@ModelAttribute("dto") ContractMonthDto dto, HttpServletResponse response) throws IOException {
            contractService.editFinish(dto);
        response.sendRedirect("/con/by-type/" + dto.getType() + "");
    }

    @GetMapping("/delete/{contractId}")
    public void deleteContract(@PathVariable String contractId,HttpServletResponse response) throws IOException {
        String typeId = contractService.deleteContract(contractId);
        response.sendRedirect("/con/by-type/" + typeId + "");
    }
}
