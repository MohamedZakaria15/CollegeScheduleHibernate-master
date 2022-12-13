package services;
import dataAccess.AssistantDAO;
import entities.Assistant;
import java.util.List;

public class AssistantServices {
    private AssistantDAO assistantDAO = new AssistantDAO();

    public List<Assistant> findAllAssistants() {
        return assistantDAO.findAllAssistants();
    }

    public Assistant findAssistantByID(int id) {
        return assistantDAO.findAssistantByID(id);
    }

    public void deleteAssistantByID(int id) {
        assistantDAO.deleteAssistantByID(id);
    }

    public void deleteAllAssistants() {
        assistantDAO.deleteAllAssistants();
    }

    public void insertAssistant(Assistant assistant) {
        assistantDAO.insertAssistant(assistant);
    }

    public void updateAssistant(Assistant assistant) {
        assistantDAO.updateAssistant(assistant);
    }

    public boolean constraintCheck(int id) {
        return assistantDAO.constraintCheck(id);
    }

    public <Generic> List<Assistant> searchAssistants(Generic generic) {
        return assistantDAO.searchAssistants(generic);
    }
}
