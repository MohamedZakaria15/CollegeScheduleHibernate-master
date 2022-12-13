package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.AssistantDegree;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class AssistantDegreeDAO {
    public List<AssistantDegree> findAllAssistantDegrees() {
        List<AssistantDegree> assistantDegrees = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantDegrees=session.createQuery("select distinct a from AssistantDegree a left join fetch a.assistants").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantDegrees;
    }

    public AssistantDegree findAssistantDegreeByID(int id) {
//        List<AssistantDegree> assistantDegrees=this.findAllAssistantDegrees().stream().filter(assistantDegree -> assistantDegree.getDegreeID()==id).collect(Collectors.toList());
//        return (assistantDegrees.size()==0) ? null:assistantDegrees.get(0);
        List<AssistantDegree> assistantDegrees=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantDegrees=session.createQuery("select distinct a from AssistantDegree a left join fetch a.assistants where a.degreeID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        return (assistantDegrees.size()==0) ? null:assistantDegrees.get(0);
    }

    public void deleteAssistantDegreeByID(int id) {
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.delete(this.findAssistantDegreeByID(id));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllAssistantDegrees() {
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.createQuery("delete from AssistantDegree").executeUpdate();
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertAssistantDegree(AssistantDegree assistantDegree){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(assistantDegree);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateAssistantDegree(AssistantDegree assistantDegree){
        Transaction transaction=null;
       try (Session session=HibernateUtil.getSessionFactory().openSession()){
           transaction=session.beginTransaction();
           session.update(assistantDegree);
           transaction.commit();
       }catch (Exception exception){
           transaction.rollback();
           exception.printStackTrace();
       }
    }
    public boolean constraintCheck(int id){
        return (this.findAssistantDegreeByID(id).getAssistants().size()==0) ? false:true;
    }
    public <Generic> List<AssistantDegree> searchAssistantDegrees(Generic generic){
        List<AssistantDegree> assistantDegrees=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantDegrees=session.createQuery("from AssistantDegree where degreeID='"+generic+"' or degreeName='"+generic+"' or degreeMinimumHours='"+generic+"' or degreeMaximumHours='"+generic+"'").getResultList();
            transaction.commit();;
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantDegrees;
    }

}
