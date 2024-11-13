package tekkcore.clubdatabackend.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer agej; // Jahrgang Jung
    private Integer agea; // Jahrgang Alt
    private Integer groupsizeNow; // Aktuelle Gruppengröße
    private Integer groupsizeMax; // Maximale Gruppengröße
    private Boolean open; // Weitere Leute einladen

    public Team() {}

    public Team(String name, Integer agej, Integer agea, Integer groupsizeNow, Integer groupsizeMax, Boolean open) {
        this.name = name;
        this.agej = agej;
        this.agea = agea;
        this.groupsizeNow = groupsizeNow;
        this.groupsizeMax = groupsizeMax;
        this.open = open;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAgej() {
        return agej;
    }

    public void setAgej(Integer agej) {
        this.agej = agej;
    }

    public Integer getAgea() {
        return agea;
    }

    public void setAgea(Integer agea) {
        this.agea = agea;
    }

    public Integer getGroupsizeNow() {
        return groupsizeNow;
    }

    public void setGroupsizeNow(Integer groupsizeNow) {
        this.groupsizeNow = groupsizeNow;
    }

    public Integer getGroupsizeMax() {
        return groupsizeMax;
    }

    public void setGroupsizeMax(Integer groupsizeMax) {
        this.groupsizeMax = groupsizeMax;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}