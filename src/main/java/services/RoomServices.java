package services;

import dataAccess.RoomDAO;
import entities.Room;

import java.util.List;

public class RoomServices {
    private RoomDAO roomDAO=new RoomDAO();

    public List<Room> findAllRooms(){
        return roomDAO.findAllRooms();
    }
    public Room findRoomByID(int id){
        return roomDAO.findRoomByID(id);
    }
    public void deleteRoomByID(int id){
        roomDAO.deleteRoomByID(id);
    }
    public void deleteAllRooms(){
        roomDAO.deleteAllRooms();
    }
    public void insertRoom(Room room){
        roomDAO.insertRoom(room);
    }
    public void updateRoom(Room room){
        roomDAO.updateRoom(room);
    }
    public <Generic> List<Room> searchRooms(Generic generic){
        return roomDAO.searchRooms(generic);
    }
}
