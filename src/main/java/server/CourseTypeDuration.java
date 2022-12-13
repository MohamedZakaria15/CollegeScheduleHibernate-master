package server;

import entities.embedded.CourseTypeDurationKey;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CourseTypeDuration")
public class CourseTypeDuration extends HttpServlet {
    CourseTypeDurationServices courseTypeDurationServices=new CourseTypeDurationServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id=Integer.parseInt(req.getParameter("hidden"));
                int id1=Integer.parseInt(req.getParameter("hidden1"));
                courseTypeDurationServices.deleteCourseTypeDurationByBothID(id,id1);
                req.setAttribute("coursesTypesDurations",courseTypeDurationServices.findAllCourseTypeDuration());
                req.setAttribute("coursesDepartmentsLevels",new CourseDepartmentLevelServices().findAllCourseDepartmentLevel());
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }else if(action.equals("Delete")){
                courseTypeDurationServices.deleteAllCourseTypeDurations();
                req.setAttribute("coursesTypesDurations",courseTypeDurationServices.findAllCourseTypeDuration());
                req.setAttribute("coursesDepartmentsLevels",new CourseDepartmentLevelServices().findAllCourseDepartmentLevel());
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("coursesTypesDurations",courseTypeDurationServices.searchCourseTypeDuration(key));
                req.setAttribute("coursesDepartmentsLevels",new CourseDepartmentLevelServices().findAllCourseDepartmentLevel());
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("coursesTypesDurations",courseTypeDurationServices.findAllCourseTypeDuration());
            req.setAttribute("coursesDepartmentsLevels",new CourseDepartmentLevelServices().findAllCourseDepartmentLevel());
            req.getRequestDispatcher("course_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int courseId = Integer.parseInt(req.getParameter("courseName").substring(0,req.getParameter("courseName").lastIndexOf("-")));
                int typeId = Integer.parseInt(req.getParameter("typeName").substring(0,req.getParameter("typeName").lastIndexOf("-")));
                float duration=Float.parseFloat(req.getParameter("duration_info"));
                if (action.equals("Add")) {
                    if (courseTypeDurationServices.findCourseTypeDurationByBothID(courseId,typeId) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            courseTypeDurationServices.insertCourseTypeDuration(new entities.CourseTypeDuration(new CourseTypeDurationKey(courseId,typeId),duration));
                            resp.sendRedirect("CourseTypeDuration");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (courseTypeDurationServices.findCourseTypeDurationByBothID(courseId,typeId) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            courseTypeDurationServices.updateCourseTypeDuration(new entities.CourseTypeDuration(new CourseTypeDurationKey(courseId,typeId),duration));
                            resp.sendRedirect("CourseTypeDuration");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("CourseTypeDuration");
        }
    }
}
