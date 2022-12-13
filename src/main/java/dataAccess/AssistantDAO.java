package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Assistant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class AssistantDAO {
    public List<Assistant> findAllAssistants(){
        List<Assistant> assistants=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistants=session.createQuery("select distinct a from Assistant a left join fetch a.courses left join fetch a.days").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistants;
    }
    public Assistant findAssistantByID(int id){
        List<Assistant> assistants=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()) {
            transaction= session.beginTransaction();
            assistants=session.createQuery("select distinct a from Assistant a left join fetch a.courses left join fetch a.days where a.assistantID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (assistants.size()==0) ? null:assistants.get(0);
    }
    public void deleteAssistantByID(int id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findAssistantByID(id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllAssistants(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from Assistant").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertAssistant(Assistant assistant){
       Transaction transaction=null;
       try (Session session=HibernateUtil.getSessionFactory().openSession()){
           transaction=session.beginTransaction();
           session.save(assistant);
           transaction.commit();
       }catch (Exception exception){
           transaction.rollback();
           exception.printStackTrace();
       }
    }
    public void updateAssistant(Assistant assistant){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(assistant);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        Assistant assistant=this.findAssistantByID(id);
        return (assistant.getDays().size()==0 && assistant.getCourses().size()==0) ? false:true;
    }
    public <Generic> List<Assistant> searchAssistants(Generic generic){
        List<Assistant> assistants=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            assistants=session.createQuery("from Assistant where assistantID='"+generic+"' or assistantFirstName='"+generic+"' or assistantMiddleName='"+generic+"' or assistantLastName='"+generic+"' or department.departmentName='"+generic+"' or assistantDegree.degreeName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistants;
    }
}
