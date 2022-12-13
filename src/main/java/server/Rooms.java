package server;

import entities.Room;
import services.PlaceTypeServices;
import services.RoomServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Rooms")
public class Rooms extends HttpServlet {
    RoomServices roomServices=new RoomServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action=req.getParameter("action");
            if(action.equals("deleteOne")){
                int id=Integer.parseInt(req.getParameter("hidden"));
                roomServices.deleteRoomByID(id);
                req.setAttribute("placeTypes",new PlaceTypeServices().findAllPlaceTypes());
                req.setAttribute("rooms",roomServices.findAllRooms());
                req.getRequestDispatcher("rooms.jsp").forward(req,resp);
            }else if(action.equals("Delete")){
                roomServices.deleteAllRooms();
                req.setAttribute("placeTypes",new PlaceTypeServices().findAllPlaceTypes());
                req.setAttribute("rooms",roomServices.findAllRooms());
                req.getRequestDispatcher("rooms.jsp").forward(req,resp);
            }else if(action.equals("Search")){
                String key=req.getParameter("search");
                req.setAttribute("placeTypes",new PlaceTypeServices().findAllPlaceTypes());
                req.setAttribute("rooms",roomServices.searchRooms(key));
                req.getRequestDispatcher("rooms.jsp").forward(req,resp);
            }
        }catch (Exception e){
            req.setAttribute("placeTypes",new PlaceTypeServices().findAllPlaceTypes());
            req.setAttribute("rooms",roomServices.findAllRooms());
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
                String typeName = req.getParameter("type_name");
                String descriptionInfo = req.getParameter("description_info");
                if (action.equals("Add")) {
                    if (roomServices.findRoomByID(id) != null) {
                        req.getRequestDispatcher("add_form.html").include(req, resp);
                    } else {
                        try {
                            roomServices.insertRoom(new Room(id,name,descriptionInfo,new PlaceTypeServices().findPlaceTypeByID(Integer.parseInt(typeName.substring(0,typeName.lastIndexOf("-"))))));
                            resp.sendRedirect("Rooms");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }else {
                    if (roomServices.findRoomByID(id) == null) {
                        req.getRequestDispatcher("update_form.html").include(req, resp);
                    } else {
                        try {
                            roomServices.updateRoom(new Room(id,name,descriptionInfo,new PlaceTypeServices().findPlaceTypeByID(Integer.parseInt(typeName.substring(0,typeName.lastIndexOf("-"))))));
                            resp.sendRedirect("Rooms");
                        } catch (Exception e) {
                            req.getRequestDispatcher("Error_form.html").include(req, resp);
                        }
                    }
                }
            }
        }catch (Exception e){
            resp.sendRedirect("Rooms");
        }
    }
}
