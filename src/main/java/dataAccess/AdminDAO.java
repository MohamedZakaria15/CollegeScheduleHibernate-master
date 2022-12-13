package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Admin;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class AdminDAO {
    public List<Admin> findAllAdmins(){
        List<Admin> admins=null;
        Transaction transaction=null;
      try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            admins=session.createQuery("from Admin").getResultList();
            transaction.commit();
      }catch (Exception exception){
          transaction.rollback();
          exception.printStackTrace();
      }
      return admins;
    }
    public Admin findAdminByID(int id){
        Admin admin=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            admin=session.get(Admin.class,id);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return admin;
    }
   public void deleteAdminByID(int id){
       Transaction transaction=null;
     try(Session session=HibernateUtil.getSessionFactory().openSession()){
         transaction=session.beginTransaction();
         session.delete(this.findAdminByID(id));
         transaction.commit();
     }catch (Exception exception){
         transaction.rollback();
         exception.printStackTrace();
     }
    }
    public void deleteAllAdmins(){
        Transaction transaction=null;
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.createQuery("delete from Admin where id !=1").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
   public void insertAdmin(Admin admin){
       Transaction transaction=null;
       try (Session session=HibernateUtil.getSessionFactory().openSession()){
           transaction=session.beginTransaction();
           session.save(admin);
           transaction.commit();
       }catch (Exception exception){
           transaction.rollback();
           exception.printStackTrace();
       }
   }
    public void updateAdmin(Admin admin){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(admin);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
   public Admin loginCheck(String email,String password){
        Admin admin=null;
       for(Admin temp:this.findAllAdmins()){
           if(temp.getAdminEmail().equals(email) && temp.getAdminPassword().equals(password)){
               admin=temp;
           }
       }
       return admin;
   }
    public Admin emailCheck(String email){
        Admin admin=null;
        for(Admin temp:this.findAllAdmins()){
            if(temp.getAdminEmail().equals(email)){
                admin=temp;
            }
        }
        return admin;
    }
   public <Generic> List<Admin> searchAdmins(Generic generic){
       List<Admin> admins=null;
       Transaction transaction=null;
       try (Session session=HibernateUtil.getSessionFactory().openSession()){
           transaction=session.beginTransaction();
           admins=session.createQuery("from Admin where adminEmail like '%"+generic+"%' or adminFirstName='"+generic+"' or adminLastName='"+generic+"' or adminMiddleName='"+generic+"' or adminID='"+generic+"'").list();
           transaction.commit();
       }catch (Exception exception){
           transaction.rollback();
           exception.printStackTrace();
       }
       return admins;
   }
}
