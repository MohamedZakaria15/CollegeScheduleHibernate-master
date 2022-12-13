package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.LecturerDegree;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;


public class LecturerDegreeDAO {

    public List<LecturerDegree> findAllLecturerDegrees() {
        List<LecturerDegree> lecturerDegrees = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerDegrees=session.createQuery("select distinct l from LecturerDegree l left join fetch l.lecturers").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerDegrees;
    }

    public LecturerDegree findLecturerDegreeByID(int id) {
//        List<LecturerDegree> lecturerDegrees=this.findAllLecturerDegrees().stream().filter(lecturerDegree -> lecturerDegree.getDegreeID()==id).collect(Collectors.toList());
//        return (lecturerDegrees.size()==0) ? null:lecturerDegrees.get(0);
        List<LecturerDegree> lecturerDegrees=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerDegrees=session.createQuery("select distinct l from LecturerDegree l left join fetch l.lecturers where l.degreeID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (lecturerDegrees.size()==0) ? null:lecturerDegrees.get(0);
    }

    public void deleteLecturerDegreeByID(int id) {
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.delete(this.findLecturerDegreeByID(id));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLecturerDegrees() {
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.createQuery("delete from LecturerDegree").executeUpdate();
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertLecturerDegree(LecturerDegree lecturerDegree){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(lecturerDegree);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateLecturerDegree(LecturerDegree lecturerDegree){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(lecturerDegree);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        return (this.findLecturerDegreeByID(id).getLecturers().size()==0) ? false:true;
    }
    public <Generic> List<LecturerDegree> searchLecturerDegrees(Generic generic){
        List<LecturerDegree> lecturerDegrees=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerDegrees=session.createQuery("from LecturerDegree where degreeID='"+generic+"' or degreeName='"+generic+"' or degreeMinimumHours='"+generic+"' or degreeMaximumHours='"+generic+"'").getResultList();
            transaction.commit();;
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerDegrees;
    }
}
