package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LevelDayDepartmentKey implements Serializable {
    int level_id;
    int department_id;
    int day_id;

    public LevelDayDepartmentKey(){}

    public LevelDayDepartmentKey(int level_id, int department_id, int day_id) {
        this.level_id = level_id;
        this.department_id = department_id;
        this.day_id = day_id;
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

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level_id,department_id,day_id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        LevelDayDepartmentKey levelDayDepartmentKey=(LevelDayDepartmentKey) obj;

        return Objects.equals(level_id,levelDayDepartmentKey.level_id) && Objects.equals(department_id,levelDayDepartmentKey.department_id) &&
        Objects.equals(day_id,levelDayDepartmentKey.day_id);
    }
}
