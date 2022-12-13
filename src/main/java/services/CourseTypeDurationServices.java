package services;

import dataAccess.CourseTypeDurationDAO;
import entities.CourseTypeDuration;

import java.util.List;

public class CourseTypeDurationServices {
    private CourseTypeDurationDAO courseTypeDurationDAO=new CourseTypeDurationDAO();
    public List<CourseTypeDuration> findAllCourseTypeDuration(){
        return courseTypeDurationDAO.findAllCourseTypeDuration();
    }
    public CourseTypeDuration findCourseTypeDurationByBothID(int courseID,int typeID){
        return courseTypeDurationDAO.findCourseTypeDurationByBothID(courseID,typeID);
    }
    public void deleteCourseTypeDurationByBothID(int courseID,int typeID){
        courseTypeDurationDAO.deleteCourseTypeDurationByBothID(courseID,typeID);
    }
    public void deleteAllCourseTypeDurations(){
        courseTypeDurationDAO.deleteAllCourseTypeDuration();
    }
    public void insertCourseTypeDuration(CourseTypeDuration courseTypeDuration){
        courseTypeDurationDAO.insertCourseTypeDuration(courseTypeDuration);
    }
    public void updateCourseTypeDuration(CourseTypeDuration courseTypeDuration){
        courseTypeDurationDAO.updateCourseTypeDuration(courseTypeDuration);
    }
    public <Generic> List<CourseTypeDuration> searchCourseTypeDuration(Generic generic){
        return courseTypeDurationDAO.searchCourseTypeDuration(generic);
    }
}
