package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartstake.entities.Portfolio;
import smartstake.services.PortfolioService;
import java.util.List;

@RestController
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value="/portfolios")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @RequestMapping(value = "/portfolio/{ID}")
    public Portfolio getPortfolios(@PathVariable String ID) {
        return portfolioService.getPortfolio(ID);
    }

    //Create a new portfolio
    @RequestMapping(value="/add/portfolio", method= RequestMethod.POST)
    public void addPortfolio(@RequestBody Portfolio portfolio) {
        portfolioService.addPortfolio(portfolio);
    }

    //Update portfolio
    @RequestMapping(value = "/update/portfolio/{ID}", method = RequestMethod.PUT)
    public void updatePortfolio(@RequestBody Portfolio portfolio, @PathVariable String ID) {

        portfolioService.updatePortfolio(ID, portfolio);
    }

    //delete portfolio
    @RequestMapping(value = "/delete/portfolio/{ID}", method = RequestMethod.DELETE)
    public void deletePortfolio(@PathVariable String ID) {
        portfolioService.deletePortfolio(ID);
    }
}
