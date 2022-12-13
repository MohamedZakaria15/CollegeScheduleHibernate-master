package server;

import entities.AssistantsDistribution;
import entities.LecturersDistribution;
import management.DutiesDistribution;
import management.DutiesObjects.AssistantScheduleInstance;
import management.DutiesObjects.LecturerScheduleInstance;
import services.AssistantsDistributionService;
import services.LecturersDistributionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Regenerate")
public class Regenerate extends HttpServlet {
    private DutiesDistribution dutiesDistribution=new DutiesDistribution();
    private LecturersDistributionService lecturersDistributionService=new LecturersDistributionService();
    private AssistantsDistributionService assistantsDistributionService=new AssistantsDistributionService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dutiesDistribution.lecturersDistribution();
        dutiesDistribution.assistantsDistribution();
        List<LecturersDistribution> lecturersDistributions= lecturersDistributionService.findAllLecturersDistribution();
        List<AssistantsDistribution> assistantsDistributions= assistantsDistributionService.findAllAssistantsDistribution();
        req.setAttribute("lecturersSchedule",lecturersDistributions);
        req.setAttribute("assistantsSchedule",assistantsDistributions);
        req.getRequestDispatcher("show_scheduling.jsp").forward(req,resp);
    }
}
