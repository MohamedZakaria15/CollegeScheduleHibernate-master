package server;

import entities.LecturerDegree;
import services.AssistantDegreeServices;
import services.LecturerDegreeServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LecturerDegrees")
public class LecturerDegrees extends HttpServlet {
    LecturerDegreeServices lecturerDegreeServices = new LecturerDegreeServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");
        try {
            if (action.equals("deleteOne")) {
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!lecturerDegreeServices.constraintCheck(id)){
                    lecturerDegreeServices.deleteLecturerDegreeByID(id);
                    resp.sendRedirect("Login");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Delete")) {
                boolean flag=false;
                for(LecturerDegree lecturerDegree: lecturerDegreeServices.findAllLecturerDegree()){
                    if(lecturerDegreeServices.constraintCheck(lecturerDegree.getDegreeID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    lecturerDegreeServices.deleteAllLecturerDegrees();
                    resp.sendRedirect("Login");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Search")) {
                    String key = req.getParameter("search");
                    req.setAttribute("assistantsDegrees", new AssistantDegreeServices().findAllAssistantsDegrees());
                    req.setAttribute("lecturersDegrees", lecturerDegreeServices.searchLecturerDegrees(key));
                    req.getRequestDispatcher("degrees.jsp").forward(req, resp);
            }
        }catch (Throwable e) {
            System.out.println("In Catch");
            if(action.equals("deleteOne") || action.equals("deleteAll")){
                req.getRequestDispatcher("delete.html").include(req,resp);
            }else {
                resp.sendRedirect("Login");
            }
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
                    if (lecturerDegreeServices.findLecturerDegreeByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            lecturerDegreeServices.insertLecturerDegree(new LecturerDegree(id, name, minimum, maximum));
                            resp.sendRedirect("Login");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (lecturerDegreeServices.findLecturerDegreeByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            lecturerDegreeServices.updateLecturerDegree(new LecturerDegree(id, name, minimum, maximum));
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
