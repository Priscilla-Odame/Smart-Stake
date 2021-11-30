package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/portfolio/{id}")
    public Portfolio getPortfolios(@PathVariable Long id) {
        return portfolioService.getPortfolio(id);
    }
}
