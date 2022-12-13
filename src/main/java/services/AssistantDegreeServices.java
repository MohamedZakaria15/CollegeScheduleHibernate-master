package services;

import dataAccess.AssistantDegreeDAO;
import entities.AssistantDegree;

import java.util.List;

public class AssistantDegreeServices {
    private AssistantDegreeDAO assistantDegreeDAO=new AssistantDegreeDAO();

    public List<AssistantDegree> findAllAssistantsDegrees(){
        return assistantDegreeDAO.findAllAssistantDegrees();
    }
    public AssistantDegree findAssistantDegreeByID(int id){
        return assistantDegreeDAO.findAssistantDegreeByID(id);
    }
    public void deleteAssistantDegreeByID(int id){
        assistantDegreeDAO.deleteAssistantDegreeByID(id);
    }
    public void deleteAllAssistantDegrees(){
        assistantDegreeDAO.deleteAllAssistantDegrees();
    }
    public void insertAssistantDegree(AssistantDegree assistantDegree){
        assistantDegreeDAO.insertAssistantDegree(assistantDegree);
    }
    public void updateAssistantDegree(AssistantDegree assistantDegree){
        assistantDegreeDAO.updateAssistantDegree(assistantDegree);
    }
    public boolean constraintCheck(int id){
        return assistantDegreeDAO.constraintCheck(id);
    }
    public <Generic> List<AssistantDegree> searchAssistantDegrees(Generic generic){
        return assistantDegreeDAO.searchAssistantDegrees(generic);
    }
}
