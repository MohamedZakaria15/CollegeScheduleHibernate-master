package server;

import entities.Assistant;
import services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Assistants")
public class Assistants extends HttpServlet {
    AssistantServices assistantServices=new AssistantServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!assistantServices.constraintCheck(id)){
                    assistantServices.deleteAssistantByID(id);
                    resp.sendRedirect("Assistants");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Delete")) {
                boolean flag=false;
                for(Assistant assistant: assistantServices.findAllAssistants()){
                    if(assistantServices.constraintCheck(assistant.getAssistantID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    assistantServices.deleteAllAssistants();
                    resp.sendRedirect("Assistants");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("assistants",assistantServices.searchAssistants(key));
                req.setAttribute("assistantsCourses",new AssistantCourseServices().findAllAssistantCourses());
                req.setAttribute("assistantsDays",new AssistantDayServices().findAllAssistantDays());
                req.getRequestDispatcher("assistant_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("assistants",assistantServices.findAllAssistants());
            req.setAttribute("assistantsCourses",new AssistantCourseServices().findAllAssistantCourses());
            req.setAttribute("assistantsDays",new AssistantDayServices().findAllAssistantDays());
            req.getRequestDispatcher("assistant_info.jsp").forward(req,resp);
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
                    if (assistantServices.findAssistantByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            assistantServices.insertAssistant(new Assistant(id,fname,mname,lname,new DepartmentServices().findDepartmentByID(departmentId),new AssistantDegreeServices().findAssistantDegreeByID(degreeId)));
                            resp.sendRedirect("Assistants");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (assistantServices.findAssistantByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            assistantServices.updateAssistant(new Assistant(id,fname,mname,lname,new DepartmentServices().findDepartmentByID(departmentId),new AssistantDegreeServices().findAssistantDegreeByID(degreeId)));
                            resp.sendRedirect("Assistants");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Assistants");
        }

    }
}
