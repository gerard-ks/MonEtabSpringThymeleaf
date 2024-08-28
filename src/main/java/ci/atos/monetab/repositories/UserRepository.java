package ci.atos.monetab.repositories;

import ci.atos.monetab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
