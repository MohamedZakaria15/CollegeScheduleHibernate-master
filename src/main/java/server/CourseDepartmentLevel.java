package server;

import entities.embedded.CourseDepartmentLevelKey;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CourseDepartmentLevel")
public class CourseDepartmentLevel extends HttpServlet {
   CourseDepartmentLevelServices courseDepartmentLevelServices=new CourseDepartmentLevelServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id=Integer.parseInt(req.getParameter("hidden"));
                int id1=Integer.parseInt(req.getParameter("hidden1"));
                int id2=Integer.parseInt(req.getParameter("hidden2"));
                courseDepartmentLevelServices.deleteCourseDepartmentLevelByAllThreeID(id,id1,id2);
                req.setAttribute("coursesTypesDurations",new CourseTypeDurationServices().findAllCourseTypeDuration());
                req.setAttribute("coursesDepartmentsLevels",courseDepartmentLevelServices.findAllCourseDepartmentLevel());
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }else if(action.equals("Delete")){
                courseDepartmentLevelServices.deleteAllCourseDepartmentLevel();
                req.setAttribute("coursesTypesDurations",new CourseTypeDurationServices().findAllCourseTypeDuration());
                req.setAttribute("coursesDepartmentsLevels",courseDepartmentLevelServices.findAllCourseDepartmentLevel());
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("coursesTypesDurations",new CourseTypeDurationServices().findAllCourseTypeDuration());
                req.setAttribute("coursesDepartmentsLevels",courseDepartmentLevelServices.searchCourseDepartmentLevel(key));
                req.getRequestDispatcher("course_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("coursesTypesDurations",new CourseTypeDurationServices().findAllCourseTypeDuration());
            req.setAttribute("coursesDepartmentsLevels",courseDepartmentLevelServices.findAllCourseDepartmentLevel());
            req.getRequestDispatcher("course_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int courseId = Integer.parseInt(req.getParameter("courseName").substring(0,req.getParameter("courseName").lastIndexOf("-")));
                int departmentId = Integer.parseInt(req.getParameter("departmentName").substring(0,req.getParameter("departmentName").lastIndexOf("-")));
                int levelId = Integer.parseInt(req.getParameter("levelName").substring(0,req.getParameter("levelName").lastIndexOf("-")));
                int group=Integer.parseInt(req.getParameter("group"));
                int section=Integer.parseInt(req.getParameter("section"));
                if (action.equals("Add")) {
                    if (courseDepartmentLevelServices.findCourseDepartmentLevelByAllThreeID(courseId,levelId,departmentId) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            courseDepartmentLevelServices.insertCourseDepartmentLevel(new entities.CourseDepartmentLevel(new CourseDepartmentLevelKey(courseId,levelId,departmentId),section,group));
                            resp.sendRedirect("CourseDepartmentLevel");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (courseDepartmentLevelServices.findCourseDepartmentLevelByAllThreeID(courseId,levelId,departmentId) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            courseDepartmentLevelServices.updateCourseDepartmentLevel(new entities.CourseDepartmentLevel(new CourseDepartmentLevelKey(courseId,levelId,departmentId),section,group));
                            resp.sendRedirect("CourseDepartmentLevel");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("CourseDepartmentLevel");
        }
    }
}
