package cs3220.hurricanes.model;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String gender;

    private int birthYear;

    @ManyToOne
    private Team team;

    public Player() {
    }

    public Player(String name, String gender, int birthYear) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
