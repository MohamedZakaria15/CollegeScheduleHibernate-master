package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.PlaceType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jpa.QueryHints;

import java.util.List;
import java.util.stream.Collectors;


public class PlaceTypeDAO {
    public List<PlaceType> findAllPlaceTypes(){
        List<PlaceType> placeTypes = null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            placeTypes=session.createQuery("select distinct p from PlaceType p left join fetch p.courseTypeDurations left join fetch p.rooms").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return placeTypes;
    }
    public PlaceType findPlaceTypeByID(int id){
//        List<PlaceType> placeTypes=this.findAllPlaceTypes().stream().filter(placeType -> placeType.getTypeID()==id).collect(Collectors.toList());
//        return (placeTypes.size()==0) ? null:placeTypes.get(0);
            List<PlaceType> placeTypes=null;
            Transaction transaction=null;
            try (Session session=HibernateUtil.getSessionFactory().openSession()){
                transaction=session.beginTransaction();
                placeTypes=session.createQuery("select distinct p from PlaceType p left join fetch p.courseTypeDurations left join fetch p.rooms where p.typeID='"+id+"'").getResultList();
                transaction.commit();
            }catch (Exception exception){
                transaction.rollback();
                exception.printStackTrace();
            }
            return (placeTypes.size()==0) ? null:placeTypes.get(0);
    }
    public void deletePlaceTypeByID(int id){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.delete(this.findPlaceTypeByID(id));
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllPlaceTypes(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from PlaceType").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void insertPlaceType(PlaceType placeType){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(placeType);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void updatePlaceType(PlaceType placeType){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.update(placeType);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public boolean constraintCheck(int id){
        PlaceType placeType=this.findPlaceTypeByID(id);
        return (placeType.getCourseTypeDurations().size()==0 && placeType.getRooms().size()==0) ? false:true;
    }
    public <Generic> List<PlaceType> searchPlaceTypes(Generic generic){
        List<PlaceType> placeTypes = null;
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            placeTypes=session.createQuery("from PlaceType where typeID='"+generic+"' or typeName='"+generic+"'").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return placeTypes;
    }
}
