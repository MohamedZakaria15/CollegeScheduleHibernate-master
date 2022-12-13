package entities;

import entities.embedded.LecturerCourseKey;

import javax.persistence.*;

@Entity
@Table(name = "lecturers_courses")
public class LecturerCourse {
    @EmbeddedId
    private LecturerCourseKey lecturerCourseKey = new LecturerCourseKey();

    @ManyToOne
    @JoinColumn(name = "lecturer_id",insertable = false,updatable = false)
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private Course course;

    public LecturerCourse(){}

    public LecturerCourse(LecturerCourseKey lecturerCourseKey) {
        this.lecturerCourseKey = lecturerCourseKey;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
