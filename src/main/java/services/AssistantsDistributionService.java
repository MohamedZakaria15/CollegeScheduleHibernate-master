package services;

import dataAccess.AssistantsDistributionDAO;
import entities.AssistantsDistribution;

import java.util.List;

public class AssistantsDistributionService {
    private AssistantsDistributionDAO assistantsDistributionDAO=new AssistantsDistributionDAO();

    public List<AssistantsDistribution> findAllAssistantsDistribution(){
        return assistantsDistributionDAO.findAllAssistantsDistribution();
    }
    public void insertAssistantDistribution(AssistantsDistribution assistantsDistribution){
        assistantsDistributionDAO.insertAssistantDistribution(assistantsDistribution);
    }
    public void deleteAllAssistantsDistribution(){
        assistantsDistributionDAO.deleteAllAssistantsDistribution();
    }
    public List<AssistantsDistribution> searchAssistantsDistribution(int departmentId,int levelId,int assistantId,int sectionNumber){
        return assistantsDistributionDAO.searchAssistantsDistribution(departmentId,levelId,assistantId,sectionNumber);
    }
    public List<AssistantsDistribution> orderSections(List<AssistantsDistribution> assistantsDistributions){
        return assistantsDistributionDAO.orderSections(assistantsDistributions);
    }
}
