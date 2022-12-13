package server;

import entities.Department;
import services.DepartmentServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Departments")
public class Departments extends HttpServlet {
    DepartmentServices departmentServices=new DepartmentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("deleteOne")) {
                 int id = Integer.parseInt(req.getParameter("hidden"));
                if(!departmentServices.constraintCheck(id)){
                    departmentServices.deleteDepartmentByID(id);
                    resp.sendRedirect("Departments");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            } else if (action.equals("Delete")) {
                boolean flag=false;
                for(Department department: departmentServices.findAllDepartments()){
                    if(departmentServices.constraintCheck(department.getDepartmentID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    departmentServices.deleteAllDepartments();
                    resp.sendRedirect("Departments");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("departments",departmentServices.searchDepartments(key));
                req.getRequestDispatcher("departments.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("departments", departmentServices.findAllDepartments());
            req.getRequestDispatcher("departments.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int id = Integer.parseInt(req.getParameter("ID_info"));
                String name = req.getParameter("name_info");
                if (action.equals("Add")) {
                    if (departmentServices.findDepartmentByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            departmentServices.insertDepartment(new Department(id, name));
                            resp.sendRedirect("Departments");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (departmentServices.findDepartmentByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            departmentServices.updateDepartment(new Department(id, name));
                            resp.sendRedirect("Departments");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Departments");
        }
    }
}
