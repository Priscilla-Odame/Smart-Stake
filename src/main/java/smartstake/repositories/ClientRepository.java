package smartstake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smartstake.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
