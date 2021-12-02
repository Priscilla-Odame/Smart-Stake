package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartstake.entities.Portfolio;
import smartstake.services.PortfolioService;
import java.util.List;
import java.util.Optional;

@RestController
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    //get all portfolios
    @GetMapping(value = "/portfolios")
    public List<Portfolio> getAllPortfolios()
    {
        return portfolioService.getAllPortfolios();
    }


    //get portfolio by id
    @GetMapping(value = "/portfolio/{id}")
    public Optional<Portfolio> getPortfolio(@PathVariable Long id) {
        return portfolioService.getPortfolio(id);
    }


    //create portfolio
    @PostMapping(value = "/add/portfolio")
    public void addPortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.addPortfolio(portfolio);
    }


    //update portfolio
    @PutMapping(value = "/update/portfolio/{id}")
    public void updatePortfolio(@RequestBody Portfolio portfolio,@PathVariable Long id ) {
        portfolioService.updatePortfolio(id, portfolio);
    }


    //delete portfolio
    @DeleteMapping(value = "/delete/portfolio/{id}")
    public void deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);

    }
}
