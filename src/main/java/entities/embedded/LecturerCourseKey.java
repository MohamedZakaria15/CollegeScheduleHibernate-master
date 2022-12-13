package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LecturerCourseKey implements Serializable {
    int lecturer_id;
    int course_id;

    public LecturerCourseKey(){}
    public LecturerCourseKey(int lecturer_id, int course_id) {
        this.lecturer_id = lecturer_id;
        this.course_id = course_id;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturer_id,course_id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }

        LecturerCourseKey lecturerCourseKey=(LecturerCourseKey) obj;

        return Objects.equals(lecturer_id,lecturerCourseKey.lecturer_id) && Objects.equals(course_id,lecturerCourseKey.course_id);
    }
}
