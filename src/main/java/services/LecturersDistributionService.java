package services;

import dataAccess.LecturersDistributionDAO;
import entities.LecturersDistribution;

import java.util.List;

public class LecturersDistributionService {
    private LecturersDistributionDAO lecturersDistributionDAO=new LecturersDistributionDAO();

    public List<LecturersDistribution> findAllLecturersDistribution(){
        return lecturersDistributionDAO.findAllLecturersDistribution();
    }
    public void insertLecturerDistribution(LecturersDistribution lecturersDistribution){
        lecturersDistributionDAO.insertLecturerDistribution(lecturersDistribution);
    }
    public void deleteAllLecturersDistribution(){
        lecturersDistributionDAO.deleteAllLecturersDistribution();
    }
    public List<LecturersDistribution> searchLecturersDistribution(int departmentId,int levelId,int lecturerId,int groupNumber){
        return lecturersDistributionDAO.searchLecturersDistribution(departmentId,levelId,lecturerId,groupNumber);
    }
}
