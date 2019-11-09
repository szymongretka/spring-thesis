package pl.szymon.gretka.spaceinvaderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymon.gretka.spaceinvaderapp.entity.Player;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByOrderByScoreDesc();
}
