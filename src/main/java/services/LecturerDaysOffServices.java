package services;

import dataAccess.LecturerDaysOffDAO;
import entities.LecturerDayOff;

import java.util.List;

public class LecturerDaysOffServices {
    private LecturerDaysOffDAO lecturerDaysOffDAO=new LecturerDaysOffDAO();

    public List<LecturerDayOff> findAllLecturersDaysOff(){
        return lecturerDaysOffDAO.findAllLecturersDaysOff();
    }
    public LecturerDayOff findLecturerDayOffByBothID(int id, int id1){
        return lecturerDaysOffDAO.findLecturerDayOffByBothID(id,id1);
    }
    public void insertLecturerDayOff(LecturerDayOff lecturerDayOff){
        lecturerDaysOffDAO.insertLecturerDayOff(lecturerDayOff);
    }
    public void deleteLecturerDayOffByBothID(int id,int id1){
        lecturerDaysOffDAO.deleteLecturerDayOffByBothID(id,id1);
    }
    public int daysOffForLecturer(int lecturerId){
        return lecturerDaysOffDAO.daysOffForLecturer(lecturerId);
    }
    public void deleteAllLecturersDaysOff(){
        lecturerDaysOffDAO.deleteAllLecturersDaysOff();
    }
    public <Generic> List<LecturerDayOff> searchLecturersDaysOff(Generic generic){
        return lecturerDaysOffDAO.searchLecturersDaysOff(generic);
    }
}
