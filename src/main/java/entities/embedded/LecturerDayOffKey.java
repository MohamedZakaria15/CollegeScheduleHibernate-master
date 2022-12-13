package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LecturerDayOffKey implements Serializable {
    int lecturer_id;
    int day_id;

    public LecturerDayOffKey(){}

    public LecturerDayOffKey(int lecturer_id, int day_id) {
        this.lecturer_id = lecturer_id;
        this.day_id = day_id;
    }

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecturer_id,day_id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        LecturerDayOffKey lecturerDayOffKey=(LecturerDayOffKey) obj;

        return Objects.equals(lecturer_id,lecturerDayOffKey.lecturer_id) && Objects.equals(day_id,lecturerDayOffKey.day_id);
    }
}
