package server;

import entities.Time;
import services.TimeServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Time")
public class TimeServlet extends HttpServlet {
    TimeServices timeServices=new TimeServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("time",timeServices.findTime());
            req.getRequestDispatcher("time.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float start=Float.parseFloat(req.getParameter("start_time"));
        float end=Float.parseFloat(req.getParameter("end_time"));
        timeServices.updateTime(new Time(start,end));
        resp.sendRedirect("Time");
    }
}
