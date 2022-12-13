package management.DutiesObjects;

public class LecturerScheduleInstance {
    int departmentId;
    String departmentName;
    int levelId;
    String levelName;
    int lecturerId;
    String lecturerName;
    int courseId;
    String courseName;
    int dayId;
    String dayName;
    int groupNumber;
    int roomNumber;
    String roomName;
    float startTime;
    float endTime;

    public LecturerScheduleInstance(int departmentId, String departmentName, int levelId, String levelName, int lecturerId, String lecturerName, int courseId, String courseName, int dayId, String dayName, int groupNumber, int roomNumber, String roomName, float startTime, float endTime) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.levelId = levelId;
        this.levelName = levelName;
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.dayId = dayId;
        this.dayName = dayName;
        this.groupNumber = groupNumber;
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public float getStartTime() {
        return startTime;
    }

    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }

    public float getEndTime() {
        return endTime;
    }

    public void setEndTime(float endTime) {
        this.endTime = endTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "LecturerScheduleInstance{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", lecturerId=" + lecturerId +
                ", lecturerName='" + lecturerName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", dayId=" + dayId +
                ", dayName='" + dayName + '\'' +
                ", groupNumber=" + groupNumber +
                ", roomNumber=" + roomNumber +
                ", roomName='" + roomName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
