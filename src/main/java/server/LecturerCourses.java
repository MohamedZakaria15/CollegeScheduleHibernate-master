package server;

import entities.LecturerCourse;
import entities.embedded.LecturerCourseKey;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LecturerCourses")
public class LecturerCourses extends HttpServlet {
    private LecturerCourseServices lecturerCourseServices=new LecturerCourseServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                int id1 = Integer.parseInt(req.getParameter("hidden1"));
                lecturerCourseServices.deleteLecturerCourseByBothID(id,id1);
                req.setAttribute("lecturersCourses",lecturerCourseServices.findAllLecturerCourses());
            } else if (action.equals("Delete")) {
                lecturerCourseServices.deleteAllLecturerCourses();
                req.setAttribute("lecturersCourses",lecturerCourseServices.findAllLecturerCourses());
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("lecturersCourses",lecturerCourseServices.searchLecturerCourses(key));
            }
        }catch (Exception e){
            req.setAttribute("lecturersCourses",lecturerCourseServices.findAllLecturerCourses());
        }finally {
            req.setAttribute("lecturers",new LecturerServices().findAllLecturers());
            req.setAttribute("lecturersDays",new LecturerDaysOffServices().findAllLecturersDaysOff());
            req.getRequestDispatcher("lecturer_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add")) {
                int lecturerId = Integer.parseInt(req.getParameter("lecturer_name").substring(0,req.getParameter("lecturer_name").lastIndexOf("-")));
                int courseId = Integer.parseInt(req.getParameter("course_name").substring(0,req.getParameter("course_name").lastIndexOf("-")));
                if (lecturerCourseServices.findLecturerCourseByID(lecturerId,courseId) != null) {
                    req.getRequestDispatcher("add_form.html").include(req, resp);
                } else {
                    try {
                        lecturerCourseServices.insertLecturerCourse(new LecturerCourse(new LecturerCourseKey(lecturerId,courseId)));
                        resp.sendRedirect("LecturerCourses");
                    } catch (Exception e) {
                        req.getRequestDispatcher("Error_form.html").include(req, resp);
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("LecturerCourses");
        }
    }
}
