package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.CourseDepartmentLevel;
import entities.embedded.CourseDepartmentLevelKey;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CourseDepartmentLevelDAO {
    public List<CourseDepartmentLevel> findAllCourseDepartmentLevel(){
        List<CourseDepartmentLevel> courseDepartmentLevels = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            courseDepartmentLevels=session.createQuery("from CourseDepartmentLevel order by level.id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseDepartmentLevels;
    }
    public CourseDepartmentLevel findCourseDepartmentLevelByAllThreeID(int courseID,int levelID,int DepartmentID){
        CourseDepartmentLevel courseDepartmentLevel=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            courseDepartmentLevel=session.get(CourseDepartmentLevel.class,new CourseDepartmentLevelKey(courseID,levelID,DepartmentID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseDepartmentLevel;
    }
    public void deleteCourseDepartmentLevelByAllThreeID(int courseID,int levelID,int departmentID){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findCourseDepartmentLevelByAllThreeID(courseID,levelID,departmentID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllCourseDepartmentLevel(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from CourseDepartmentLevel").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertCourseDepartmentLevel(CourseDepartmentLevel courseDepartmentLevel){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(courseDepartmentLevel);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateCourseDepartmentLevel(CourseDepartmentLevel courseDepartmentLevel){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(courseDepartmentLevel);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<CourseDepartmentLevel> searchCourseDepartmentLevel(Generic generic){
        List<CourseDepartmentLevel> courseDepartmentLevels = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            courseDepartmentLevels=session.createQuery("from CourseDepartmentLevel where department.departmentName='"+generic+"' or level.levelName='"+generic+"' or course.courseName like '%"+generic+"%' or num_of_groups='"+generic+"' or num_of_sections='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courseDepartmentLevels;
    }
}

