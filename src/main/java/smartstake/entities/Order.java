package smartstake.entities;
import smartstake.otherClasses.Side;
import smartstake.otherClasses.Status;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private String ticker;

    @Enumerated(EnumType.STRING)
    private Side side;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Portfolio portfolio;

    public Order(int quantity, Side side) {
        this.quantity = quantity;
        this.side = side;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}
