package services;


import dataAccess.LecturerCourseDAO;
import entities.LecturerCourse;

import java.util.List;

public class LecturerCourseServices {
    private LecturerCourseDAO lecturerCourseDAO=new LecturerCourseDAO();

    public List<LecturerCourse> findAllLecturerCourses(){
        return lecturerCourseDAO.findAllLecturerCourses();
    }
    public LecturerCourse findLecturerCourseByID(int id,int id2){
        return lecturerCourseDAO.findLecturerCourseByID(id,id2);
    }
    public void insertLecturerCourse(LecturerCourse lecturerCourse){
        lecturerCourseDAO.insertLecturerCourse(lecturerCourse);
    }
    public int coursesForLecturer(int lecturerId){
        return lecturerCourseDAO.coursesForLecturer(lecturerId);
    }
    public void deleteLecturerCourseByBothID(int id,int id1){
        lecturerCourseDAO.deleteLecturerCourseByBothID(id,id1);
    }
    public void deleteAllLecturerCourses(){
        lecturerCourseDAO.deleteAllLecturerCourses();
    }
    public <Generic> List<LecturerCourse> searchLecturerCourses(Generic generic){
        return lecturerCourseDAO.searchLecturersCourses(generic);
    }

}
