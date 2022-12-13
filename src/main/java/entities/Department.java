package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "department_id")
    private int departmentID;
    @Column(name = "department_name")
    private String departmentName;


    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Assistant> assistants=new HashSet<>();

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<Lecturer> lecturers=new HashSet<>();


    @OneToMany(mappedBy ="department" ,cascade = CascadeType.ALL)
    private Set<CourseDepartmentLevel> courseDepartmentLevels=new HashSet<>();

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private Set<LevelDayDepartment> levelDayDepartments=new HashSet<>();


    public Department(){}
    public Department(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public Set<CourseDepartmentLevel> getCourseDepartmentLevels() {
        return courseDepartmentLevels;
    }

    public void setCourseDepartmentLevels(Set<CourseDepartmentLevel> courseDepartmentLevels) {
        this.courseDepartmentLevels = courseDepartmentLevels;
    }

    public Set<LevelDayDepartment> getLevelDayDepartments() {
        return levelDayDepartments;
    }

    public void setLevelDayDepartments(Set<LevelDayDepartment> levelDayDepartments) {
        this.levelDayDepartments = levelDayDepartments;
    }
}
