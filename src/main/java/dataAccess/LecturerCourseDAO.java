package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.*;
import entities.embedded.LecturerCourseKey;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.LecturerServices;
import java.util.List;

public class LecturerCourseDAO {
    public List<LecturerCourse> findAllLecturerCourses(){
        List<LecturerCourse> lecturerCourses=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerCourses=session.createQuery("from LecturerCourse order by lecturer.id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerCourses;
    }
    public LecturerCourse findLecturerCourseByID(int id,int id2){
        LecturerCourse lecturerCourse=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturerCourse=session.get(LecturerCourse.class,new LecturerCourseKey(id,id2));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerCourse;
    }
    public int coursesForLecturer(int lecturerId){
        return new LecturerServices().findLecturerByID(lecturerId).getCourses().size();
    }
    public void deleteLecturerCourseByBothID(int lecturer_id,int course_id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findLecturerCourseByID(lecturer_id,course_id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllLecturerCourses(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from LecturerCourse").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertLecturerCourse(LecturerCourse lecturerCourse){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(lecturerCourse);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public <Generic> List<LecturerCourse> searchLecturersCourses(Generic generic){
        List<LecturerCourse> lecturerCourses =null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            lecturerCourses=session.createQuery("from LecturerCourse where lecturer.lecturerID='"+generic+"' or lecturer.lecturerFirstName='"+generic+"' or lecturer.lecturerMiddleName='"+generic+"' or lecturer.lecturerLastName='"+generic+"' or course.courseID='"+generic+"' or course.courseName like '%"+generic+"%'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturerCourses;
    }
}
