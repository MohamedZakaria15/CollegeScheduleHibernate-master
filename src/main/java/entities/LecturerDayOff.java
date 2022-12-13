package entities;

import entities.embedded.LecturerDayOffKey;

import javax.persistence.*;

@Entity
@Table(name = "lecturers_days_off")
public class LecturerDayOff {
    @EmbeddedId
    private LecturerDayOffKey lecturerID=new LecturerDayOffKey();

    @ManyToOne
    @JoinColumn(name = "lecturer_id",insertable = false,updatable = false)
    private Lecturer lecturer;

    @ManyToOne
    @JoinColumn(name = "day_id",insertable = false,updatable = false)
    private Day day;

   public LecturerDayOff(){}

    public LecturerDayOff(LecturerDayOffKey lecturerID) {
        this.lecturerID = lecturerID;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
