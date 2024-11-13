package tekkcore.clubdatabackend.services;

import tekkcore.clubdatabackend.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tekkcore.clubdatabackend.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team teamDetails) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team nicht gefunden: " + id));
        team.setName(teamDetails.getName());
        team.setAgej(teamDetails.getAgej());
        team.setAgea(teamDetails.getAgea());
        team.setGroupsizeNow(teamDetails.getGroupsizeNow());
        team.setGroupsizeMax(teamDetails.getGroupsizeMax());
        team.setOpen(teamDetails.getOpen());
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}