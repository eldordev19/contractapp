package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rtmc.contractapp.model.Contract;

import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {

}
