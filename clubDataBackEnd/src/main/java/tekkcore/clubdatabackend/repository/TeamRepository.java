package tekkcore.clubdatabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekkcore.clubdatabackend.models.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}