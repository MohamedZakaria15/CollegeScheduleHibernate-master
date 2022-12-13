package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;



public class DepartmentDAO {
    public List<Department> findAllDepartments(){
        List<Department> departments = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            departments=session.createQuery("select distinct d from Department d left join fetch d.levelDayDepartments left join fetch d.assistants left join fetch d.lecturers left join fetch d.courseDepartmentLevels").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return departments;
    }
    public Department findDepartmentByID(int id){
//        List<Department> departments=this.findAllDepartments().stream().filter(department -> department.getDepartmentID()==id).collect(Collectors.toList());
//        return (departments.size()==0) ? null:departments.get(0);
        List<Department> departments=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            departments=session.createQuery("select distinct d from Department d left join fetch d.levelDayDepartments left join fetch d.assistants left join fetch d.lecturers left join fetch d.courseDepartmentLevels where d.departmentID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (departments.size()==0) ? null:departments.get(0);
    }
    public void deleteDepartmentByID(int id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findDepartmentByID(id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllDepartments(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from Department").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertDepartment(Department department){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(department);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateDepartment(Department department){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(department);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        Department department=this.findDepartmentByID(id);
        return (department.getAssistants().size()==0 && department.getLecturers().size()==0 && department.getLevelDayDepartments().size()==0 && department.getCourseDepartmentLevels().size()==0) ? false:true;
    }

    public <Generic> List<Department> searchDepartments(Generic generic){
        List<Department> departments = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            departments=session.createQuery("from Department where departmentID='"+generic+"' or departmentName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return departments;
    }
}
