package pl.szymon.gretka.spaceinvaderapp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SPACESHIP")
public class Spaceship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spaceship_id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "health")
    private int health;

    @Column(name = "active")
    private boolean active;

    @Column(name = "available")
    private boolean available;

    @Column(name = "speed")
    private int speed;


    @ManyToMany(mappedBy = "spaceships", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Player> players = new ArrayList<>();

    public Spaceship(@NotBlank String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public Spaceship() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spaceship spaceship = (Spaceship) o;
        return id.equals(spaceship.id);
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", active=" + active +
                ", available=" + available +
                ", speed=" + speed +
                '}';
    }
}

