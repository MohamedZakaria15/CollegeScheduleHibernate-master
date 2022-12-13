package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Time;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TimeDAO{
    public Time findTime(){
        List<Time> times=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            times=session.createQuery("from Time").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return times.get(0);
    }
    public void updateTime(Time time){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.createQuery("delete from Time").executeUpdate();
            session.save(time);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
}
