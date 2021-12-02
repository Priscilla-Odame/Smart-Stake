package smartstake.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import smartstake.enums.Side;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    @NotNull
    private String product;

    @NotNull
    private int quantity;

    @NotNull
    private Double price;


    @Enumerated(EnumType.STRING)
    private Side side;


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
}
