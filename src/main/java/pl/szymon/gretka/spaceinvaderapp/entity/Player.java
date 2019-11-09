package pl.szymon.gretka.spaceinvaderapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PLAYER")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Long id;

    @NotBlank
    @Column(name = "nickname")
    private String nickname;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "score")
    private Long score;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "player")
    //@JsonBackReference
    private Set<Spaceship> spaceships = new HashSet<>();

    public Player addSpaceship(Spaceship spaceship){
        spaceship.setPlayer(this);
        this.spaceships.add(spaceship);
        return this;
    }

    public Player(@NotBlank String nickname, @NotBlank String password, Long score) {
        this.nickname = nickname;
        this.password = password;
        this.score = score;
    }


    public Player() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id.equals(player.id) &&
                nickname.equals(player.nickname) &&
                password.equals(player.password) &&
                Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, password, score);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", score=" + score +
                '}';
    }
}
