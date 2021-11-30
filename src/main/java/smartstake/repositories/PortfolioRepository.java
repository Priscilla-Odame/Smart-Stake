package smartstake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import smartstake.entities.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

}
