package entities;

import entities.embedded.LevelDayDepartmentKey;

import javax.persistence.*;

@Entity
@Table(name = "levels_days_departments")
public class LevelDayDepartment {
    @EmbeddedId
    private LevelDayDepartmentKey levelDayDepartmentKey=new LevelDayDepartmentKey();

    @ManyToOne
    @JoinColumn(name = "level_id",insertable = false,updatable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false,updatable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "day_id",insertable = false,updatable = false)
    private Day day;


    public LevelDayDepartment(){}

    public LevelDayDepartment(LevelDayDepartmentKey levelDayDepartmentKey) {
        this.levelDayDepartmentKey=levelDayDepartmentKey;
    }

    public LevelDayDepartmentKey getLevelDayDepartmentKey() {
        return levelDayDepartmentKey;
    }

    public void setLevelDayDepartmentKey(LevelDayDepartmentKey levelDayDepartmentKey) {
        this.levelDayDepartmentKey = levelDayDepartmentKey;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

}
