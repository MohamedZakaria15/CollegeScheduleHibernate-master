package management.DutiesObjects;

public class AssistantDuty{
    int assistantId;
    String assistantName;
    int levelId;
    String levelName;
    int departmentId;
    String departmentName;
    int courseId;
    String courseName;
    int typeId;
    String typeName;
    float Duration;
    int numOfSections;
    float totalTime;

    public AssistantDuty(int assistantId, String assistantName, int levelId, String levelName, int departmentId, String departmentName, int courseId, String courseName, int typeId, String typeName, float duration, int numOfSections, float totalTime) {
        this.assistantId = assistantId;
        this.assistantName = assistantName;
        this.levelId = levelId;
        this.levelName = levelName;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.courseId = courseId;
        this.courseName = courseName;
        this.typeId = typeId;
        this.typeName = typeName;
        Duration = duration;
        this.numOfSections = numOfSections;
        this.totalTime = totalTime;
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

    public int getNumOfSections() {
        return numOfSections;
    }

    public void setNumOfSections(int numOfSections) {
        this.numOfSections = numOfSections;
    }

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float duration) {
        Duration = duration;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
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

    @Override
    public String toString() {
        return "AssistantDuty{" +
                "assistantId=" + assistantId +
                ", assistantName='" + assistantName + '\'' +
                ", levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", Duration=" + Duration +
                ", numOfSections=" + numOfSections +
                ", totalTime=" + totalTime +
                '}';
    }
}
