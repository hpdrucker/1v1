package ch.bbw.na.player.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@javax.persistence.Entity
@Table(name = "Items")
@NamedQuery(name = "Items.findAll", query="SELECT e FROM Items e")
public class Items {

    @Id
    @Column(name ="id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "item")
    private Collection<Entity> entities = new ArrayList<Entity>();

    public Items() {
    }

    public Items(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
