package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.stream.Collectors;


public class CourseDAO {
    public List<Course> findAllCourses(){
        List<Course> courses = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            courses=session.createQuery("select distinct c from Course c left join fetch c.assistants left join fetch c.lecturers left join fetch c.courseTypeDurations left join fetch c.courseDepartmentLevels").getResultList();

            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courses;
    }
    public Course findCourseByID(int id){
//       List<Course> courses=this.findAllCourses().stream().filter(course -> course.getCourseID()==id).collect(Collectors.toList());
//       return (courses.size()==0) ? null:courses.get(0);
        List<Course> courses=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            courses=session.createQuery("select distinct c from Course c left join fetch c.assistants left join fetch c.lecturers left join fetch c.courseTypeDurations left join fetch c.courseDepartmentLevels where c.courseID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (courses.size()==0) ? null:courses.get(0);
    }
    public void deleteCourseByID(int id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findCourseByID(id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllCourses(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from Course").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertCourse(Course course){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(course);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updateCourse(Course course){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(course);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        Course course=this.findCourseByID(id);
        return (course.getAssistants().size()==0 && course.getLecturers().size()==0 && course.getCourseDepartmentLevels().size()==0 && course.getCourseTypeDurations().size()==0) ? false:true;
    }
    public <Generic> List<Course> searchCourses(Generic generic){
        List<Course> courses = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            courses=session.createQuery("from Course where courseID='"+generic+"' or courseName like '%"+generic+"%' or courseFullTime='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return courses;
    }
}
