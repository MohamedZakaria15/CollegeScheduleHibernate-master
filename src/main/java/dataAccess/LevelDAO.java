package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Level;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jpa.QueryHints;

import java.util.List;
import java.util.stream.Collectors;

public class LevelDAO {
    public List<Level> findAllLevels(){
        List<Level> levels = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            levels=session.createQuery("select distinct l from Level l left join fetch l.courseDepartmentLevels left join fetch l.levelDayDepartments").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return levels;
    }
    public Level findLevelByID(int id){
//       List<Level> levels=this.findAllLevels().stream().filter(level -> level.getLevelID()==id).collect(Collectors.toList());
//       return (levels.size()==0) ? null:levels.get(0);
        List<Level> levels=null;
        Transaction transaction=null;

        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            levels=session.createQuery("select distinct l from Level l left join fetch l.courseDepartmentLevels left join fetch l.levelDayDepartments where l.levelID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }


        return (levels.size()==0) ? null:levels.get(0);
    }
    public void deleteLevelByID(int id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findLevelByID(id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLevels(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from Level").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertLevel(Level level){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(level);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateLevel(Level level){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(level);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        Level level=this.findLevelByID(id);
        return (level.getLevelDayDepartments().size()==0 && level.getCourseDepartmentLevels().size()==0) ? false:true;
    }
    public <Generic> List<Level> searchLevels(Generic generic){
        List<Level> levels = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            levels=session.createQuery("from Level where levelID='"+generic+"' or levelName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return levels;
    }
}
