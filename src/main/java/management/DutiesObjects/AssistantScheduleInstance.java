package management.DutiesObjects;

public class AssistantScheduleInstance {
    int departmentId;
    String departmentName;
    int levelId;
    String levelName;
    int assistantId;
    String assistantName;
    int courseId;
    String courseName;
    int dayId;
    String dayName;
    int sectionNumber;
    int roomNumber;
    String roomName;
    float startTime;
    float endTime;

    public AssistantScheduleInstance(int departmentId, String departmentName, int levelId, String levelName, int assistantId, String assistantName, int courseId, String courseName, int dayId, String dayName, int sectionNumber, int roomNumber, String roomName, float startTime, float endTime) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.levelId = levelId;
        this.levelName = levelName;
        this.assistantId = assistantId;
        this.assistantName = assistantName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.dayId = dayId;
        this.dayName = dayName;
        this.sectionNumber = sectionNumber;
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

    public int getAssistantId() {
        return assistantId;
    }

    public void setAssistantId(int assistantId) {
        this.assistantId = assistantId;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
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

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
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

    @Override
    public String toString() {
        return "AssistantScheduleInstance{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", assistantId=" + assistantId +
                ", assistantName='" + assistantName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", dayId=" + dayId +
                ", dayName='" + dayName + '\'' +
                ", sectionNumber=" + sectionNumber +
                ", roomNumber=" + roomNumber +
                ", roomName='" + roomName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
