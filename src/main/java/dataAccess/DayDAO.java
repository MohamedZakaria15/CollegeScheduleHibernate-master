package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Day;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class DayDAO {
    public List<Day> findAllDays(){
        List<Day> days=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            days=session.createQuery("select distinct d from Day d").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return days;
    }
    public Day findDayByID(int id){
//      List<Day> days=this.findAllDays().stream().filter(day -> day.getDayID()==id).collect(Collectors.toList());
//      return (days.size()==0) ? null:days.get(0);
        List<Day> days=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            days=session.createQuery("select distinct d from Day d where d.dayID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (days.size()==0) ? null:days.get(0);
    }
}
