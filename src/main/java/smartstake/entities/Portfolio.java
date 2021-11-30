package smartstake.entities;


import javax.persistence.*;

@Entity
@Table(name = "Portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String name;
    private String description;


    @ManyToOne
    private Client client;

    public Portfolio() {
    }

    public Portfolio(String ID, Client client, String name, String description) {
        this.ID = ID;
        this.client = client;
        this.name = name;
        this.description = description;
    }

    public void setId(String ID) {
        this.ID = ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getId() {
        return ID;
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
