package entities;

import javax.persistence.*;

@Entity
@Table(name = "time")
public class Time {
    @Id
    @Column(name = "start_time")
    private float start_time;
    @Column(name = "end_time")
    private float end_time;

    public Time(){}

    public Time(float start_time, float end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public float getStart_time() {
        return start_time;
    }

    public void setStart_time(float start_time) {
        this.start_time = start_time;
    }

    public float getEnd_time() {
        return end_time;
    }

    public void setEnd_time(float end_time) {
        this.end_time = end_time;
    }
}
