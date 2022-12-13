package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @Column(name = "level_id")
    private int levelID;
    @Column(name = "level_name")
    private String levelName;

    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private Set<LevelDayDepartment> levelDayDepartments=new HashSet<>();

    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private Set<CourseDepartmentLevel> courseDepartmentLevels=new HashSet<>();

    public Level(){}

    public Level(int levelID, String levelName) {
        this.levelID = levelID;
        this.levelName = levelName;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Set<LevelDayDepartment> getLevelDayDepartments() {
        return levelDayDepartments;
    }

    public void setLevelDayDepartments(Set<LevelDayDepartment> levelDayDepartments) {
        this.levelDayDepartments = levelDayDepartments;
    }

    public Set<CourseDepartmentLevel> getCourseDepartmentLevels() {
        return courseDepartmentLevels;
    }

    public void setCourseDepartmentLevels(Set<CourseDepartmentLevel> courseDepartmentLevels) {
        this.courseDepartmentLevels = courseDepartmentLevels;
    }
}
