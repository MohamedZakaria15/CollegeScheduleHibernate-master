package server;

import entities.Level;
import services.LevelServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Levels")
public class Levels extends HttpServlet {
    LevelServices levelServices=new LevelServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!levelServices.constraintCheck(id)){
                    levelServices.deleteLevelByID(id);
                    resp.sendRedirect("Levels");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Delete")){
                boolean flag=false;
                for(Level level: levelServices.findAllLevels()){
                    if(levelServices.constraintCheck(level.getLevelID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    levelServices.deleteAllLevels();
                    resp.sendRedirect("Levels");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("levels",levelServices.searchLevels(key));
                req.getRequestDispatcher("levels.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("levels",levelServices.findAllLevels());
            req.getRequestDispatcher("levels.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if (action.equals("Add") || action.equals("Save")) {
                int id = Integer.parseInt(req.getParameter("ID_info"));
                String name = req.getParameter("name_info");
                if (action.equals("Add")) {
                    if (levelServices.findLevelByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            levelServices.insertLevel(new Level(id,name));
                            resp.sendRedirect("Levels");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (levelServices.findLevelByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            levelServices.updateLevel(new Level(id,name));
                            resp.sendRedirect("Levels");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Levels");
        }
    }
}
