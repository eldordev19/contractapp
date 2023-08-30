package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.rtmc.contractapp.model.PaidInfo;

import java.util.List;
import java.util.UUID;

public interface PaidInfoRepository extends JpaRepository<PaidInfo, UUID> {
    @Query(nativeQuery = true, value = "select p.id, p.contract_id, p.is_paid, p.month_id from payment p " +
            "    join months m on p.month_id = m.id " +
            "where p.contract_id = :contractId")
    List<PaidInfo> getPaidInfoByContractId(UUID contractId);
}
