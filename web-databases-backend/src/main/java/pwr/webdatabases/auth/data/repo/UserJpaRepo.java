package pwr.webdatabases.auth.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.webdatabases.auth.data.model.User;

import java.util.Optional;

public interface UserJpaRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
