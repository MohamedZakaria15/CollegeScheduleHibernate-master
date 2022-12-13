package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @Column(name = "day_id")
    private int dayID;
    @Column(name = "day_name")
    private String dayName;

    @ManyToMany
    @JoinTable(
            name = "assistants_days",
            joinColumns = {@JoinColumn(name = "day_id")},
            inverseJoinColumns ={@JoinColumn(name = "assistant_id")}
    )
    private Set<Assistant> assistants=new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "lecturers_days_off",
            joinColumns = {@JoinColumn(name = "day_id")},
            inverseJoinColumns ={@JoinColumn(name = "lecturer_id")}
    )
    private Set<Lecturer> lecturers=new HashSet<>();

    @OneToMany
    @JoinColumn(name = "day_id")
    private Set<LevelDayDepartment> levelDayDepartments=new HashSet<>();

    public Day(){}
    public Day(int dayID, String dayName) {
        this.dayID = dayID;
        this.dayName = dayName;
    }

    public int getDayID() {
        return dayID;
    }

    public void setDayID(int dayID) {
        this.dayID = dayID;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Set<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(Set<Assistant> assistants) {
        this.assistants = assistants;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public Set<LevelDayDepartment> getLevelDayDepartments() {
        return levelDayDepartments;
    }

    public void setLevelDayDepartments(Set<LevelDayDepartment> levelDayDepartments) {
        this.levelDayDepartments = levelDayDepartments;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dayID=" + dayID +
                ", dayName='" + dayName + '\'' +
                '}';
    }
}
