<%@ page import="java.util.List" %>
<%@ page import="management.DutiesObjects.LecturerScheduleInstance" %>
<%@ page import="services.LevelServices" %>
<%@ page import="services.DepartmentServices" %>
<%@ page import="management.DutiesObjects.AssistantScheduleInstance" %>
<%@ page import="services.LecturerServices" %>
<%@ page import="services.AssistantServices" %>
<%@ page import="entities.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- ===== CSS ===== -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href='css/all.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/style.css">

    <title>Show Scheduling</title>
</head>
<body>
<!-- Vertical navbar -->
<div class="vertical-nav" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-light">
        <div class="media d-flex align-items-center">
            <img loading="lazy" src="images/profile-user.png" alt="..." width="60" height="60"
                 class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <div class="media-body">
                <%String name = (String) request.getSession().getAttribute("adminName");%>
                <h5 class="m-0"><%=name%>
                </h5>
            </div>
        </div>
    </div>
    <ul class="nav flex-column mb-0 " id="sidebar-ul">
        <li class="nav-item unborderLeftColor">
            <a href="/CollegeSchedule_war/Login" class="nav-link color_text">
                <i class="fa fa-certificate mr-3 fa-fw"></i>
                Degrees
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Departments" class="nav-link color_text">
                <i class="fas fa-users mr-3 fa-fw"></i>
                Departments
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Courses" class="nav-link color_text">
                <i class="fa fa-book-open mr-3 fa-fw"></i>
                Courses
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Levels" class="nav-link color_text">
                <i class="fa fa-layer-group mr-3 fa-fw"></i>
                Levels
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Rooms" class="nav-link color_text">
                <i class="fa fa-location-arrow mr-3 fa-fw"></i>
                Place Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/CourseTypeDuration" class="nav-link color_text">
                <i class="fa fa-question-circle mr-3 fa-fw"></i>
                Course Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/LevelInfo" class="nav-link color_text">
                <i class="fa fa-question-circle mr-3 fa-fw"></i>
                Level Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Lecturers" class="nav-link color_text">
                <i class="fa fa-question-circle mr-3 fa-fw"></i>
                Lecturer Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Assistants" class="nav-link color_text">
                <i class="fa fa-question-circle mr-3 fa-fw"></i>
                Assistant Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/ShowScheduling" class="nav-link color_text active-click">
                <i class="fa fa-table mr-3 fa-fw"></i>
                Show Schedule
            </a>
        </li>
        <li class="nav-item">
            <a href="about.jsp" class="nav-link color_text">
                <i class="fa fa-info-circle mr-3 fa-fw"></i>
                User's Guide
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/Time" class="nav-link color_text">
                <i class="fa fa-clock mr-3 fa-fw"></i>
                time
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/AdminInfo" class="nav-link color_text">
                <i class="fa fa-user-plus mr-3 fa-fw"></i>
                admin Information
            </a>
        </li>
        <li class="nav-item mt-4">
            <a href="/CollegeSchedule_war/Logout" class="nav-link color_text">
                <i class="fa fa-sign-out-alt mr-3 fa-fw"></i>
                Log Out
            </a>
        </li>
    </ul>
</div>
<!-- End vertical navbar -->

<!-- ----------------------- Page content holder ----------------------- !-->
<div class="page-content" id="content">
    <!-- Toggle button -->
    <button id="sidebarCollapse" type="button"
            class="btn btn-light rounded-pill shadow-sm mb-4 sidebarCollapse_background sticky-top"><i
            class="fa fa-bars "></i></button>
    <!----------------------- Start Lectures Table Section ---------------------!-->
    <div>
        <a href="/CollegeSchedule_war/Regenerate" class="btn regenerate" type="submit"><i class="fas fa-sync"></i> Regenerate Tables</a>
        <div class="Lectures mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-12 col-xl-2">
                            <a href="#">Lectures</a>
                        </div>
                            <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-12 col-xl-10">
                                <form class="show-form" action="/CollegeSchedule_war/ShowScheduling" method="post">
                                <div class="form-group show-search col-12 col-sm-12 col-md-5 col-lg-2">
                                    <label>Department</label>
                                    <select name="department_name" id="" class="form-control">
                                        <option>None</option>
                                        <%
                                            List<Department> departments=new DepartmentServices().findAllDepartments();
                                            for(Department department:departments){
                                        %>
                                        <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group show-search col-md-5 col-lg-2">
                                    <label>Level</label>
                                    <select name="level_name" id="" class="form-control">
                                        <option>None</option>
                                        <%
                                            List<Level> levels=new LevelServices().findAllLevels();
                                            for(Level level:levels){
                                        %>
                                        <option><%=level.getLevelID()+"- "+level.getLevelName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                    <div class="form-group show-search col-md-5 col-lg-4">
                                        <label>Lecturer</label>
                                        <select name="lecturer_name" id="" class="form-control">
                                            <option>None</option>
                                            <%for(Lecturer lecturer:new LecturerServices().findAllLecturers()){%>
                                            <option><%=lecturer.getLecturerID()+"- "+lecturer.getLecturerFirstName()+" "+lecturer.getLecturerMiddleName()+" "+lecturer.getLecturerLastName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group show-search col-md-5 col-lg-2">
                                        <label>Group Number</label>
                                        <input type="number" name="group_number" class="form-control" value=0 min="0" step="1">
                                    </div>
                                    <input type="hidden" value="lecturers" name="action">
                                <button class="btn btn-success mb-2 ml-3 ml-md-3 ml-lg-0 ml-xl-0" type="submit">Search</button>
                                </form>
                            </div>
                    </div>
                </div>
                <div class="scroll scroll-two text-center">
                    <table id="example" class="table show-table table-hover diplay nowrap table-bordered"
                           cellspacing="0" width="100%">
                        <tr class="head-show-sticky">
                            <th class="range-cell th-main-show">Day</th>
                            <!-- <th class="range-cell">Group</th> -->
                            <th class="range-cell">Subject</th>
                            <th class="range-cell text-center" colspan="2">Time</th>
                            <th class="range-cell">Doctor Name</th>
                            <th class="range-cell">Place</th>
                        </tr>
                        <%
                            List<LecturersDistribution> lecturerScheduleInstanceList = (List<LecturersDistribution>) request.getAttribute("lecturersSchedule");
                            int i = 0;
                            int levelId;
                            int departmentId;
                            int groupNumber;
                            while (i < lecturerScheduleInstanceList.size()) {
                                levelId = lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getLevel_id();
                                departmentId = lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getDepartment_id();
                                groupNumber=lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getGroup_number();
                        %>
                        <tr class="subhead-show-after">
                            <th class="range-cell"
                                colspan="7"><%=lecturerScheduleInstanceList.get(i).getLevel_name() + "\t" + "( " + lecturerScheduleInstanceList.get(i).getDepartment_name() + " )"+" Group ( "+lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getGroup_number()+" )"%>
                            </th>
                        </tr>
                        <%while (i < lecturerScheduleInstanceList.size() && lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getLevel_id() == levelId && lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getDepartment_id() == departmentId && lecturerScheduleInstanceList.get(i).getLecturersDistributionKey().getGroup_number()==groupNumber) {%>
                        <tr>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getDay_name()%>
                            </td>
                            <td class="range-cell3"><%=lecturerScheduleInstanceList.get(i).getCourse_name()%>
                            </td>
                            <%if (lecturerScheduleInstanceList.get(i).getStart_time() > 12) {%>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getStart_time() - 12%>
                            </td>
                            <%} else {%>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getStart_time()%>
                            </td>
                            <%}%>
                            <%if (lecturerScheduleInstanceList.get(i).getEnd_time() > 12) {%>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getEnd_time() - 12%>
                            </td>
                            <%} else {%>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getEnd_time()%>
                            </td>
                            <%}%>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getLecturer_name()%>
                            </td>
                            <td class="range-cell"><%=lecturerScheduleInstanceList.get(i).getRoom_name()%>
                            </td>
                        </tr>
                        <%
                                i++;
                            }
                        %>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
        <!----------------------- End Lectures Table Section ----------------------->

        <!----------------------- Start Sections Table Section ----------------------->
        <div class="Sections mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-12 col-xl-2">
                            <a href="#">Sections</a>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-12 col-xl-10">
                            <form class="show-form" action="/CollegeSchedule_war/ShowScheduling" method="post">
                                <div class="form-group show-search col-12 col-sm-12 col-md-5 col-lg-2">
                                    <label>Department</label>
                                    <select name="department_name" id="" class="form-control">
                                        <option>None</option>
                                        <%
                                            for(Department department:departments){
                                        %>
                                        <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group show-search col-md-5 col-lg-2">
                                    <label>Level</label>
                                    <select name="level_name" id="" class="form-control">
                                        <option>None</option>
                                        <%
                                            for(Level level:levels){
                                        %>
                                        <option><%=level.getLevelID()+"- "+level.getLevelName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group show-search col-md-5 col-lg-4">
                                    <label>Assistant</label>
                                    <select name="assistant_name" id="" class="form-control">
                                        <option>None</option>
                                        <%for(Assistant assistant:new AssistantServices().findAllAssistants()){%>
                                        <option><%=assistant.getAssistantID()+"- "+assistant.getAssistantFirstName()+" "+assistant.getAssistantMiddleName()+" "+assistant.getAssistantLastName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-group show-search col-md-5 col-lg-2">
                                    <label>Section Number</label>
                                    <input type="number" name="section_number" class="form-control" value=0 min="0" step="1">
                                </div>
                                <input type="hidden" value="assistants" name="action">
                                <button class="btn btn-success mb-2 ml-3 ml-md-3 ml-lg-0 ml-xl-0" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="scroll scroll-two text-center">
                    <table id="example" class="table table-striped show-table table-hover diplay nowrap table-bordered"
                           cellspacing="0" width="100%">
                        <tr class="head-show-sticky">
                            <th class="range-cell th-main-show">Day</th>
                            <!-- <th class="range-cell">Group</th> -->
                            <th class="range-cell">Subject</th>
                            <th class="range-cell text-center" colspan="2">Time</th>
                            <th class="range-cell">Assistant Name</th>
                            <th class="range-cell">Place</th>
                        </tr>
                        <%
                            i=0;
                            int sectionNumber;
                            List<AssistantsDistribution> assistantScheduleInstanceList = (List<AssistantsDistribution>) request.getAttribute("assistantsSchedule");
                            while (i < assistantScheduleInstanceList.size()) {
                                levelId = assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getLevel_id();
                                departmentId = assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getDepartment_id();
                                sectionNumber=assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getSection_number();
                        %>
                        <tr class="subhead-show-after">
                            <th class="range-cell" colspan="7"><%=assistantScheduleInstanceList.get(i).getLevel_name() + "\t" + "( " + assistantScheduleInstanceList.get(i).getDepartment_name() + " )"+" Section ( "+assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getSection_number()+" )"%></th>
                        </tr>
                        <%while (i < assistantScheduleInstanceList.size() && assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getLevel_id() == levelId && assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getDepartment_id() == departmentId && assistantScheduleInstanceList.get(i).getAssistantsDistributionKey().getSection_number()==sectionNumber) {%>
                        <tr>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getDay_name()%>
                            </td>
                            <td class="range-cell3"><%=assistantScheduleInstanceList.get(i).getCourse_name()%>
                            </td>
                            <%if (assistantScheduleInstanceList.get(i).getStart_time() > 12) {%>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getStart_time() - 12%>
                            </td>
                            <%} else {%>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getStart_time()%>
                            </td>
                            <%}%>
                            <%if (assistantScheduleInstanceList.get(i).getEnd_time() > 12) {%>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getEnd_time() - 12%>
                            </td>
                            <%} else {%>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getEnd_time()%>
                            </td>
                            <%}%>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getAssistant_name()%>
                            </td>
                            <td class="range-cell"><%=assistantScheduleInstanceList.get(i).getRoom_name()%>
                            </td>
                        </tr>
                        <%
                                i++;
                            }
                        %>
                        <%}%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<input id="notLogin" type="hidden" value="<%=request.getSession().getAttribute("adminID")%>">
<!-- End demo content !-->

<!-- End Table ------------------------------------------------------------------------------- !-->


<!-- ===== JQUERY ===== -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/all.min.js"></script>

<!-- ===== MAIN JS ===== -->
<script src="js/main.js"></script>
<script src="js/notLogin.js"></script>
</body>
</html>