package server;

import entities.AssistantDegree;
import services.AssistantDegreeServices;
import services.LecturerDegreeServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AssistantDegrees")
public class AssistantDegrees extends HttpServlet {
    AssistantDegreeServices assistantDegreeServices=new AssistantDegreeServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!assistantDegreeServices.constraintCheck(id)){
                    assistantDegreeServices.deleteAssistantDegreeByID(id);
                    resp.sendRedirect("Login");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Delete")) {
                boolean flag=false;
                for(AssistantDegree assistantDegree: assistantDegreeServices.findAllAssistantsDegrees()){
                    if(assistantDegreeServices.constraintCheck(assistantDegree.getDegreeID())){
                       flag=true;
                       break;
                    }
                }
                if(flag==false) {
                    assistantDegreeServices.deleteAllAssistantDegrees();
                    resp.sendRedirect("Login");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("assistantsDegrees",assistantDegreeServices.searchAssistantDegrees(key));
                req.setAttribute("lecturersDegrees",new LecturerDegreeServices().findAllLecturerDegree());
                req.getRequestDispatcher("degrees.jsp").forward(req,resp);
            }
        }catch (Exception e){
            resp.sendRedirect("Login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int id = Integer.parseInt(req.getParameter("ID_info"));
                String name = req.getParameter("name_info");
                float minimum = Float.parseFloat(req.getParameter("min_h_info"));
                float maximum = Float.parseFloat(req.getParameter("max_h_info"));
                if (action.equals("Add")) {
                    if (assistantDegreeServices.findAssistantDegreeByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            assistantDegreeServices.insertAssistantDegree(new AssistantDegree(id, name, minimum, maximum));
                            resp.sendRedirect("Login");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (assistantDegreeServices.findAssistantDegreeByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            assistantDegreeServices.updateAssistantDegree(new AssistantDegree(id, name, minimum, maximum));
                            resp.sendRedirect("Login");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Login");
        }
    }
}
