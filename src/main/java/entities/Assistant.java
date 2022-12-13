package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assistants")
public class Assistant {
    @Id
    @Column(name = "assistant_id")
    private int assistantID;
    @Column(name = "first_name")
    private String assistantFirstName;
    @Column(name = "middle_name")
    private String assistantMiddleName;
    @Column(name = "last_name")
    private String assistantLastName;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "degree_id")
    private AssistantDegree assistantDegree;

    @ManyToMany(mappedBy = "assistants",cascade = CascadeType.ALL)
    private Set<Course> courses=new HashSet<>();

    @ManyToMany(mappedBy = "assistants",cascade = CascadeType.ALL)
    private Set<Day> days=new HashSet<>();

    public Assistant(){}

    public Assistant(int assistantID, String assistantFirstName, String assistantMiddleName, String assistantLastName, Department department, AssistantDegree assistantDegree) {
        this.assistantID = assistantID;
        this.assistantFirstName = assistantFirstName;
        this.assistantMiddleName = assistantMiddleName;
        this.assistantLastName = assistantLastName;
        this.department = department;
        this.assistantDegree = assistantDegree;
    }

    public int getAssistantID() {
        return assistantID;
    }

    public void setAssistantID(int assistantID) {
        this.assistantID = assistantID;
    }

    public String getAssistantFirstName() {
        return assistantFirstName;
    }

    public void setAssistantFirstName(String assistantFirstName) {
        this.assistantFirstName = assistantFirstName;
    }

    public String getAssistantMiddleName() {
        return assistantMiddleName;
    }

    public void setAssistantMiddleName(String assistantMiddleName) {
        this.assistantMiddleName = assistantMiddleName;
    }

    public String getAssistantLastName() {
        return assistantLastName;
    }

    public void setAssistantLastName(String assistantLastName) {
        this.assistantLastName = assistantLastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public AssistantDegree getAssistantDegree() {
        return assistantDegree;
    }

    public void setAssistantDegree(AssistantDegree assistantDegree) {
        this.assistantDegree = assistantDegree;
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
        return "Assistant{" +
                "assistantID=" + assistantID +
                ", assistantFirstName='" + assistantFirstName + '\'' +
                ", assistantMiddleName='" + assistantMiddleName + '\'' +
                ", assistantLastName='" + assistantLastName + '\'' +
                ", department=" + department +
                ", assistantDegree=" + assistantDegree +
                '}';
    }
}
