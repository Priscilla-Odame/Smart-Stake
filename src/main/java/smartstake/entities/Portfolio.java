package smartstake.entities;


import javax.persistence.*;

@Entity
@Table(name = "Portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    public Portfolio() {
    }

    public Long getId() {
        return id;
    }
}
