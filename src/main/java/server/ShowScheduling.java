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
import java.util.stream.Collectors;

@WebServlet("/ShowScheduling")
public class ShowScheduling extends HttpServlet {
    private LecturersDistributionService lecturersDistributionService=new LecturersDistributionService();
    private AssistantsDistributionService assistantsDistributionService=new AssistantsDistributionService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LecturersDistribution> lecturersDistributions= lecturersDistributionService.findAllLecturersDistribution();
        List<AssistantsDistribution> assistantsDistributions= assistantsDistributionService.findAllAssistantsDistribution();
        req.setAttribute("lecturersSchedule",lecturersDistributions);
        req.setAttribute("assistantsSchedule",assistantsDistributions);
        req.getRequestDispatcher("show_scheduling.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int department_id=-1,level_id=-1,lecturer_id=-1,assistant_id=-1;
        if(!req.getParameter("department_name").equals("None")) {
            department_id = Integer.parseInt(req.getParameter("department_name").substring(0, req.getParameter("department_name").lastIndexOf("-")));
        }
        if(!req.getParameter("level_name").equals("None")) {
            level_id = Integer.parseInt(req.getParameter("level_name").substring(0, req.getParameter("level_name").lastIndexOf("-")));
        }
        String action=req.getParameter("action");
        List<LecturersDistribution> lecturersDistributions=null;
        List<AssistantsDistribution> assistantsDistributions=null;
        if(action.equals("assistants")){
            if(!req.getParameter("assistant_name").equals("None")) {
                assistant_id = Integer.parseInt(req.getParameter("assistant_name").substring(0, req.getParameter("assistant_name").lastIndexOf("-")));
            }
            int section_number=Integer.parseInt(req.getParameter("section_number"));
            lecturersDistributions =lecturersDistributionService.findAllLecturersDistribution();
            assistantsDistributions=assistantsDistributionService.searchAssistantsDistribution(department_id,level_id,assistant_id,section_number);
        }else{
            if(!req.getParameter("lecturer_name").equals("None")) {
                lecturer_id = Integer.parseInt(req.getParameter("lecturer_name").substring(0, req.getParameter("lecturer_name").lastIndexOf("-")));
            }
            int group_number=Integer.parseInt(req.getParameter("group_number"));
            lecturersDistributions=lecturersDistributionService.searchLecturersDistribution(department_id,level_id,lecturer_id,group_number);
            assistantsDistributions= assistantsDistributionService.findAllAssistantsDistribution();
        }
        req.setAttribute("lecturersSchedule",lecturersDistributions);
        req.setAttribute("assistantsSchedule",assistantsDistributions);
        req.getRequestDispatcher("show_scheduling.jsp").forward(req,resp);
    }
}
