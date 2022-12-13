package server;

import entities.Course;
import services.CourseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Courses")
public class Courses extends HttpServlet {
    CourseServices courseServices=new CourseServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!courseServices.constraintCheck(id)){
                    courseServices.deleteCourseByID(id);
                    resp.sendRedirect("Courses");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Delete")){
                boolean flag=false;
                for(Course course: courseServices.findAllCourses()){
                    if(courseServices.constraintCheck(course.getCourseID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    courseServices.deleteAllCourses();
                    resp.sendRedirect("Courses");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("courses",courseServices.searchCourses(key));
                req.getRequestDispatcher("courses.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("courses",courseServices.findAllCourses());
            req.getRequestDispatcher("courses.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int id = Integer.parseInt(req.getParameter("ID_info"));
                String name = req.getParameter("name_info");
                float fullTime = Float.parseFloat(req.getParameter("full_time"));
                if (action.equals("Add")) {
                    if (courseServices.findCourseByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            courseServices.insertCourse(new Course(id, name,fullTime));
                            resp.sendRedirect("Courses");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (courseServices.findCourseByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            courseServices.updateCourse(new Course(id,name,fullTime));
                            resp.sendRedirect("Courses");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Courses");
        }
    }
}
