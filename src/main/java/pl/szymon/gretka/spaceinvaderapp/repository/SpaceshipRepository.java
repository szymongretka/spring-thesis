package pl.szymon.gretka.spaceinvaderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymon.gretka.spaceinvaderapp.entity.Spaceship;

public interface SpaceshipRepository extends JpaRepository<Spaceship, Long> {
}
