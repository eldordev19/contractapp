package uz.rtmc.contractapp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rtmc.contractapp.model.Month;

import java.util.UUID;

public interface MonthRepository extends JpaRepository<Month, UUID> {
}
