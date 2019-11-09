package pl.szymon.gretka.spaceinvaderapp.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SPACESHIP")
public class Spaceship implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spaceship_id")
    private Long id;

    @Column(name = "type_of_spaceship")
    private String type_of_spaceship;

    @Column(name = "type_of_gun")
    private String type_of_gun;

    @Column(name = "type_of_generator")
    private String type_of_generator;

    @Column(name = "special_ammo")
    private Long special_ammo;

    @Column(name = "health")
    private int health;

    @Column(name = "speed")
    private int speed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonManagedReference
    private Player player;

    public Spaceship(String type_of_spaceship, String type_of_gun, String type_of_generator, Long special_ammo, int health, int speed) {
        this.type_of_spaceship = type_of_spaceship;
        this.type_of_gun = type_of_gun;
        this.type_of_generator = type_of_generator;
        this.special_ammo = special_ammo;
        this.health = health;
        this.speed = speed;
    }

    public Spaceship() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_of_spaceship() {
        return type_of_spaceship;
    }

    public void setType_of_spaceship(String type_of_spaceship) {
        this.type_of_spaceship = type_of_spaceship;
    }

    public String getType_of_gun() {
        return type_of_gun;
    }

    public void setType_of_gun(String type_of_gun) {
        this.type_of_gun = type_of_gun;
    }

    public String getType_of_generator() {
        return type_of_generator;
    }

    public void setType_of_generator(String type_of_generator) {
        this.type_of_generator = type_of_generator;
    }

    public Long getSpecial_ammo() {
        return special_ammo;
    }

    public void setSpecial_ammo(Long special_ammo) {
        this.special_ammo = special_ammo;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spaceship)) return false;
        Spaceship spaceship = (Spaceship) o;
        return health == spaceship.health &&
                speed == spaceship.speed &&
                id.equals(spaceship.id) &&
                type_of_spaceship.equals(spaceship.type_of_spaceship) &&
                type_of_gun.equals(spaceship.type_of_gun) &&
                type_of_generator.equals(spaceship.type_of_generator) &&
                special_ammo.equals(spaceship.special_ammo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type_of_spaceship, type_of_gun, type_of_generator, special_ammo, health, speed);
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "id=" + id +
                ", type_of_spaceship='" + type_of_spaceship + '\'' +
                ", type_of_gun='" + type_of_gun + '\'' +
                ", type_of_generator='" + type_of_generator + '\'' +
                ", special_ammo=" + special_ammo +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }
}

