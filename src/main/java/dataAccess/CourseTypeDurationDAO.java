package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.CourseTypeDuration;
import entities.embedded.CourseTypeDurationKey;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CourseTypeDurationDAO {

    public List<CourseTypeDuration> findAllCourseTypeDuration(){
        List<CourseTypeDuration> courseTypeDurations = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            courseTypeDurations=session.createQuery("from CourseTypeDuration").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseTypeDurations;
    }
    public CourseTypeDuration findCourseTypeDurationByBothID(int courseID,int typeID){
        CourseTypeDuration courseTypeDuration=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            courseTypeDuration=session.get(CourseTypeDuration.class,new CourseTypeDurationKey(courseID,typeID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseTypeDuration;
    }
    public void deleteCourseTypeDurationByBothID(int courseID,int typeID){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findCourseTypeDurationByBothID(courseID,typeID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllCourseTypeDuration(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from CourseTypeDuration").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertCourseTypeDuration(CourseTypeDuration courseTypeDuration){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(courseTypeDuration);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateCourseTypeDuration(CourseTypeDuration courseTypeDuration){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(courseTypeDuration);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<CourseTypeDuration> searchCourseTypeDuration(Generic generic){
        List<CourseTypeDuration> courseTypeDurations = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            courseTypeDurations=session.createQuery("from CourseTypeDuration where course.courseName like '%"+generic+"%' or placeType.typeName='"+generic+"' or duration='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseTypeDurations;
    }
}
