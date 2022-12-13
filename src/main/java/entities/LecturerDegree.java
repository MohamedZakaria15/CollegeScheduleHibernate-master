package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lecturers_degrees")
public class LecturerDegree {
    @Id
    @Column(name = "degree_id")
    private int degreeID;
    @Column(name = "degree_name")
    private String degreeName;
    @Column(name = "degree_minimum_hours")
    private float degreeMinimumHours;
    @Column(name = "degree_maximum_hours")
    private float degreeMaximumHours;


    @OneToMany(mappedBy = "lecturerDegree",cascade = CascadeType.ALL)
    private Set<Lecturer> lecturers=new HashSet<>();

    public LecturerDegree(){}
    public LecturerDegree(int degreeID, String degreeName, float degreeMinimumHours, float degreeMaximumHours) {
        this.degreeID = degreeID;
        this.degreeName = degreeName;
        this.degreeMinimumHours = degreeMinimumHours;
        this.degreeMaximumHours = degreeMaximumHours;
    }

    public int getDegreeID() {
        return degreeID;
    }

    public void setDegreeID(int degreeID) {
        this.degreeID = degreeID;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public float getDegreeMinimumHours() {
        return degreeMinimumHours;
    }

    public void setDegreeMinimumHours(float degreeMinimumHours) {
        this.degreeMinimumHours = degreeMinimumHours;
    }

    public float getDegreeMaximumHours() {
        return degreeMaximumHours;
    }

    public void setDegreeMaximumHours(float degreeMaximumHours) {
        this.degreeMaximumHours = degreeMaximumHours;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
        return "LecturerDegree{" +
                "degreeID=" + degreeID +
                ", degreeName='" + degreeName + '\'' +
                ", degreeMinimumHours=" + degreeMinimumHours +
                ", degreeMaximumHours=" + degreeMaximumHours +
                '}';
    }
}
