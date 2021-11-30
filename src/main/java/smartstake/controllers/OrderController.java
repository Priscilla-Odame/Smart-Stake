package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import smartstake.entities.Order;
import smartstake.repositories.OrderRepository;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

//    @GetMapping("/orders")
//    public List<Order> getOrders(){
//
//    }
}
