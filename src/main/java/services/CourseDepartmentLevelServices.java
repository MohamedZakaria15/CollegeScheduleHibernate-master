package services;

import dataAccess.CourseDepartmentLevelDAO;
import entities.CourseDepartmentLevel;

import java.util.List;

public class CourseDepartmentLevelServices {
    private CourseDepartmentLevelDAO courseDepartmentLevelDAO=new CourseDepartmentLevelDAO();
    public List<CourseDepartmentLevel> findAllCourseDepartmentLevel(){
        return courseDepartmentLevelDAO.findAllCourseDepartmentLevel();
    }
    public CourseDepartmentLevel findCourseDepartmentLevelByAllThreeID(int courseID,int levelID,int departmentID){
        return courseDepartmentLevelDAO.findCourseDepartmentLevelByAllThreeID(courseID,levelID,departmentID);
    }
    public void deleteCourseDepartmentLevelByAllThreeID(int courseID,int levelID,int departmentID){
        courseDepartmentLevelDAO.deleteCourseDepartmentLevelByAllThreeID(courseID,levelID,departmentID);
    }
    public void deleteAllCourseDepartmentLevel(){
        courseDepartmentLevelDAO.deleteAllCourseDepartmentLevel();
    }
    public void insertCourseDepartmentLevel(CourseDepartmentLevel courseDepartmentLevel){
        courseDepartmentLevelDAO.insertCourseDepartmentLevel(courseDepartmentLevel);
    }
    public void updateCourseDepartmentLevel(CourseDepartmentLevel courseDepartmentLevel){
        courseDepartmentLevelDAO.updateCourseDepartmentLevel(courseDepartmentLevel);
    }
    public <Generic> List<CourseDepartmentLevel> searchCourseDepartmentLevel(Generic generic){
        return courseDepartmentLevelDAO.searchCourseDepartmentLevel(generic);
    }

}
