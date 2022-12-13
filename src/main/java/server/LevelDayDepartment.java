package server;

import entities.embedded.LevelDayDepartmentKey;
import services.DayServices;
import services.DepartmentServices;
import services.LevelDayDepartmentServices;
import services.LevelServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LevelInfo")
public class LevelDayDepartment extends HttpServlet {
    LevelDayDepartmentServices levelDayDepartmentServices=new LevelDayDepartmentServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int levelId=Integer.parseInt(req.getParameter("level"));
                int dayId=Integer.parseInt(req.getParameter("day"));
                int departmentId=Integer.parseInt(req.getParameter("department"));
                levelDayDepartmentServices.deleteLevelDayDepartmentByAllThreeID(levelId,dayId,departmentId);
                req.setAttribute("levelsDaysDepartments",levelDayDepartmentServices.findAllLevelDayDepartment());
                req.getRequestDispatcher("level_info.jsp").forward(req,resp);
            }else if(action.equals("Delete")){
                levelDayDepartmentServices.deleteAllLevelDayDepartment();
                req.setAttribute("levelsDaysDepartments",levelDayDepartmentServices.findAllLevelDayDepartment());
                req.getRequestDispatcher("level_info.jsp").forward(req,resp);
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("levelsDaysDepartments",levelDayDepartmentServices.searchLevelDayDepartment(key));
                req.getRequestDispatcher("level_info.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("levelsDaysDepartments",levelDayDepartmentServices.findAllLevelDayDepartment());
            req.getRequestDispatcher("level_info.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add")) {
                int levelId = Integer.parseInt(req.getParameter("levelName").substring(0,req.getParameter("levelName").lastIndexOf("-")));
                int departmentId = Integer.parseInt(req.getParameter("departmentName").substring(0,req.getParameter("departmentName").lastIndexOf("-")));
                int dayId = Integer.parseInt(req.getParameter("dayName").substring(0,req.getParameter("dayName").lastIndexOf("-")));
                    if (levelDayDepartmentServices.findLevelDayDepartmentByAllThreeID(levelId,dayId,departmentId) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            levelDayDepartmentServices.insertLevelDayDepartment(new entities.LevelDayDepartment(new LevelDayDepartmentKey(levelId,departmentId,dayId)));
                            resp.sendRedirect("LevelInfo");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
            }
        }catch (Exception e){
            resp.sendRedirect("LevelInfo");
        }
    }
}
