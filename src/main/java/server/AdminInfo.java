package server;

import entities.Admin;
import services.AdminServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminInfo")
public class AdminInfo extends HttpServlet {
    AdminServices adminServices=new AdminServices();
    @Override
    synchronized protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id=Integer.parseInt(req.getParameter("hidden"));
                adminServices.deleteAdminByID(id);
                req.setAttribute("admins",adminServices.findAllAdmins());
                req.getRequestDispatcher("admin_info.jsp").forward(req,resp);
            }else if(action.equals("Delete")){
                adminServices.deleteAllAdmins();
                req.setAttribute("admins",adminServices.findAllAdmins());
                req.getRequestDispatcher("admin_info.jsp").forward(req,resp);
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("admins",adminServices.searchAdmins(key));
                req.getRequestDispatcher("admin_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("admins",adminServices.findAllAdmins());
            req.getRequestDispatcher("admin_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                String fnameInfo = req.getParameter("fname_info");
                String mnameInfo = req.getParameter("mname_info");
                String lnameInfo = req.getParameter("lname_info");
                String emailInfo = req.getParameter("email_info");
                String password = req.getParameter("password_info");
                String confirmPassword = req.getParameter("password_info1");
                if (action.equals("Add")) {
                    int idInfo = Integer.parseInt(req.getParameter("ID_info"));
                    if (adminServices.findAdminByID(idInfo) != null || adminServices.emailCheck(emailInfo) !=null) {
                        req.getRequestDispatcher("add_admin_form.html").include(req, resp);
                    } else {
                        try {
                            if(password.equals(confirmPassword)) {
                                adminServices.insertAdmin(new Admin(idInfo,fnameInfo,mnameInfo,lnameInfo,emailInfo,password));
                                resp.sendRedirect("AdminInfo");
                            }else{
                                req.getRequestDispatcher("Error_admin_form.html").include(req, resp);
                            }
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else{
                    String oldPassword = req.getParameter("password_info2");
                    int idInfo=(int) req.getSession().getAttribute("adminID");
                    if (adminServices.findAdminByID(idInfo) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            if(oldPassword.equals(adminServices.findAdminByID(idInfo).getAdminPassword()) && password.equals(confirmPassword) && (adminServices.emailCheck(emailInfo)==null || adminServices.emailCheck(emailInfo).getAdminID()==(int)req.getSession().getAttribute("adminID"))) {
                                adminServices.updateAdmin(new Admin((int)req.getSession().getAttribute("adminID"),fnameInfo,mnameInfo,lnameInfo,emailInfo,password));
                                resp.sendRedirect("Logout");
                            }else{
                                if(adminServices.emailCheck(emailInfo)!=null && password.equals(confirmPassword) && oldPassword.equals(adminServices.findAdminByID(idInfo).getAdminPassword())){
                                    req.getRequestDispatcher("update_admin_form.html").include(req,resp);
                                }else {
                                    req.getRequestDispatcher("Error_admin_form.html").include(req, resp);
                                }
                            }
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("AdminInfo");
        }
    }
}
