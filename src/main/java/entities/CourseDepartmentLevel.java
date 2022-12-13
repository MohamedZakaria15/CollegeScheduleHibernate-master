package entities;

import entities.embedded.CourseDepartmentLevelKey;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses_departments_levels")
public class CourseDepartmentLevel {
    @EmbeddedId
    private CourseDepartmentLevelKey courseDepartmentLevelKey = new CourseDepartmentLevelKey();

    @Column(name = "num_of_sections")
    private int num_of_sections;

    @Column(name = "num_of_groups")
    private int num_of_groups;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "level_id", insertable = false, updatable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;



    public CourseDepartmentLevel() {
    }


    public CourseDepartmentLevel(CourseDepartmentLevelKey courseDepartmentLevelKey, int num_of_sections, int num_of_groups) {
        this.courseDepartmentLevelKey = courseDepartmentLevelKey;
        this.num_of_sections = num_of_sections;
        this.num_of_groups = num_of_groups;
    }

    public CourseDepartmentLevelKey getCourseDepartmentLevelKey() {
        return courseDepartmentLevelKey;
    }

    public void setCourseDepartmentLevelKey(CourseDepartmentLevelKey courseDepartmentLevelKey) {
        this.courseDepartmentLevelKey = courseDepartmentLevelKey;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public int getNum_of_sections() {
        return num_of_sections;
    }

    public void setNum_of_sections(int num_of_sections) {
        this.num_of_sections = num_of_sections;
    }

    public int getNum_of_groups() {
        return num_of_groups;
    }

    public void setNum_of_groups(int num_of_groups) {
        this.num_of_groups = num_of_groups;
    }

}
