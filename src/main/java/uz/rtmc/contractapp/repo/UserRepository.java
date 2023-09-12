package uz.rtmc.contractapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.rtmc.contractapp.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}
