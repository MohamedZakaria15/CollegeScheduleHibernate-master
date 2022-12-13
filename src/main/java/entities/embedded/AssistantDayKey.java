package entities.embedded;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AssistantDayKey implements Serializable {
    int assistant_id;
    int day_id;

    public AssistantDayKey(){}
    public AssistantDayKey(int assistant_id, int day_id) {
        this.assistant_id = assistant_id;
        this.day_id = day_id;
    }

    public int getAssistant_id() {
        return assistant_id;
    }

    public void setAssistant_id(int assistant_id) {
        this.assistant_id = assistant_id;
    }

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(assistant_id,day_id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null || getClass()!=obj.getClass()){
            return false;
        }
        AssistantDayKey assistantDayKey=(AssistantDayKey) obj;
        return Objects.equals(assistant_id,assistantDayKey.assistant_id) && Objects.equals(day_id,assistantDayKey.day_id);
    }
}
