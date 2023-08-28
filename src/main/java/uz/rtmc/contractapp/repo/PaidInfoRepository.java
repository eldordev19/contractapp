package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rtmc.contractapp.model.PaidInfo;

import java.util.UUID;

public interface PaidInfoRepository extends JpaRepository<PaidInfo, UUID> {
}
