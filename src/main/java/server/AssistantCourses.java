package server;

import entities.AssistantCourse;
import entities.embedded.AssistantCourseKey;
import services.AssistantCourseServices;
import services.AssistantDayServices;
import services.AssistantServices;
import services.CourseServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AssistantCourses")
public class AssistantCourses extends HttpServlet {
    private AssistantCourseServices assistantCourseServices=new AssistantCourseServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                int id1 = Integer.parseInt(req.getParameter("hidden1"));
                assistantCourseServices.deleteAssistantCourseByBothID(id,id1);
                req.setAttribute("assistantsCourses",assistantCourseServices.findAllAssistantCourses());
            } else if (action.equals("Delete")) {
                assistantCourseServices.deleteAllAssistantCourses();
                req.setAttribute("assistantsCourses",assistantCourseServices.findAllAssistantCourses());
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("assistantsCourses",assistantCourseServices.searchAssistantCourses(key));
            }
        }catch (Exception e){
            req.setAttribute("assistantsCourses",assistantCourseServices.findAllAssistantCourses());
        }finally {
            req.setAttribute("assistants",new AssistantServices().findAllAssistants());
            req.setAttribute("assistantsDays",new AssistantDayServices().findAllAssistantDays());
            req.getRequestDispatcher("assistant_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add")) {
                int assistantId = Integer.parseInt(req.getParameter("assistant_name").substring(0,req.getParameter("assistant_name").lastIndexOf("-")));
                int courseId = Integer.parseInt(req.getParameter("course_name").substring(0,req.getParameter("course_name").lastIndexOf("-")));
                if (assistantCourseServices.findAssistantCourseByID(assistantId,courseId) != null) {
                    req.getRequestDispatcher("add_form.html").include(req, resp);
                } else {
                    try {
                        assistantCourseServices.insertAssistantCourse(new AssistantCourse(new AssistantCourseKey(assistantId,courseId)));
                        resp.sendRedirect("AssistantCourses");
                    } catch (Exception e) {
                        req.getRequestDispatcher("Error_form.html").include(req, resp);
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("AssistantCourses");
        }
    }
}
