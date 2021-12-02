package smartstake.services;

import org.springframework.stereotype.Component;
import smartstake.dto.OrderDto;
import smartstake.request.OrderRequest;

import java.util.List;

@Component
public interface IOrderService {

    OrderDto createOrder(OrderRequest orderRequest, String orderId);

    OrderDto updateOrder(String id, OrderDto dto);

    OrderDto getOrder(String id);

    boolean deleteOrder(String id);

    List<OrderDto> getOrders();

}
