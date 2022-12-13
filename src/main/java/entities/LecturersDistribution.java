package entities;

import entities.embedded.LecturersDistributionKey;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers_distribution")
public class LecturersDistribution {
    @EmbeddedId
    private LecturersDistributionKey lecturersDistributionKey=new LecturersDistributionKey();
    @Column(name = "department_name")
    private String department_name;
    @Column(name = "level_name")
    private String level_name;
    @Column(name = "lecturer_name")
    private String lecturer_name;
    @Column(name = "course_name")
    private String course_name;
    @Column(name = "day_id")
    private int day_id;
    @Column(name = "day_name")
    private String day_name;
    @Column(name = "room_number")
    private int room_number;
    @Column(name = "room_name")
    private String room_name;
    @Column(name = "start_time")
    private float start_time;
    @Column(name = "end_time")
    private float end_time;

    public LecturersDistribution() {
    }

    public LecturersDistribution(LecturersDistributionKey lecturersDistributionKey, String department_name, String level_name, String lecturer_name, String course_name, int day_id, String day_name, int room_number, String room_name, float start_time, float end_time) {
        this.lecturersDistributionKey = lecturersDistributionKey;
        this.department_name = department_name;
        this.level_name = level_name;
        this.lecturer_name = lecturer_name;
        this.course_name = course_name;
        this.day_id = day_id;
        this.day_name = day_name;
        this.room_number = room_number;
        this.room_name = room_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public LecturersDistributionKey getLecturersDistributionKey() {
        return lecturersDistributionKey;
    }

    public void setLecturersDistributionKey(LecturersDistributionKey lecturersDistributionKey) {
        this.lecturersDistributionKey = lecturersDistributionKey;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getLecturer_name() {
        return lecturer_name;
    }

    public void setLecturer_name(String lecturer_name) {
        this.lecturer_name = lecturer_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
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

    @Override
    public String toString() {
        return "LecturersDistribution{" +
                "lecturersDistributionKey=" + lecturersDistributionKey +
                ", department_name='" + department_name + '\'' +
                ", level_name='" + level_name + '\'' +
                ", assistant_name='" + lecturer_name + '\'' +
                ", course_name='" + course_name + '\'' +
                ", day_id=" + day_id +
                ", day_name='" + day_name + '\'' +
                ", room_number=" + room_number +
                ", room_name='" + room_name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
