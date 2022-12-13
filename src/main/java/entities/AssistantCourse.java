package entities;

import entities.embedded.AssistantCourseKey;

import javax.persistence.*;

@Entity
@Table(name = "assistants_courses")
public class    AssistantCourse {
    @EmbeddedId
    private AssistantCourseKey assistantCourseKey = new AssistantCourseKey();

    @ManyToOne
    @JoinColumn(name = "assistant_id", insertable = false, updatable = false)
    private Assistant assistant;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public AssistantCourse() {
    }

    public AssistantCourse(AssistantCourseKey assistantCourseKey) {
        this.assistantCourseKey = assistantCourseKey;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
