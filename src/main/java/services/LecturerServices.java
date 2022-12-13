package services;

import dataAccess.LecturerDAO;
import entities.Lecturer;

import java.util.List;

public class LecturerServices {
    private LecturerDAO lecturerDAO = new LecturerDAO();

    public List<Lecturer> findAllLecturers() {
        return lecturerDAO.findAllLecturers();
    }

    public Lecturer findLecturerByID(int id) {
        return lecturerDAO.findLecturerByID(id);
    }

    public void deleteLecturerByID(int id) {
        lecturerDAO.deleteLecturerByID(id);
    }

    public void deleteAllLecturers() {
        lecturerDAO.deleteAllLecturers();
    }

    public void insertLecturer(Lecturer lecturer) {
        lecturerDAO.insertLecturer(lecturer);
    }

    public void updateLecturer(Lecturer lecturer) {
        lecturerDAO.updateLecturer(lecturer);
    }

    public boolean constraintCheck(int id) {
        return lecturerDAO.constraintCheck(id);
    }

    public <Generic> List<Lecturer> searchLecturers(Generic generic) {
        return lecturerDAO.searchLecturers(generic);
    }
}
