package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.projection.TypeProjection;

import java.util.List;
import java.util.UUID;

public interface TypeRepository extends JpaRepository<Type, UUID> {
    @Query(nativeQuery = true, value = "select t.id, t.name from type t " +
            "join contracts c on t.id = c.type_id " +
            "where c.id = :contractId")
    Type findByContractId(UUID contractId);

    @Query(nativeQuery = true, value = "select t.name as name, t.id as id from type t")
    List<TypeProjection> getAllTypeWithCount();

    @Query(nativeQuery = true, value = "select count(*) from contracts c " +
            "    join type t on c.type_id = t.id " +
            "where t.id = :id")
    int getContractCountsByTypeId(UUID id);
}
