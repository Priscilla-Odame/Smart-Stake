package smartstake.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import smartstake.entities.Client;
import smartstake.entities.Portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PortfolioService {

    //List all portfolios
    Portfolio portfolio1 = new Portfolio(
            "1",
            new Client(1,"Priscilla","Odame","1234","admin@gmail.com"),
            "stock",
            "50% shares from MSOFT and 20% from AAPL"
    );
    Portfolio portfolio2 = new Portfolio(
            "2",
            new Client(1,"Jeff","Asmah","1234","admin@gmail.com"),
            "stock",
            "20% shares from AAPL and 20% from MSOFT"
    );

    private List<Portfolio> portfolios = new ArrayList<>(Arrays.asList(portfolio1, portfolio2));

    public List<Portfolio> getAllPortfolios() {
        return portfolios;
    }

    //Get a portfolio by id
    public Portfolio getPortfolio(String ID) {
        Portfolio portfolio = portfolios.stream()
                .filter(t -> ID.equals(t.getId()))
                .findFirst()
                .orElse(null);

        return portfolio;
    }

    //Create a portfolio
    public void addPortfolio(Portfolio portfolio) {
        portfolios.add(portfolio);
    }

    //Update portfolio
    public void updatePortfolio(String ID, Portfolio portfolio) {
        for(int i = 0; i < portfolios.size(); i++) {
            Portfolio p = portfolios.get(i);

            if (p.getId().equals(ID)) {
                portfolios.set(i, portfolio);
            }
        }
    }

    //delete portfolio
    public void deletePortfolio(String ID) {
        portfolios.removeIf(t -> t.getId().equals(ID));
    }
}
