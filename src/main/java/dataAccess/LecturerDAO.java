package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.Lecturer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LecturerDAO {
    public List<Lecturer> findAllLecturers() {
        List<Lecturer> lecturers = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            lecturers = session.createQuery("select distinct l from Lecturer l left join fetch l.days left join fetch l.courses").getResultList();
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturers;
    }

    public Lecturer findLecturerByID(int id) {
//        List<Lecturer> lecturers = this.findAllLecturers().stream().filter(lecturer -> lecturer.getLecturerID() == id).collect(Collectors.toList());
//        return (lecturers.size()==0) ? null:lecturers.get(0);
        List<Lecturer> lecturers=null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            lecturers=session.createQuery("select distinct l from Lecturer l left join fetch l.days left join fetch l.courses where l.lecturerID='"+id+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return (lecturers.size()==0) ? null:lecturers.get(0);
    }

    public void deleteLecturerByID(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(this.findLecturerByID(id));
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    public void deleteAllLecturers() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("delete from Lecturer").executeUpdate();
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    public void insertLecturer(Lecturer lecturer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(lecturer);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    public void updateLecturer(Lecturer lecturer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(lecturer);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
    }

    public boolean constraintCheck(int id) {
        Lecturer lecturer = this.findLecturerByID(id);
        return (lecturer.getCourses().size() == 0 && lecturer.getDays().size() == 0) ? false : true;
    }

    public <Generic> List<Lecturer> searchLecturers(Generic generic) {
        List<Lecturer> lecturers = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            lecturers = session.createQuery("from Lecturer where lecturerID='" + generic + "' or lecturerFirstName='" + generic + "' or lecturerMiddleName='" + generic + "' or lecturerLastName='" + generic + "' or department.departmentName='" + generic + "' or lecturerDegree.degreeName='" + generic + "'").getResultList();
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            exception.printStackTrace();
        }
        return lecturers;
    }
}
