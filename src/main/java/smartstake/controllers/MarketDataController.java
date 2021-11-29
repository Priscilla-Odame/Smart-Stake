package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/market-data")
public class MarketData {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<MarketData> getMarketData() {
        List<MarketData> marketData = restTemplate.getForObject("https://exchange.matraining.com/md", List.class);
        return marketData;
    }
}
