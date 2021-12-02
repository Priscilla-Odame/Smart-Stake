package smartstake.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import smartstake.dto.OrderDto;
import smartstake.entities.Order;
import smartstake.repositories.OrderRepository;
import smartstake.request.OrderRequest;
import smartstake.services.IOrderService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    private final String EXCHANGE_URL = "https://exchange.matraining.com";
    private final String API_KEY = "a7849689-214b-4ec6-860d-b32603e76859";

    @GetMapping("/orders")
    @ResponseStatus(code = HttpStatus.OK)
    public List<OrderDto> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping( "/orders/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderRequest orderRequest) {
        ResponseEntity<String> oid = restTemplate.postForEntity(EXCHANGE_URL + "/" + API_KEY + " /order", orderRequest, String.class);
        String orderId = oid.getBody().replaceAll("\"", "");
        OrderDto orderDto = orderService.createOrder(orderRequest, orderId);
        return new ResponseEntity<>(orderDto, HttpStatus.CREATED);
    }

    @GetMapping("/orders/{id}")
    public ExchangeOrder getOrders(@PathVariable String id){
        ExchangeOrder exchangeOrder = restTemplate.getForObject(String.format("%s/%s/order/%s", EXCHANGE_URL, API_KEY, id), ExchangeOrder.class);
        return exchangeOrder;
    }

    @PutMapping(path = "/orders/update/{id}")
    public ResponseEntity<OrderDto> updateOrder(@RequestBody String id, OrderDto dto){
        return null;
    }

    @DeleteMapping("/orders/delete/{id}")
    public String deletedOrder(@PathVariable("id") String id){
        restTemplate.delete( EXCHANGE_URL + "/" + API_KEY +"/order/" + id);
        orderService.deleteOrder(id);
        return "Successful deleted";
    }
}


class Execution {
    private String timestamp;
    private double price;
    private int quantity;

    public Execution() {}

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ExchangeOrder {

    private String product;
    private int quantity;
    private double price;
    private String side;
    private List<Execution> executions;
    private int cumulativeQuantity;

    public ExchangeOrder() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public List<Execution> getExecutions() {
        return executions;
    }

    public void setExecutions(List<Execution> executions) {
        this.executions = executions;
    }

    public int getCumulativeQuantity() {
        return cumulativeQuantity;
    }

    public void setCumulativeQuantity(int cumulativeQuantity) {
        this.cumulativeQuantity = cumulativeQuantity;
    }
}
