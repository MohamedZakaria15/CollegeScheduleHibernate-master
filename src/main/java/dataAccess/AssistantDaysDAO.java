package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.AssistantDay;
import entities.embedded.AssistantDayKey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.AssistantServices;
import java.util.List;


public class AssistantDaysDAO {
    public List<AssistantDay> findAllAssistantDays(){
        List<AssistantDay> assistantsDays=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantsDays=session.createQuery("from AssistantDay order by assistant.id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantsDays;
    }
    public AssistantDay findAssistantDayByBothID(int assistant_ID,int day_ID){
        AssistantDay assistantDay=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantDay=session.get(AssistantDay.class,new AssistantDayKey(assistant_ID,day_ID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantDay;
    }
    public void deleteAssistantDayByBothID(int assistantID,int dayID){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findAssistantDayByBothID(assistantID,dayID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertAssistantDay(AssistantDay assistantDay){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(assistantDay);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public int daysForAssistant(int assistantId){
       return new AssistantServices().findAssistantByID(assistantId).getDays().size();
    }
    public void deleteAllAssistantDays(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from AssistantDay").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<AssistantDay> searchAssistantDays(Generic generic){
        List<AssistantDay> assistantsDays=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            assistantsDays=session.createQuery("from AssistantDay where assistant.assistantID='"+generic+"' or assistant.assistantFirstName='"+generic+"' or assistant.assistantMiddleName='"+generic+"' or assistant.assistantLastName='"+generic+"' or day.dayName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantsDays;
    }
}
