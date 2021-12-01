package smartstake.repositories;

import org.springframework.data.repository.CrudRepository;
import smartstake.entities.Portfolio;

public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
}
