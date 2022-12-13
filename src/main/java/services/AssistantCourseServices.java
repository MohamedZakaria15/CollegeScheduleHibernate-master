package services;

import dataAccess.AssistantCourseDAO;
import entities.AssistantCourse;

import java.util.List;

public class AssistantCourseServices {
    private AssistantCourseDAO assistantCourseDAO=new AssistantCourseDAO();
    public List<AssistantCourse> findAllAssistantCourses(){
        return assistantCourseDAO.findAllAssistantCourses();
    }
    public AssistantCourse findAssistantCourseByID(int id,int id2){
        return assistantCourseDAO.findAssistantCourseByID(id,id2);
    }
    public void insertAssistantCourse(AssistantCourse assistantCourse){
        assistantCourseDAO.insertAssistantCourse(assistantCourse);
    }
    public int coursesForAssistant(int assistantId){
        return assistantCourseDAO.coursesForAssistant(assistantId);
    }
    public void deleteAssistantCourseByBothID(int id,int id1){
        assistantCourseDAO.deleteAssistantCourseByBothID(id,id1);
    }
    public void deleteAllAssistantCourses(){
        assistantCourseDAO.deleteAllAssistantCourses();
    }
    public <Generic> List<AssistantCourse> searchAssistantCourses(Generic generic){
        return assistantCourseDAO.searchAssistantCourses(generic);
    }
}
