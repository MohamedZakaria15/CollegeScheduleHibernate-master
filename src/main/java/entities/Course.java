package entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    private int courseID;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "full_time")
    private float courseFullTime;


    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<CourseDepartmentLevel> courseDepartmentLevels=new HashSet<>();

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<CourseTypeDuration> courseTypeDurations=new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "assistants_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "assistant_id")}
            )
    private Set<Assistant> assistants=new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "lecturers_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "lecturer_id")}
            )
    private Set<Lecturer> lecturers=new HashSet<>();

    public Course(){}
    public Course(int courseID, String courseName, float courseFullTime) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseFullTime = courseFullTime;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getCourseFullTime() {
        return courseFullTime;
    }

    public void setCourseFullTime(float courseFullTime) {
        this.courseFullTime = courseFullTime;
    }

    public Set<CourseDepartmentLevel> getCourseDepartmentLevels() {
        return courseDepartmentLevels;
    }

    public void setCourseDepartmentLevels(Set<CourseDepartmentLevel> courseDepartmentLevels) {
        this.courseDepartmentLevels = courseDepartmentLevels;
    }

    public Set<CourseTypeDuration> getCourseTypeDurations() {
        return courseTypeDurations;
    }

    public void setCourseTypeDurations(Set<CourseTypeDuration> courseTypeDurations) {
        this.courseTypeDurations = courseTypeDurations;
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

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", courseFullTime=" + courseFullTime +
                '}';
    }
}
