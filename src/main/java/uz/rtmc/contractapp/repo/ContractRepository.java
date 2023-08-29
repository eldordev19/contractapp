package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.rtmc.contractapp.model.Contract;

import java.util.List;
import java.util.UUID;

public interface ContractRepository extends JpaRepository<Contract, UUID> {

    @Query(nativeQuery = true, value = "select c.id, c.name, c.debt, c.type_id from contracts c join type t on c.type_id = t.id where c.type_id = :typeId")
    List<Contract> getByTypeId(UUID typeId);

    @Query(nativeQuery = true, value = "select id from contracts where name = :name")
    UUID getByName(String name);
}
