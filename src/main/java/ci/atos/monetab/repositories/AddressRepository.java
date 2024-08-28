package ci.atos.monetab.repositories;

import ci.atos.monetab.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
