package server;

import entities.LecturerDayOff;
import entities.embedded.LecturerDayOffKey;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/LecturersDaysOff")
public class LecturerDaysOff extends HttpServlet {
    LecturerDaysOffServices lecturerDaysOffServices=new LecturerDaysOffServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                int id1 = Integer.parseInt(req.getParameter("hidden1"));
                lecturerDaysOffServices.deleteLecturerDayOffByBothID(id,id1);
                req.setAttribute("lecturersDays",lecturerDaysOffServices.findAllLecturersDaysOff());
            } else if (action.equals("Delete")) {
                lecturerDaysOffServices.deleteAllLecturersDaysOff();
                req.setAttribute("lecturersDays",lecturerDaysOffServices.findAllLecturersDaysOff());
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("lecturersDays",lecturerDaysOffServices.searchLecturersDaysOff(key));
            }
        }catch (Exception e){
            req.setAttribute("lecturersDays",lecturerDaysOffServices.findAllLecturersDaysOff());
        }finally {
            req.setAttribute("lecturers",new LecturerServices().findAllLecturers());
            req.setAttribute("lecturersCourses",new LecturerCourseServices().findAllLecturerCourses());
            req.getRequestDispatcher("lecturer_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add")) {
                int lecturerId = Integer.parseInt(req.getParameter("lecturer_name").substring(0,req.getParameter("lecturer_name").lastIndexOf("-")));
                int dayId = Integer.parseInt(req.getParameter("day_name").substring(0,req.getParameter("day_name").lastIndexOf("-")));
                if (lecturerDaysOffServices.findLecturerDayOffByBothID(lecturerId,dayId) != null) {
                    req.getRequestDispatcher("add_form.html").include(req, resp);
                } else {
                    try {
                        lecturerDaysOffServices.insertLecturerDayOff(new LecturerDayOff(new LecturerDayOffKey(lecturerId,dayId)));
                        resp.sendRedirect("LecturersDaysOff");
                    } catch (Exception e) {
                        req.getRequestDispatcher("Error_form.html").include(req, resp);
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("LecturersDaysOff");
        }
    }
}
