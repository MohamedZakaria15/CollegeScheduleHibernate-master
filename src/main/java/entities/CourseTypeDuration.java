package entities;

import entities.embedded.CourseTypeDurationKey;

import javax.persistence.*;

@Entity
@Table(name = "courses_types_durations")
public class CourseTypeDuration {
    @EmbeddedId
    private CourseTypeDurationKey courseTypeDurationKey=new CourseTypeDurationKey();
    @Column(name = "duration")
    private float duration;

    @ManyToOne
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "type_id",insertable = false,updatable = false)
    private PlaceType placeType;



    public CourseTypeDuration() {
    }

    public CourseTypeDuration(CourseTypeDurationKey courseTypeDurationKey, float duration) {
        this.courseTypeDurationKey = courseTypeDurationKey;
        this.duration = duration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
