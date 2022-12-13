package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.AssistantCourse;
import entities.embedded.AssistantCourseKey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.AssistantServices;
import java.util.List;



public class AssistantCourseDAO {
    public List<AssistantCourse> findAllAssistantCourses(){
        List<AssistantCourse> assistantCourses=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantCourses=session.createQuery("from AssistantCourse order by assistant.id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantCourses;
    }
    public AssistantCourse findAssistantCourseByID(int id,int id2){
        AssistantCourse assistantCourse=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantCourse=session.get(AssistantCourse.class,new AssistantCourseKey(id,id2));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantCourse;
    }
    public int coursesForAssistant(int assistantId){
       return new AssistantServices().findAssistantByID(assistantId).getCourses().size();
    }
    public void deleteAssistantCourseByBothID(int assistant_id,int course_id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findAssistantCourseByID(assistant_id,course_id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllAssistantCourses(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from AssistantCourse").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertAssistantCourse(AssistantCourse assistantCourse){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(assistantCourse);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<AssistantCourse> searchAssistantCourses(Generic generic){
        List<AssistantCourse> assistantCourses=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            assistantCourses=session.createQuery("from AssistantCourse where assistant.assistantID='"+generic+"' or assistant.assistantFirstName='"+generic+"' or assistant.assistantMiddleName='"+generic+"' or assistant.assistantLastName='"+generic+"' or course.courseID='"+generic+"' or course.courseName like '%"+generic+"%'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantCourses;
    }
}
