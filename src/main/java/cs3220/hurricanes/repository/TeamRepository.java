package cs3220.hurricanes.repository;

import cs3220.hurricanes.model.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    @Query("select t from Team t where t.gender = ?1 and t.minAge <= ?2 and ?2 <= t.maxAge")
    List<Team> findTeamsForPlayer(String gender, int age);
}
