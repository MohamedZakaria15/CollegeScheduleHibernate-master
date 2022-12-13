package server;

import entities.PlaceType;
import services.PlaceTypeServices;
import services.RoomServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PlaceTypes")
public class PlaceTypes extends HttpServlet {
    PlaceTypeServices placeTypeServices=new PlaceTypeServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id = Integer.parseInt(req.getParameter("hidden"));
                if(!placeTypeServices.constraintCheck(id)){
                    placeTypeServices.deletePlaceTypeByID(id);
                    resp.sendRedirect("PlaceTypes");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Delete")){
                boolean flag=false;
                for(PlaceType placeType: placeTypeServices.findAllPlaceTypes()){
                    if(placeTypeServices.constraintCheck(placeType.getTypeID())){
                        flag=true;
                        break;
                    }
                }
                if(flag==false) {
                    placeTypeServices.deleteAllPlaceTypes();
                    resp.sendRedirect("PlaceTypes");
                }else{
                    req.getRequestDispatcher("delete.html").include(req,resp);
                }
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("placeTypes",placeTypeServices.searchPlaceTypes(key));
                req.setAttribute("rooms",new RoomServices().findAllRooms());
                req.getRequestDispatcher("rooms.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("placeTypes",placeTypeServices.findAllPlaceTypes());
            req.setAttribute("rooms",new RoomServices().findAllRooms());
            req.getRequestDispatcher("rooms.jsp").forward(req,resp);
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
                    if (placeTypeServices.findPlaceTypeByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            placeTypeServices.insertPlaceType(new PlaceType(id,name));
                            resp.sendRedirect("PlaceTypes");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (placeTypeServices.findPlaceTypeByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            placeTypeServices.updatePlaceType(new PlaceType(id,name));
                            resp.sendRedirect("PlaceTypes");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("PlaceTypes");
        }
    }
}
