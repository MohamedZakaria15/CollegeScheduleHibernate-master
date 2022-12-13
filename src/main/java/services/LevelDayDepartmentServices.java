package services;

import dataAccess.LevelDayDepartmentDAO;
import entities.LevelDayDepartment;

import java.util.List;

public class LevelDayDepartmentServices {
    private LevelDayDepartmentDAO levelDayDepartmentDAO=new LevelDayDepartmentDAO();
    public List<LevelDayDepartment> findAllLevelDayDepartment(){
        return levelDayDepartmentDAO.findAllLevelDayDepartment();
    }
    public LevelDayDepartment findLevelDayDepartmentByAllThreeID(int id,int id1,int id2){
        return levelDayDepartmentDAO.findLevelDayDepartmentByAllThreeID(id,id1,id2);
    }
    public void deleteLevelDayDepartmentByAllThreeID(int id,int id1,int id2){
        levelDayDepartmentDAO.deleteLevelDayDepartmentByAllThreeID(id,id1,id2);
    }
    public void deleteAllLevelDayDepartment(){
        levelDayDepartmentDAO.deleteAllLevelDayDepartment();
    }
    public void insertLevelDayDepartment(LevelDayDepartment levelDayDepartment){
        levelDayDepartmentDAO.insertLevelDayDepartment(levelDayDepartment);
    }
    public <Generic> List<LevelDayDepartment> searchLevelDayDepartment(Generic generic){
        return levelDayDepartmentDAO.searchLevelDayDepartment(generic);
    }
}
