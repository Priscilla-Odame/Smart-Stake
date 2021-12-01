package smartstake.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartstake.entities.Client;
import smartstake.entities.Portfolio;
import smartstake.repositories.PortfolioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    public PortfolioRepository portfolioRepository;

    //List all portfolios
    public List<Portfolio> getAllPortfolios() {

        List<Portfolio> portfolios = new ArrayList<>();

        portfolioRepository.findAll()
                .forEach(portfolios::add);

        return portfolios;
    }

    //Get a portfolio by id

    public Optional<Portfolio> getPortfolio(Long id) {
        return portfolioRepository.findById(id);
    }


    //Create a portfolio
    public void addPortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }


    //Update portfolio
    public void updatePortfolio(Long id, Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    //delete portfolio
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

}
