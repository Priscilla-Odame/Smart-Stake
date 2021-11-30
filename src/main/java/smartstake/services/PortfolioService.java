package smartstake.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import smartstake.entities.Client;
import smartstake.entities.Portfolio;

import java.util.Arrays;
import java.util.List;

@Service
public class PortfolioService {

    public List<Portfolio> getAllPortfolios() {
        Portfolio portfolio1 = new Portfolio(
                1L,
                new Client(1,"Priscilla","Odame","1234","admin@gmail.com")
        );
        Portfolio portfolio2 = new Portfolio(
                2L,
                new Client(1,"Jeff","Asmah","1234","admin@gmail.com")
        );

        return Arrays.asList(portfolio1, portfolio2);

    }

    public Portfolio getPortfolio(Long id) {
        Portfolio portfolio = getAllPortfolios().stream()
                .filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);

        return portfolio;
    }
//    public void addLocation(Portfolio portfolio) {
//        portfolios.add(portfolio);
//    }
}
