package uz.rtmc.contractapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.repo.ContractRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    MonthRepository monthRepository;

    public List<Contract> getContractsByTypeId(String typeId) {

        return contractRepository.getByTypeId(UUID.fromString(typeId));
    }

    public void addContract(Contract contract) {

    }
}
