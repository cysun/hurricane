package cs3220.hurricanes.repository;

import cs3220.hurricanes.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
