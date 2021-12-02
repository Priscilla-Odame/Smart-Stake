package smartstake.entities;


import javax.persistence.*;

@Entity
@Table(name = "Portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    @ManyToOne(optional = false)
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    public Portfolio() {
    }

    public Portfolio(Long id, Client client, String name, String description) {
        this.id = id;
        this.client = client;
        this.name = name;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
