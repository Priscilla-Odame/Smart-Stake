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
    @RequestMapping(value = "/portfolios")
    public List<Portfolio> getAllPortfolios()
    {
        return portfolioService.getAllPortfolios();
    }


    //get portfolio by id
    @RequestMapping(value = "/portfolio/{id}")
    public Optional<Portfolio> getPortfolio(@PathVariable Integer id) {
        return portfolioService.getPortfolio(id);
    }


    //create portfolio
    @RequestMapping(value = "/add/portfolio", method=RequestMethod.POST)
    public void addPortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.addPortfolio(portfolio);
    }


    //update portfolio
    @RequestMapping(value = "/update/portfolio/{id}", method = RequestMethod.PUT)
    public void updatePortfolio(@RequestBody Portfolio portfolio,@PathVariable Integer id ) {
        portfolioService.updatePortfolio(id, portfolio);
    }


    //delete portfolio
    @RequestMapping(value = "/delete/portfolio/{id}", method = RequestMethod.DELETE)
    public void deletePortfolio(@PathVariable Integer id) {
        portfolioService.deletePortfolio(id);

    }
}
