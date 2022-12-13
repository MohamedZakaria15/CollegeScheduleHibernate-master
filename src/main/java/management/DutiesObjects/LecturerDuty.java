package management.DutiesObjects;

public class LecturerDuty {
    int lecturerId;
    String lecturerName;
    int levelId;
    String levelName;
    int departmentId;
    String departmentName;
    int courseId;
    String courseName;
    int typeId;
    String typeName;
    float duration;
    int numOfGroups;
    float totalTime;

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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getNumOfGroups() {
        return numOfGroups;
    }

    public void setNumOfGroups(int numOfGroups) {
        this.numOfGroups = numOfGroups;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public LecturerDuty(int lecturerId, String lecturerName, int levelId, String levelName, int departmentId, String departmentName, int courseId, String courseName, int typeId, String typeName, float duration, int numOfGroups, float totalTime) {
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.levelId = levelId;
        this.levelName = levelName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.typeId = typeId;
        this.typeName = typeName;
        this.duration = duration;
        this.numOfGroups = numOfGroups;
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "LecturerDuty{" +
                "lecturerId=" + lecturerId +
                ", lecturerName='" + lecturerName + '\'' +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", duration=" + duration +
                ", numOfGroups=" + numOfGroups +
                ", totalTime=" + totalTime +
                '}';
    }
}
