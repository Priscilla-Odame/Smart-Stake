package smartstake.dto;

import lombok.*;
import smartstake.entities.Order;
import smartstake.entities.Portfolio;
import smartstake.enums.Side;
import smartstake.enums.Status;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private String id;

    private String product;

    private int quantity;

    private Double price;

    private Side side;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Portfolio portfolio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public static OrderDto fromModel(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setPrice(order.getPrice());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setProduct(order.getProduct());
        orderDto.setSide(order.getSide());

        return orderDto;
    }


}
