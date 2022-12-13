package entities;

import entities.embedded.AssistantDayKey;

import javax.persistence.*;

@Entity
@Table(name = "assistants_days")
public class AssistantDay {
    @EmbeddedId
    private AssistantDayKey assistantDayKey = new AssistantDayKey();

    @ManyToOne
    @JoinColumn(name = "assistant_id", insertable = false, updatable = false)
    private Assistant assistant;


    @ManyToOne
    @JoinColumn(name = "day_id", insertable = false, updatable = false)
    private Day day;

    public AssistantDay() {
    }

    public AssistantDay(AssistantDayKey assistantDayKey) {
        this.assistantDayKey = assistantDayKey;
    }

    public AssistantDayKey getAssistantDayKey() {
        return assistantDayKey;
    }

    public void setAssistantDayKey(AssistantDayKey assistantDayKey) {
        this.assistantDayKey = assistantDayKey;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
