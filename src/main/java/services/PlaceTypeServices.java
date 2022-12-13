package services;

import dataAccess.PlaceTypeDAO;
import entities.PlaceType;

import java.util.List;

public class PlaceTypeServices {
    private PlaceTypeDAO placeTypeDAO=new PlaceTypeDAO();

    public List<PlaceType> findAllPlaceTypes(){
        return placeTypeDAO.findAllPlaceTypes();
    }
    public PlaceType findPlaceTypeByID(int id){
        return placeTypeDAO.findPlaceTypeByID(id);
    }
    public void deletePlaceTypeByID(int id){
        placeTypeDAO.deletePlaceTypeByID(id);
    }
    public void deleteAllPlaceTypes(){
        placeTypeDAO.deleteAllPlaceTypes();
    }
    public void insertPlaceType(PlaceType placeType){
        placeTypeDAO.insertPlaceType(placeType);
    }
    public void updatePlaceType(PlaceType placeType){
        placeTypeDAO.updatePlaceType(placeType);
    }
    public boolean constraintCheck(int id){
        return placeTypeDAO.constraintCheck(id);
    }
    public <Generic> List<PlaceType> searchPlaceTypes(Generic generic){
        return placeTypeDAO.searchPlaceTypes(generic);
    }
}
