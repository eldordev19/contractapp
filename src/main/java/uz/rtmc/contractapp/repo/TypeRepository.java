package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rtmc.contractapp.model.Type;

import java.util.UUID;

public interface TypeRepository extends JpaRepository<UUID, Type> {
}
