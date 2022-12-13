package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssistantsDistributionKey implements Serializable {
    private int department_id;
    private int level_id;
    private int assistant_id;
    private int course_id;
    private int section_number;

    public AssistantsDistributionKey() {
    }

    public AssistantsDistributionKey(int department_id, int level_id, int assistant_id, int course_id, int section_number) {
        this.department_id = department_id;
        this.level_id = level_id;
        this.assistant_id = assistant_id;
        this.course_id = course_id;
        this.section_number = section_number;
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

    public int getSection_number() {
        return section_number;
    }

    public void setSection_number(int section_number) {
        this.section_number = section_number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(department_id,level_id,assistant_id,course_id,section_number);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        AssistantsDistributionKey assistantsDistributionKey=(AssistantsDistributionKey) obj;
        return Objects.equals(department_id,assistantsDistributionKey.department_id) && Objects.equals(level_id,assistantsDistributionKey.level_id) && Objects.equals(assistant_id,assistantsDistributionKey.assistant_id) && Objects.equals(course_id,assistantsDistributionKey.course_id) && Objects.equals(section_number,assistantsDistributionKey.section_number);
    }

    @Override
    public String toString() {
        return "AssistantsDistributionKey{" +
                "department_id=" + department_id +
                ", level_id=" + level_id +
                ", assistant_id=" + assistant_id +
                ", course_id=" + course_id +
                ", section_number=" + section_number +
                '}';
    }
}
