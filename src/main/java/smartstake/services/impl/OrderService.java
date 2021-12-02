package smartstake.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smartstake.dto.OrderDto;
import smartstake.entities.Order;
import smartstake.enums.Status;
import smartstake.repositories.OrderRepository;
import smartstake.request.OrderRequest;
import smartstake.services.IOrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public OrderDto createOrder(OrderRequest orderRequest, String orderId) {
        Order order = new Order();

        order.setSide(orderRequest.getSide());
        order.setQuantity(orderRequest.getQuantity());
        order.setPrice(orderRequest.getPrice());
        order.setProduct(orderRequest.getProduct());
        order.setStatus(Status.PENDING);
        order.setId(orderId);

        Order savedOrder = orderRepository.save(order);
        return OrderDto.fromModel(savedOrder);
    }

    @Override
    public OrderDto getOrder(String id) {
        return null;
    }

    @Override
    public OrderDto updateOrder(String id, OrderDto dto) {
       Optional<Order> order = orderRepository.findById(id);

       if (order.isEmpty()) {
           return null;
       }

       Order savedOrder = orderRepository.save(Order.fromDto(dto));

       return OrderDto.fromModel(savedOrder);
    }


    @Override
    public boolean deleteOrder(String id) {
        Optional<Order> order = orderRepository.findById(id);

        if (order.isEmpty()) {
            return false;
        }

        orderRepository.deleteById(id);

        return true;
    }

    @Override
    public List<OrderDto> getOrders() {
        return orderRepository.findAll().stream().map(OrderDto::fromModel).collect(Collectors.toList());
    }
}
