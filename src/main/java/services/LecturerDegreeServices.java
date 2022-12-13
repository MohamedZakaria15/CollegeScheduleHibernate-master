package services;

import dataAccess.LecturerDegreeDAO;
import entities.LecturerDegree;

import java.util.List;

public class LecturerDegreeServices {
    private LecturerDegreeDAO lecturerDegreeDAO=new LecturerDegreeDAO();

    public List<LecturerDegree> findAllLecturerDegree(){
        return lecturerDegreeDAO.findAllLecturerDegrees();
    }
    public LecturerDegree findLecturerDegreeByID(int id){
        return lecturerDegreeDAO.findLecturerDegreeByID(id);
    }
    public void insertLecturerDegree(LecturerDegree lecturerDegree){
        lecturerDegreeDAO.insertLecturerDegree(lecturerDegree);
    }
    public void deleteLecturerDegreeByID(int id){
        lecturerDegreeDAO.deleteLecturerDegreeByID(id);
    }
    public void deleteAllLecturerDegrees(){
        lecturerDegreeDAO.deleteAllLecturerDegrees();
    }
    public void updateLecturerDegree(LecturerDegree lecturerDegree){
        lecturerDegreeDAO.updateLecturerDegree(lecturerDegree);
    }
    public boolean constraintCheck(int id){
        return lecturerDegreeDAO.constraintCheck(id);
    }
    public <Generic> List<LecturerDegree> searchLecturerDegrees(Generic generic){
        return lecturerDegreeDAO.searchLecturerDegrees(generic);
    }
}
