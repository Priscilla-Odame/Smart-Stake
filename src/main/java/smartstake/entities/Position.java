package smartstake.entities;

import javax.persistence.*;

@Entity
@Table(name = "Positions")
public class Position {

    @Id
    @GeneratedValue
    private Long id;

    private int quantity;
    private String ticker;


    @ManyToOne
    private Portfolio portfolio;

    public Position() {
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

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
