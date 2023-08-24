package uz.rtmc.contractapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.model.Month;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.repo.ContractRepository;

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

    public List<Contract> getContractsByTypeId(String typeId) {

        return contractRepository.getByTypeId(UUID.fromString(typeId));
    }

    public void addContract(Contract contract) {
        List<Month> months = monthRepository.findAll();
        contract.setMonths(months);
        contractRepository.save(contract);
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
