package services;

import dataAccess.AssistantDaysDAO;
import entities.AssistantDay;

import java.util.List;

public class AssistantDayServices {
    private AssistantDaysDAO assistantDaysDAO=new AssistantDaysDAO();
    public List<AssistantDay> findAllAssistantDays(){
        return assistantDaysDAO.findAllAssistantDays();
    }
    public AssistantDay findAssistantDayByBothID(int id, int id1){
        return assistantDaysDAO.findAssistantDayByBothID(id,id1);
    }
    public void insertAssistantDay(AssistantDay assistantDay){
        assistantDaysDAO.insertAssistantDay(assistantDay);
    }
    public int daysForAssistant(int assistantId){
        return assistantDaysDAO.daysForAssistant(assistantId);
    }
    public void deleteAssistantDayByBothID(int id,int id1){
        assistantDaysDAO.deleteAssistantDayByBothID(id,id1);
    }
    public void deleteAllAssistantDays(){
        assistantDaysDAO.deleteAllAssistantDays();
    }
    public <Generic> List<AssistantDay> searchAssistantDays(Generic generic){
        return assistantDaysDAO.searchAssistantDays(generic);
    }
}
