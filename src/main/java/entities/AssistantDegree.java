package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assistants_degrees")
public class AssistantDegree {
    @Id
    @Column(name = "degree_id")
    private int degreeID;
    @Column(name = "degree_name")
    private String degreeName;
    @Column(name = "degree_minimum_hours")
    private float degreeMinimumHours;
    @Column(name = "degree_maximum_hours")
    private float degreeMaximumHours;


    @OneToMany(mappedBy = "assistantDegree",cascade = CascadeType.ALL)
    private Set<Assistant> assistants=new HashSet<>();


    public AssistantDegree(){}
    public AssistantDegree(int degreeID, String degreeName, float degreeMinimumHours, float degreeMaximumHours) {
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

    public Set<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(Set<Assistant> assistants) {
        this.assistants = assistants;
    }

    @Override
    public String toString() {
        return "AssistantDegree{" +
                "degreeID=" + degreeID +
                ", degreeName='" + degreeName + '\'' +
                ", degreeMinimumHours=" + degreeMinimumHours +
                ", degreeMaximumHours=" + degreeMaximumHours +
                '}';
    }
}
