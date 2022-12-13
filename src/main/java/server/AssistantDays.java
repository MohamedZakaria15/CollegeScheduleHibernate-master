package server;

import entities.AssistantDay;
import entities.embedded.AssistantDayKey;
import services.AssistantCourseServices;
import services.AssistantDayServices;
import services.AssistantServices;
import services.DayServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AssistantDays")
public class AssistantDays extends HttpServlet {
    AssistantDayServices assistantDayServices=new AssistantDayServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                int id1 = Integer.parseInt(req.getParameter("hidden1"));
                assistantDayServices.deleteAssistantDayByBothID(id,id1);
                req.setAttribute("assistantsDays",assistantDayServices.findAllAssistantDays());
            } else if (action.equals("Delete")) {
                assistantDayServices.deleteAllAssistantDays();
                req.setAttribute("assistantsDays",assistantDayServices.findAllAssistantDays());
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("assistantsDays",assistantDayServices.searchAssistantDays(key));
            }
        }catch (Exception e){
            req.setAttribute("assistantsDays",assistantDayServices.findAllAssistantDays());
        }finally {
            req.setAttribute("assistants",new AssistantServices().findAllAssistants());
            req.setAttribute("assistantsCourses",new AssistantCourseServices().findAllAssistantCourses());
            req.getRequestDispatcher("assistant_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add")) {
                int assistantId = Integer.parseInt(req.getParameter("assistant_name").substring(0,req.getParameter("assistant_name").lastIndexOf("-")));
                int dayId = Integer.parseInt(req.getParameter("day_name").substring(0,req.getParameter("day_name").lastIndexOf("-")));
                if (assistantDayServices.findAssistantDayByBothID(assistantId,dayId) != null) {
                    req.getRequestDispatcher("add_form.html").include(req, resp);
                } else {
                    try {
                        assistantDayServices.insertAssistantDay(new AssistantDay(new AssistantDayKey(assistantId,dayId)));
                        resp.sendRedirect("AssistantDays");
                    } catch (Exception e) {
                        req.getRequestDispatcher("Error_form.html").include(req, resp);
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("AssistantDays");
        }
    }
}
