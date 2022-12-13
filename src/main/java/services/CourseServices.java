package services;

import dataAccess.CourseDAO;
import entities.Course;

import java.util.List;

public class CourseServices {
    private CourseDAO courseDAO=new CourseDAO();

    public List<Course> findAllCourses(){
        return courseDAO.findAllCourses();
    }
    public Course findCourseByID(int id){
        return courseDAO.findCourseByID(id);
    }
    public void deleteCourseByID(int id){
        courseDAO.deleteCourseByID(id);
    }
    public void deleteAllCourses(){
        courseDAO.deleteAllCourses();
    }
    public void insertCourse(Course course){
        courseDAO.insertCourse(course);
    }
    public void updateCourse(Course course){
        courseDAO.updateCourse(course);
    }
    public boolean constraintCheck(int id){
        return courseDAO.constraintCheck(id);
    }
    public <Generic> List<Course> searchCourses(Generic generic){
        return courseDAO.searchCourses(generic);
    }
}
