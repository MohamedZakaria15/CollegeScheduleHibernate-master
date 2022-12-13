package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.LecturersDistribution;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class LecturersDistributionDAO {
    public List<LecturersDistribution> findAllLecturersDistribution(){
        List<LecturersDistribution> lecturersDistributions=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturersDistributions=session.createQuery("from LecturersDistribution order by lecturersDistributionKey.level_id,lecturersDistributionKey.group_number,day_id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturersDistributions;
    }
    public void insertLecturerDistribution(LecturersDistribution lecturersDistribution){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(lecturersDistribution);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLecturersDistribution(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from LecturersDistribution").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public List<LecturersDistribution> searchLecturersDistribution(int departmentId,int levelId,int lecturerId,int groupNumber){
        boolean flag=false;
        String sql="";
        if(departmentId!=-1){
            sql+="where department_id="+departmentId;
            flag=true;
        }
        if(levelId!=-1){
            if(flag){
                sql+=" and level_id="+levelId;
            }else{
                sql+="where level_id="+levelId;
                flag=true;
            }
        }
        if(lecturerId!=-1){
            if(flag){
                sql+=" and lecturer_id="+lecturerId;
            }else{
                sql+="where lecturer_id="+lecturerId;
                flag=true;
            }
        }
        if(groupNumber!=0){
            if(flag){
                sql+=" and group_number="+groupNumber;
            }else{
                sql+="where group_number="+groupNumber;
            }
        }
        List<LecturersDistribution> lecturersDistributions=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturersDistributions=session.createQuery("from LecturersDistribution "+sql+" order by lecturersDistributionKey.level_id,lecturersDistributionKey.group_number,day_id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturersDistributions;
    }
}
