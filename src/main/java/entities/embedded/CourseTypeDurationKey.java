package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseTypeDurationKey implements Serializable {
    private int course_id;
    private int type_id;


    public CourseTypeDurationKey() {}

    public CourseTypeDurationKey(int course_id, int type_id) {
        this.course_id = course_id;
        this.type_id = type_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }

        CourseTypeDurationKey courseTypeDurationKey=(CourseTypeDurationKey) obj;
        return Objects.equals(course_id,courseTypeDurationKey.course_id) && Objects.equals(type_id,courseTypeDurationKey.type_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id,type_id);
    }
}
