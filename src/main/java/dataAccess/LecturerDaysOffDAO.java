package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.*;
import entities.embedded.LecturerDayOffKey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.LecturerServices;
import java.util.List;


public class LecturerDaysOffDAO {
    public List<LecturerDayOff> findAllLecturersDaysOff(){
        List<LecturerDayOff> lecturerDayOffList=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerDayOffList=session.createQuery("from LecturerDayOff order by lecturer.id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerDayOffList;
    }
    public LecturerDayOff findLecturerDayOffByBothID(int lecturer_ID,int day_ID){
        LecturerDayOff lecturerDayOff=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerDayOff=session.get(LecturerDayOff.class,new LecturerDayOffKey(lecturer_ID,day_ID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerDayOff;
    }
    public void insertLecturerDayOff(LecturerDayOff lecturerDayOff){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(lecturerDayOff);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public int daysOffForLecturer(int lecturerId){
        return new LecturerServices().findLecturerByID(lecturerId).getDays().size();
    }
    public void deleteLecturerDayOffByBothID(int lecturerID,int dayID){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findLecturerDayOffByBothID(lecturerID,dayID));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLecturersDaysOff(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from LecturerDayOff").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<LecturerDayOff> searchLecturersDaysOff(Generic generic){
        List<LecturerDayOff> lecturerDayOffList =null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            lecturerDayOffList=session.createQuery("from LecturerDayOff where lecturer.lecturerID='"+generic+"' or lecturer.lecturerFirstName='"+generic+"' or lecturer.lecturerMiddleName='"+generic+"' or lecturer.lecturerLastName='"+generic+"' or day.dayName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerDayOffList;
    }
}
