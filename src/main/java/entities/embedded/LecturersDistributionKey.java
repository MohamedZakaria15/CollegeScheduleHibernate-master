package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LecturersDistributionKey implements Serializable {
    private int department_id;
    private int level_id;
    private int lecturer_id;
    private int course_id;
    private int group_number;

    public LecturersDistributionKey() {
    }
    public LecturersDistributionKey(int department_id, int level_id, int lecturer_id, int course_id, int group_number) {
        this.department_id = department_id;
        this.level_id = level_id;
        this.lecturer_id = lecturer_id;
        this.course_id = course_id;
        this.group_number = group_number;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public int getGroup_number() {
        return group_number;
    }

    public void setGroup_number(int group_number) {
        this.group_number = group_number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id,level_id,lecturer_id,course_id,group_number);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        LecturersDistributionKey lecturersDistributionKey=(LecturersDistributionKey) obj;
        return Objects.equals(department_id,lecturersDistributionKey.department_id) && Objects.equals(level_id,lecturersDistributionKey.level_id) && Objects.equals(lecturer_id,lecturersDistributionKey.lecturer_id) && Objects.equals(course_id,lecturersDistributionKey.course_id) && Objects.equals(group_number,lecturersDistributionKey.group_number);
    }

    @Override
    public String toString() {
        return "LecturersDistributionKey{" +
                "department_id=" + department_id +
                ", level_id=" + level_id +
                ", lecturer_id=" + lecturer_id +
                ", course_id=" + course_id +
                ", group_number=" + group_number +
                '}';
    }
}
