package uz.rtmc.contractapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.rtmc.contractapp.dto.ContractMonthDto;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.model.Month;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.repo.ContractRepository;
import uz.rtmc.contractapp.repo.PaidInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    MonthRepository monthRepository;

    @Autowired
    TypeService typeService;

    @Autowired
    PaidInfoRepository infoRepository;

    public List<Contract> getContractsByTypeId(String typeId) {

        return contractRepository.getByTypeId(UUID.fromString(typeId));
    }

    public void addContract(ContractMonthDto dto) {
        List<Month> months = new ArrayList<>();
        Type type = typeService.getTypeById(String.valueOf(dto.getType()));
        Contract contract = new Contract(null, dto.getName(), dto.getDebt(), type, months);
        addPayment(dto);
        contractRepository.save(contract);
    }

    public void addPayment(ContractMonthDto dto) {
//        if (dto.getJanuary() = )
    }

    public String deleteContract(String contractId) {
        Type type = typeService.getTypeByContractId(contractId);
        contractRepository.deleteById(UUID.fromString(contractId));
        return String.valueOf(type.getId());
    }

    public Contract getContractById(String contractId) {
        return contractRepository.findById(UUID.fromString(contractId)).get();
    }
}
