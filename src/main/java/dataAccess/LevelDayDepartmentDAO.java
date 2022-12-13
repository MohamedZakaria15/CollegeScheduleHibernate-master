package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.LevelDayDepartment;
import entities.embedded.LevelDayDepartmentKey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class LevelDayDepartmentDAO {
    public List<entities.LevelDayDepartment> findAllLevelDayDepartment(){
        List<LevelDayDepartment> levelDayDepartments  = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            levelDayDepartments=session.createQuery("from LevelDayDepartment").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return levelDayDepartments;
    }
    public LevelDayDepartment findLevelDayDepartmentByAllThreeID(int level_id,int day_id,int department_id){
        LevelDayDepartment levelDayDepartment=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            levelDayDepartment=session.get(LevelDayDepartment.class,new LevelDayDepartmentKey(level_id,department_id,day_id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return levelDayDepartment;
    }
    public void deleteLevelDayDepartmentByAllThreeID(int level_id,int day_id,int department_id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findLevelDayDepartmentByAllThreeID(level_id,day_id,department_id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLevelDayDepartment(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from LevelDayDepartment").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertLevelDayDepartment(LevelDayDepartment levelDayDepartment){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(levelDayDepartment);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<LevelDayDepartment> searchLevelDayDepartment(Generic generic){
        List<LevelDayDepartment> levelDayDepartments  = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            levelDayDepartments=session.createQuery("from LevelDayDepartment where department.departmentName='"+generic+"' or level.levelName='"+generic+"' or day.dayName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return levelDayDepartments;
    }
}
