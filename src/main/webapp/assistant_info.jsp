<%@ page import="java.util.List" %>
<%@ page import="services.*" %>
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
    <title>Assistants Information</title>
</head>
<body>
<!-- Vertical navbar -->
<div class="vertical-nav" id="sidebar">
    <div class="py-4 px-3 mb-4 bg-light">
        <div class="media d-flex align-items-center">
            <img loading="lazy" src="images/profile-user.png" alt="..." width="60" height="60" class="mr-3 rounded-circle img-thumbnail shadow-sm">
            <div class="media-body">
                <%String name=(String) request.getSession().getAttribute("adminName");%>
                <h5 class="m-0"><%=name%></h5>
            </div>
        </div>
    </div>
    <ul class="nav flex-column mb-0 " id="sidebar-ul">
        <li class="nav-item unborderLeftColor" >
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
            <a href="/CollegeSchedule_war/Assistants" class="nav-link color_text active-click">
                <i class="fa fa-question-circle mr-3 fa-fw"></i>
                Assistant Information
            </a>
        </li>
        <li class="nav-item">
            <a href="/CollegeSchedule_war/ShowScheduling" class="nav-link color_text">
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
    <button id="sidebarCollapse" type="button" class="btn btn-light rounded-pill shadow-sm mb-4 sidebarCollapse_background sticky-top"><i class="fa fa-bars "></i></button>
    <!----------------------- Start Assistant Information Table Section ---------------------!-->
    <div class="container">
        <div class="AssistantInfo mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                            <a href="#">Assistant Information</a>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7">
                            <form class="d-flex" action="/CollegeSchedule_war/Assistants" method="get">
                                <input class="form-control me-2 search-border" type="search" placeholder="Search" aria-label="Search" name="search">
                                <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                            </form>
                            <div class="press-btn">
                                <a href="#addAssistantInfo" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                <a href="#deleteAssistantInfo" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
                                <a href="#editAssistantInfo" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="scroll scroll-two">
                    <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                        <thead id="headerTable">
                        <tr>
                            <th >ID</th>
                            <th class="range-cell">Assistant Name</th>
                            <th class="range-cell2">Department Name</th>
                            <th class="range-cell">Degree</th>
                            <th class="range-cell-Action">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%List<Assistant> assistants=(List<Assistant>) request.getAttribute("assistants");
                            for(Assistant assistant:assistants){
                        %>
                        <tr>
                            <td><%=assistant.getAssistantID()%></td>
                            <td class="range-cell"><%=assistant.getAssistantFirstName()+" "+assistant.getAssistantMiddleName()+" "+assistant.getAssistantLastName()%></td>
                            <td class="range-cell2"><%=assistant.getDepartment().getDepartmentName()%></td>
                            <td class="range-cell"><%=assistant.getAssistantDegree().getDegreeName()%></td>
                            <td class="range-cell-Action">
                                <form action="/CollegeSchedule_war/Assistants" method="get">
                                    <input type="hidden" name="hidden" value="<%=assistant.getAssistantID()%>">
                                    <!-- <a href="#editAssistantInfo" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a> -->
                                    <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                </form>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
                <!----------------------- End Assistant Information Table Section ---------------------!-->

                <!----------------------- Start Add Assistant Information Form ---------------------!-->
                <div id="addAssistantInfo" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/Assistants" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Add Assistant Information</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input type="number" name="ID_info" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" name="first_name" class="form-control"required>
                                    </div>
                                    <div class="form-group">
                                        <label>Middle Name</label>
                                        <input type="text" name="middle_name" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" name="last_name" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Department Name</label>
                                        <select name="department_name" id="" class="form-control">
                                            <%for(Department department:new DepartmentServices().findAllDepartments()){%>
                                            <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Degree</label>
                                        <select name="degree_name" id="" class="form-control">
                                            <%for(AssistantDegree assistantDegree:new AssistantDegreeServices().findAllAssistantsDegrees()){%>
                                            <option><%=assistantDegree.getDegreeID()+"- "+assistantDegree.getDegreeName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-success" value="Add" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!----------------------- End Add Assistant Information Form ---------------------!-->
                <!----------------------- Start Edit Assistant Information Form ---------------------!-->
                <div id="editAssistantInfo" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/Assistants" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Edit Assistant Information</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input type="number" name="ID_info" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>First Name</label>
                                        <input type="text" name="first_name" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Middle Name</label>
                                        <input type="text" name="middle_name" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Last Name</label>
                                        <input type="text" name="last_name" class="form-control" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Department Name</label>
                                        <select name="department_name" id="" class="form-control">
                                            <%for(Department department:new DepartmentServices().findAllDepartments()){%>
                                            <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Degree</label>
                                        <select name="degree_name" id="" class="form-control">
                                            <%for(AssistantDegree assistantDegree:new AssistantDegreeServices().findAllAssistantsDegrees()){%>
                                            <option><%=assistantDegree.getDegreeID()+"- "+assistantDegree.getDegreeName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-success "value="Save" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!----------------------- End Edit Assistant Information Form ---------------------!-->
                <!----------------------- Start Delete Assistant Information Form ---------------------!-->
                <div id="deleteAssistantInfo" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/Assistants" method="get">
                                <div class="modal-header">
                                    <h4 class="modal-title">Delete Assistant Information</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Are You Sure You Want To Delete Record ?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-danger" value="Delete" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!----------------------- End Delete Assistant Information Form ---------------------!-->
        </div>

        <!----------------------- Start Assistant attendance  Days Table ---------------------!-->

        <div class="Assistant_AttendanceDays mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                            <a href="#">Assistant Attendance Days</a>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7">
                            <form class="d-flex" action="/CollegeSchedule_war/AssistantDays" method="get">
                                <input class="form-control me-2 search-border" type="search" placeholder="Search" aria-label="Search" name="search">
                                <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                            </form>
                            <div class="press-btn">
                                <a href="#addAssistantAttendanceDays" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                <a href="#deleteAssistantAttendanceDays" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
<%--                                <a href="#editAssistantAttendanceDays" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>--%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="scroll scroll-two">
                    <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                        <thead id="headerTable">
                        <tr>
                            <th class="range-cell">Assistant ID</th>
                            <th class="range-cell">Assistant Name</th>
                            <th class="range-cell">Attendance Day</th>
                            <th class="range-cell-Action">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%List<AssistantDay> assistantDays=(List<AssistantDay>) request.getAttribute("assistantsDays");
                            for(AssistantDay assistantDay:assistantDays){
                        %>
                        <tr>
                            <td class="range-cell"><%=assistantDay.getAssistant().getAssistantID()%></td>
                            <td class="range-cell"><%=assistantDay.getAssistant().getAssistantFirstName()+" "+assistantDay.getAssistant().getAssistantMiddleName()+" "+assistantDay.getAssistant().getAssistantLastName()%></td>
                            <td class="range-cell"><%=assistantDay.getDay().getDayName()%></td>
                            <td class="range-cell-Action">
                                <form action="/CollegeSchedule_war/AssistantDays" method="get">
                                    <input type="hidden" name="hidden" value="<%=assistantDay.getAssistant().getAssistantID()%>">
                                    <input type="hidden" name="hidden1" value="<%=assistantDay.getDay().getDayID()%>">
                                    <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                </form>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
                <!----------------------- End Assistant Attendance Days Table Section ---------------------!-->

                <!----------------------- Start Add Assistant Attendance Days Form ---------------------!-->
                <div id="addAssistantAttendanceDays" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/AssistantDays" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Add Assistant Attendance Day</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Assistant Name</label>
                                        <select name="assistant_name" id="" class="form-control">
                                            <%for(Assistant assistant:new AssistantServices().findAllAssistants()){%>
                                            <% if(new AssistantDayServices().daysForAssistant(assistant.getAssistantID())<3){%>
                                            <option><%=assistant.getAssistantID()+"- "+assistant.getAssistantFirstName()+" "+assistant.getAssistantMiddleName()+" "+assistant.getAssistantLastName()%></option>
                                            <%}%>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Attendance Day</label>
                                        <select name="day_name" id="" class="form-control">
                                            <%for(Day day:new DayServices().findAllDays()){%>
                                            <option><%=day.getDayID()+"- "+day.getDayName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-success" value="Add" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!----------------------- End Add Assistant Attendance Days Form ---------------------!-->
                <!----------------------- Start Edit Assistant Attendance Days Form ---------------------!-->
                <div id="editAssistantAttendanceDays" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Edit Assistant Attendance Day</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input type="number" name="ID_assistday" class="form-control">
                                        <span id="Edittext"></span>
                                    </div>
                                    <div class="form-group">
                                        <label>Assistant Name</label>
                                        <select name="name" id="" class="form-control">
                                            <option value="volvo">Ahmed khaled</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Attendance Day</label>
                                        <select name="day_name" id="" class="form-control">
                                            <option value="volvo">Monday</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-success" value="Save" name="Save">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!----------------------- End Edit Assistant Attendance Days Form ---------------------!-->
                <!----------------------- Start Delete Assistant Attendance Days Form ---------------------!-->
                <div id="deleteAssistantAttendanceDays" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/AssistantDays" method="get">
                                <div class="modal-header">
                                    <h4 class="modal-title">Delete Assistant Attendance Day</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <p>Are You Sure You Want To Delete Record ?</p>
                                    <p class="text-warning"><small>This action cannot be undone.</small></p>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-danger" value="Delete" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!----------------------- End Delete Assistant Attendance Days Form ---------------------!-->
        </div>


        <!----------------------- Start Assistant Courses Table ---------------------!-->
        <div class="Assistant_Course mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                            <a href="#">Assistant Courses</a>
                        </div>
                        <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7">
                            <form class="d-flex" action="/CollegeSchedule_war/AssistantCourses" method="get">
                                <input class="form-control me-2 search-border" type="search" placeholder="Search" aria-label="Search" name="search">
                                <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                            </form>
                            <div class="press-btn">
                                <a href="#addAssistantCourse" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                <a href="#deleteAssistantCourse" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
<%--                                <a href="#editAssistantCourse" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>--%>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="scroll scroll-two">
                    <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                        <thead id="headerTable">
                        <tr>
                            <th class="range-cell">Assistant ID</th>
                            <th class="range-cell">Assistant Name</th>
                            <th class="range-cell">Course ID</th>
                            <th class="range-cell">Course Name</th>
                            <th class="range-cell-Action">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%List<AssistantCourse> assistantCourses=(List<AssistantCourse>) request.getAttribute("assistantsCourses");
                            for(AssistantCourse assistantCourse:assistantCourses){
                        %>
                        <tr>
                            <td class="range-cell"><%=assistantCourse.getAssistant().getAssistantID()%></td>
                            <td class="range-cell"><%=assistantCourse.getAssistant().getAssistantFirstName()+" "+assistantCourse.getAssistant().getAssistantMiddleName()+" "+assistantCourse.getAssistant().getAssistantLastName()%></td>
                            <td class="range-cell"><%=assistantCourse.getCourse().getCourseID()%></td>
                            <td class="range-cell"><%=assistantCourse.getCourse().getCourseName()%></td>
                            <td class="range-cell-Action">
                                <form action="/CollegeSchedule_war/AssistantCourses" method="get">
                                    <input type="hidden" name="hidden" value="<%=assistantCourse.getAssistant().getAssistantID()%>">
                                    <input type="hidden" name="hidden1" value="<%=assistantCourse.getCourse().getCourseID()%>">
                                    <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                </form>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
                <!----------------------- End Assistant Courses Table Section ---------------------!-->
                <!----------------------- Start Add Assistant Courses Form ---------------------!-->
                <div id="addAssistantCourse" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form action="/CollegeSchedule_war/AssistantCourses" method="post">
                                <div class="modal-header">
                                    <h4 class="modal-title">Add Assistant Course</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>Assistant Name</label>
                                        <select name="assistant_name" id="" class="form-control">
                                            <%for(Assistant assistant:new AssistantServices().findAllAssistants()){%>
                                            <% if(new AssistantCourseServices().coursesForAssistant(assistant.getAssistantID())<2){%>
                                            <option><%=assistant.getAssistantID()+"- "+assistant.getAssistantFirstName()+" "+assistant.getAssistantMiddleName()+" "+assistant.getAssistantLastName()%></option>
                                            <%}%>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Course Name</label>
                                        <select name="course_name" id="" class="form-control">
                                            <%for(Course course:new CourseServices().findAllCourses()){%>
                                            <option><%=course.getCourseID()+"- "+course.getCourseName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                    <input type="submit" class="btn btn-success" value="Add" name="action">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!----------------------- End Add Assistant Courses Form ---------------------!-->
                <!----------------------- Start Edit Assistant Courses Form ---------------------!-->
                <div id="editAssistantCourse" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form>
                                <div class="modal-header">
                                    <h4 class="modal-title">Edit Assistant Course</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input type="number" name="ID_asscourse" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label>Assistant Name</label>
                                        <select name="name" id="" class="form-control">
                                            <option value="volvo">Ahmed khaled</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Course Name</label>
                                        <select name="course_name" id="" class="form-control">
                                            <option value="volvo">Information System</option>
                                        </select>
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                            <input type="submit" class="btn btn-success" value="Save" name="save">
                        </div>
                        </form>
                    </div>
                </div>
            </div>
            <!----------------------- End Edit Assistant Courses Form ---------------------!-->
            <!----------------------- Start Delete Assistant Courses Form ---------------------!-->
            <div id="deleteAssistantCourse" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="/CollegeSchedule_war/AssistantCourses" method="get">
                            <div class="modal-header">
                                <h4 class="modal-title">Delete Assistant Course</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <p>Are You Sure You Want To Delete Record ?</p>
                                <p class="text-warning"><small>This action cannot be undone.</small></p>
                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                <input type="submit" class="btn btn-danger" value="Delete" name="action">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <!----------------------- End Delete Assistant Courses Form ---------------------!-->
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