package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.rtmc.contractapp.model.Type;

import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {
    @Query(nativeQuery = true, value = "select t.id, t.name from type t " +
            "join contracts c on t.id = c.type_id " +
            "where c.id = :contractId")
    Type findByContractId(UUID contractId);
}
