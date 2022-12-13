package server;

import entities.Admin;
import entities.AssistantDegree;
import entities.LecturerDegree;
import services.AdminServices;
import services.AssistantDegreeServices;
import services.LecturerDegreeServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Login")
public class Login extends HttpServlet {
    AdminServices adminServices=new AdminServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        Admin admin=adminServices.loginCheck(email,password);
        if(admin==null){
                resp.sendRedirect("login.html");
        }else{
            HttpSession session=req.getSession();
            session.setAttribute("email",admin.getAdminEmail());
            session.setAttribute("password",admin.getAdminPassword());
            session.setAttribute("adminID",admin.getAdminID());
            session.setAttribute("adminName",admin.getAdminFirstName()+" "+admin.getAdminLastName());
            List<AssistantDegree> assistantDegrees=new AssistantDegreeServices().findAllAssistantsDegrees();
            List<LecturerDegree> lecturerDegrees=new LecturerDegreeServices().findAllLecturerDegree();
            req.setAttribute("assistantsDegrees",assistantDegrees);
            req.setAttribute("lecturersDegrees",lecturerDegrees);
            req.getRequestDispatcher("degrees.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {   List<AssistantDegree> assistantDegrees=new AssistantDegreeServices().findAllAssistantsDegrees();
        List<LecturerDegree> lecturerDegrees=new LecturerDegreeServices().findAllLecturerDegree();
        req.setAttribute("assistantsDegrees",assistantDegrees);
        req.setAttribute("lecturersDegrees",lecturerDegrees);
        req.getRequestDispatcher("degrees.jsp").forward(req,resp);
    }
}
