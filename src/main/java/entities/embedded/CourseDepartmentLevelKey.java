package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseDepartmentLevelKey implements Serializable {
    private int course_id;
    private int level_id;
    private int department_id;


    public CourseDepartmentLevelKey(){}

    public CourseDepartmentLevelKey(int course_id, int level_id, int department_id) {
        this.course_id = course_id;
        this.level_id = level_id;
        this.department_id = department_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }

        if ( obj == null || getClass() != obj.getClass() ) {
            return false;
        }
        CourseDepartmentLevelKey courseDepartmentLevelKey =(CourseDepartmentLevelKey) obj;
        return Objects.equals(course_id, courseDepartmentLevelKey.course_id) &&
                Objects.equals(level_id, courseDepartmentLevelKey.level_id) &&
                Objects.equals(department_id, courseDepartmentLevelKey.department_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id,level_id,department_id);
    }
}
