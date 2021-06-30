package ch.bbw.na.player.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Entity")
@NamedQuery(name = "Entity.findAll", query = "SELECT e FROM Entity e")
public class Entity {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "hp")
    private int hp;

    @Column(name = "aa")
    private int aa;

    @Column(name = "block")
    private double block;

    @Column(name = "special")
    private String special;

    @Column(name = "ult")
    private String ult;

    @Column(name = "ultbar")
    private int ultbar;

    @Column(name = "ultdmg")
    private int ultdmg;

    @Column(name = "specialdmg")
    private int specialdmg;

    @Column(name = "element")
    private String element;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotFound(action = NotFoundAction.IGNORE)
    private Items item;

    public Entity() {}

    public Entity(int id, String name, int hp, int aa, double block, String special, String ult, int ultbar, int ultdmg, int specialdmg, String element) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.aa = aa;
        this.block = block;
        this.special = special;
        this.ult = ult;
        this.ultbar = ultbar;
        this.ultdmg = ultdmg;
        this.specialdmg = specialdmg;
        this.element = element;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", aa=" + aa +
                ", block=" + block +
                ", special='" + special + '\'' +
                ", ult='" + ult + '\'' +
                ", ultbar=" + ultbar +
                ", ultdmg=" + ultdmg +
                ", specialdmg=" + specialdmg +
                ", element='" + element + '\'' +
                ", item=" + item +
                '}';
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAa() {
        return aa;
    }

    public void setAa(int aa) {
        this.aa = aa;
    }

    public double getBlock() {
        return block;
    }

    public void setBlock(double block) {
        this.block = block;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getUlt() {
        return ult;
    }

    public void setUlt(String ult) {
        this.ult = ult;
    }

    public int getUltbar() {
        return ultbar;
    }

    public void setUltbar(int ultbar) {
        this.ultbar = ultbar;
    }

    public int getUltdmg() {
        return ultdmg;
    }

    public void setUltdmg(int ultdmg) {
        this.ultdmg = ultdmg;
    }

    public int getSpecialdmg() {
        return specialdmg;
    }

    public void setSpecialdmg(int specialdmg) {
        this.specialdmg = specialdmg;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
