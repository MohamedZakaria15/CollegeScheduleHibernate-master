package server;

import entities.Lecturer;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Lecturers")
public class Lecturers extends HttpServlet {
    LecturerServices lecturerServices=new LecturerServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!lecturerServices.constraintCheck(id)){
                    lecturerServices.deleteLecturerByID(id);
                    resp.sendRedirect("Lecturers");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Delete")) {
                boolean flag=false;
                for(Lecturer lecturer: lecturerServices.findAllLecturers()){
                    if(lecturerServices.constraintCheck(lecturer.getLecturerID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    lecturerServices.deleteAllLecturers();
                    resp.sendRedirect("Lecturers");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("lecturers",lecturerServices.searchLecturers(key));
                req.setAttribute("lecturersCourses",new LecturerCourseServices().findAllLecturerCourses());
                req.setAttribute("lecturersDays",new LecturerDaysOffServices().findAllLecturersDaysOff());
                req.getRequestDispatcher("lecturer_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("lecturers",lecturerServices.findAllLecturers());
            req.setAttribute("lecturersCourses",new LecturerCourseServices().findAllLecturerCourses());
            req.setAttribute("lecturersDays",new LecturerDaysOffServices().findAllLecturersDaysOff());
            req.getRequestDispatcher("lecturer_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int id = Integer.parseInt(req.getParameter("ID_info"));
                String fname = req.getParameter("first_name");
                String mname = req.getParameter("middle_name");
                String lname = req.getParameter("last_name");
                int departmentId = Integer.parseInt(req.getParameter("department_name").substring(0,req.getParameter("department_name").lastIndexOf("-")));
                int degreeId = Integer.parseInt(req.getParameter("degree_name").substring(0,req.getParameter("degree_name").lastIndexOf("-")));
                if (action.equals("Add")) {
                    if (lecturerServices.findLecturerByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            lecturerServices.insertLecturer(new Lecturer(id,fname,mname,lname,new DepartmentServices().findDepartmentByID(departmentId),new LecturerDegreeServices().findLecturerDegreeByID(degreeId)));
                            resp.sendRedirect("Lecturers");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (lecturerServices.findLecturerByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            lecturerServices.updateLecturer(new Lecturer(id,fname,mname,lname,new DepartmentServices().findDepartmentByID(departmentId),new LecturerDegreeServices().findLecturerDegreeByID(degreeId)));
                            resp.sendRedirect("Lecturers");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Lecturers");
        }
    }
}
