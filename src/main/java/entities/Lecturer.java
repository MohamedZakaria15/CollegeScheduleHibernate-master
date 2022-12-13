package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @Column(name = "lecturer_id")
    private int lecturerID;
    @Column(name = "first_name")
    private String lecturerFirstName;
    @Column(name = "middle_name")
    private String lecturerMiddleName;
    @Column(name = "last_name")
    private String lecturerLastName;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private LecturerDegree lecturerDegree;


    @ManyToMany(mappedBy = "lecturers",cascade = CascadeType.ALL)
    private Set<Course> courses=new HashSet<>();


    @ManyToMany(mappedBy = "lecturers",cascade = CascadeType.ALL)
    private Set<Day> days=new HashSet<>();


    public Lecturer(){}

    public Lecturer(int lecturerID, String lecturerFirstName, String lecturerMiddleName, String lecturerLastName, Department department, LecturerDegree lecturerDegree) {
        this.lecturerID = lecturerID;
        this.lecturerFirstName = lecturerFirstName;
        this.lecturerMiddleName = lecturerMiddleName;
        this.lecturerLastName = lecturerLastName;
        this.department = department;
        this.lecturerDegree = lecturerDegree;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerFirstName() {
        return lecturerFirstName;
    }

    public void setLecturerFirstName(String lecturerFirstName) {
        this.lecturerFirstName = lecturerFirstName;
    }

    public String getLecturerMiddleName() {
        return lecturerMiddleName;
    }

    public void setLecturerMiddleName(String lecturerMiddleName) {
        this.lecturerMiddleName = lecturerMiddleName;
    }

    public String getLecturerLastName() {
        return lecturerLastName;
    }

    public void setLecturerLastName(String lecturerLastName) {
        this.lecturerLastName = lecturerLastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LecturerDegree getLecturerDegree() {
        return lecturerDegree;
    }

    public void setLecturerDegree(LecturerDegree lecturerDegree) {
        this.lecturerDegree = lecturerDegree;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Day> getDays() {
        return days;
    }

    public void setDays(Set<Day> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "lecturerID=" + lecturerID +
                ", lecturerFirstName='" + lecturerFirstName + '\'' +
                ", lecturerMiddleName='" + lecturerMiddleName + '\'' +
                ", lecturerLastName='" + lecturerLastName + '\'' +
                ", department=" + department +
                ", lecturerDegree=" + lecturerDegree +
                '}';
    }
}
