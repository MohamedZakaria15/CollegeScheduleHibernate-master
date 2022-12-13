package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssistantCourseKey implements Serializable {
    private int assistant_id;
    private int course_id;

    public AssistantCourseKey(){}
    public AssistantCourseKey(int assistant_id, int course_id) {
        this.assistant_id = assistant_id;
        this.course_id = course_id;
    }

    public int getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(int assistant_id) {
        this.assistant_id = assistant_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistant_id,course_id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        AssistantCourseKey assistantCourseKey=(AssistantCourseKey) obj;
        return Objects.equals(assistant_id,assistantCourseKey.assistant_id) && Objects.equals(course_id,assistantCourseKey.course_id);
    }
}
