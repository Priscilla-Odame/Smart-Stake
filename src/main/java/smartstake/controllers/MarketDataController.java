package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import smartstake.models.MarketData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/market-data")
public class MarketDataController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public List<MarketData> getMarketData() {
        List<MarketData> marketDataFromExchange = restTemplate.getForObject("https://exchange.matraining.com/md", List.class);
        List<MarketData> marketDataFromExchange2 = restTemplate.getForObject("https://exchange2.matraining.com/md", List.class);
        List<MarketData> allMarketData = Stream.concat(marketDataFromExchange.stream(), marketDataFromExchange2.stream()).collect(Collectors.toList());
        return allMarketData;
    }

}
