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
        
        <title>Lecturer Information</title>
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
                    <a href="/CollegeSchedule_war/Lecturers" class="nav-link color_text active-click">
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
            <!----------------------- Start Leceturer Information Table Section ---------------------!-->
                <div class="container">
                    <div class="LeceturerInfo mb-5">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                                        <a href="#">Lecturer Information</a>
                                    </div>
                                    <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7"> 
                                        <form class="d-flex" action="/CollegeSchedule_war/Lecturers">
                                            <input class="form-control me-2 search-border" type="text"  placeholder="Search" aria-label="Search" name="search">
                                            <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                        </form>   
                                        <div class="press-btn">
                                            <a href="#addLeceturerInfo" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                            <a href="#deleteLeceturerInfo" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
                                            <a href="#editLeceturerInfo" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>
                                        </div>                                            
                                    </div>
                                </div>
                            </div>
                            <div class="scroll scroll-two">
                                <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                    <thead id="headerTable">
                                        <tr>
                                            <th >ID</th>
                                            <th class="range-cell">Lecturer Name</th>
                                            <th class="range-cell2">Department Name</th>
                                            <th class="range-cell">Degree</th>
                                            <th class="range-cell-Action">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%List<Lecturer> lecturers=(List<Lecturer>) request.getAttribute("lecturers");
                                        for(Lecturer lecturer:lecturers){
                                    %>
                                        <tr>
                                            <td><%=lecturer.getLecturerID()%></td>
                                            <td class="range-cell"><%=lecturer.getLecturerFirstName()+" "+lecturer.getLecturerMiddleName()+" "+lecturer.getLecturerLastName()%></td>
                                            <td class="range-cell2"><%=lecturer.getDepartment().getDepartmentName()%></td>
                                            <td class="range-cell"><%=lecturer.getLecturerDegree().getDegreeName()%></td>
                                            <td class="range-cell-Action">  
                                                <form action="/CollegeSchedule_war/Lecturers" method="get">
                                                    <input type="hidden" name="hidden" value="<%=lecturer.getLecturerID()%>">
                                                    <!-- <a href="#editLeceturerInfo" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a> -->
                                                   <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                                </form>
                                            </td>
                                        </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                <!----------------------- End Lecturer Information Table Section ---------------------!-->
                            
                            <!----------------------- Start Add Lecturer Information Form ---------------------!-->
                            <div id="addLeceturerInfo" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/Lecturers" method="post">
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Add Lecturer Information</h4>
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
                                                        <%for(LecturerDegree lecturerDegree:new LecturerDegreeServices().findAllLecturerDegree()){%>
                                                        <option><%=lecturerDegree.getDegreeID()+"- "+lecturerDegree.getDegreeName()%></option>
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
                            <!----------------------- End Add Lecturer Information Form ---------------------!-->
                            <!----------------------- Start Edit Lecturer Information Form ---------------------!-->
                            <div id="editLeceturerInfo" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/Lecturers" method="post">
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Edit Lecturer Information</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">  
                                                <div class="form-group">
                                                    <label>ID</label>
                                                    <input type="number" id="EditID" name="ID_info"  class="form-control">
                                                </div>   
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input type="text" name="first_name" class="form-control  " required>
                                                </div>   
                                                <div class="form-group">
                                                    <label>Middle Name</label>
                                                    <input type="text" name="middle_name" class="form-control  " required>
                                                </div> 
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input type="text" name="last_name" class="form-control  " required>
                                                </div> 
                                                <div class="form-group">
                                                    <label>Department Name</label>
                                                    <select name="department_name" id="" class="form-control"  >
                                                        <%for(Department department:new DepartmentServices().findAllDepartments()){%>
                                                        <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Degree</label>
                                                    <select name="degree_name" id="" class="form-control"  >
                                                        <%for(LecturerDegree lecturerDegree:new LecturerDegreeServices().findAllLecturerDegree()){%>
                                                        <option><%=lecturerDegree.getDegreeID()+"- "+lecturerDegree.getDegreeName()%></option>
                                                        <%}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                                <input type="submit" class="btn btn-success"  value="Save" name="action">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        <!----------------------- End Edit Leceturer Information Form ---------------------!-->
                        <!----------------------- Start Delete Leceturer Information Form ---------------------!-->
                            <div id="deleteLeceturerInfo" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/Lecturers" method="get">
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Delete Lecturer Information</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">     
                                                <p>Are you sure you want to delete these Records?</p>
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
                        <!----------------------- End Delete Leceturer Information Form ---------------------!-->
                    </div>

                    <!----------------------- Start Leceturer Free Days Table ---------------------!-->

                    <div class="Leceturer_FreeDays mb-5">
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                                        <a href="#">Lecturer Free Days</a>
                                    </div>
                                    <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7"> 
                                        <form class="d-flex" action="/CollegeSchedule_war/LecturersDaysOff" method="get">
                                            <input class="form-control me-2 search-border" type="text"  placeholder="Search" aria-label="Search" name="search">
                                            <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                        </form>   
                                        <div class="press-btn">
                                            <a href="#addLeceturerFreeDays" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                            <a href="#deleteLeceturerFreeDays" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>   
<%--                                            <a href="#editLeceturerFreeDays" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>--%>
                                        </div>                                            
                                    </div>
                                </div>
                            </div>
                            <div class="scroll scroll-two">
                                <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                    <thead id="headerTable">
                                        <tr>
                                            <th class="range-cell" >Lecturer ID</th>
                                             <th class="range-cell">Lecture Name</th>
                                            <th class="range-cell">Day Name</th>
                                            <th class="range-cell-Action">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%List<LecturerDayOff> lecturersDaysOff=(List<LecturerDayOff>) request.getAttribute("lecturersDays");
                                        for(LecturerDayOff lecturerDayOff:lecturersDaysOff){
                                    %>
                                        <tr>
                                            <td class="range-cell"><%=lecturerDayOff.getLecturer().getLecturerID()%></td>
                                             <td class="range-cell"><%=lecturerDayOff.getLecturer().getLecturerFirstName()+" "+lecturerDayOff.getLecturer().getLecturerMiddleName()+" "+lecturerDayOff.getLecturer().getLecturerLastName()%></td>
                                            <td class="range-cell"><%=lecturerDayOff.getDay().getDayName()%></td>
                                            <td class="range-cell-Action">  
                                                <form action="/CollegeSchedule_war/LecturersDaysOff" method="get">
                                                    <input type="hidden" name="hidden" value="<%=lecturerDayOff.getLecturer().getLecturerID()%>">
                                                    <input type="hidden" name="hidden1" value="<%=lecturerDayOff.getDay().getDayID()%>">
                                                    <!-- <a href="#editLeceturerFreeDays" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a> -->
                                                    <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                                </form>
                                            </td>
                                        </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                <!----------------------- End Lecturer Free Days Table Section ---------------------!-->
                            
                            <!----------------------- Start Add Lecturer Free Days Form ---------------------!-->
                            <div id="addLeceturerFreeDays" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/LecturersDaysOff" method="post">
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Add Lecturer Free Day</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                 <div class="form-group">
                                                    <label>Lecturer Name</label>
                                                    <select name="lecturer_name" id="" class="form-control">
                                                        <%for(Lecturer lecturer:new LecturerServices().findAllLecturers()){%>
                                                        <% if(new LecturerDaysOffServices().daysOffForLecturer(lecturer.getLecturerID())<2){%>
                                                        <option><%=lecturer.getLecturerID()+"- "+lecturer.getLecturerFirstName()+" "+lecturer.getLecturerMiddleName()+" "+lecturer.getLecturerLastName()%></option>
                                                        <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Day Off</label>
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
                            <!----------------------- End Add Lecturer Free Days Form ---------------------!-->
                            <!----------------------- Start Edit Lecturer Free Days Form ---------------------!-->
                            <div id="editLeceturerFreeDays" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form>
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Edit Lecturer Free Day</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">  
                                                <div class="form-group">
                                                    <label>ID</label>
                                                    <input type="number" id="EditID" name="ID_lecday" class="form-control">
                                                </div>   
                                                <div class="form-group">
                                                    <label>Lecturer Name</label>
                                                    <select name="name" id="" class="form-control  "  >
                                                        <option value="volvo">Ahmed khaled</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Day Off</label>
                                                    <select name="day_name" id="" class="form-control  "  >
                                                        <option value="volvo">Monday</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                                <input type="submit" class="btn btn-success  "   value="Add" name="add">
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        <!----------------------- End Edit Leceturer Free Days Form ---------------------!-->
                        <!----------------------- Start Delete Lecturer Free Days Form ---------------------!-->
                            <div id="deleteLeceturerFreeDays" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/LecturersDaysOff" method="get">
                                            <div class="modal-header">      
                                                <h4 class="modal-title">Delete Lecturer Free Day</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">     
                                                <p>Are you sure you want to delete Record?</p>
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
                        <!----------------------- End Delete Lecturer Free Days Form ---------------------!-->
                    </div>


                    <!----------------------- Start Lecturer Courses Table ---------------------!-->
                    <div class="Leceturer_Course mb-5">
                            <div id="deleteLeceturerCourse" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/LecturerCourses" method="get">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Delete Lecturer Course</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Are you sure you want to delete Records</p>
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
                        <!----------------------- End Edit Leceturer Courses Form ---------------------!-->
                        <!----------------------- Start Delete Lecturer Courses Form ---------------------!-->
                        <div class="table-wrapper">
                            <div class="table-title">
                                <div class="row">
                                    <div class="top-title col-12 col-sm-12 col-md-12 col-lg-6">
                                        <a href="#">Lecturer Courses</a>
                                    </div>
                                    <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-6">
                                        <a href="#addLeceturerCourse" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                        <a href="#deleteLeceturerCourse" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
                                        <%--                                        <a href="#editLeceturerCourse" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>--%>
                                        <form class="d-flex" action="/CollegeSchedule_war/LecturerCourses" method="get">
                                            <input class="form-control me-2 search-border" type="search" placeholder="Search" aria-label="Search" name="search">
                                            <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="scroll scroll-two">
                                <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                    <thead id="headerTable">
                                    <tr>
                                        <th class="range-cell">Lecturer ID</th>
                                        <th class="range-cell">Lecture Name</th>
                                        <th class="range-cell">Course ID</th>
                                        <th class="range-cell">Course Name</th>
                                        <th class="range-cell-Action">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<LecturerCourse> lecturerCourses=(List<LecturerCourse>) request.getAttribute("lecturersCourses");
                                        for(LecturerCourse lecturerCourse:lecturerCourses){

                                    %>
                                    <tr>
                                        <td class="range-cell"><%=lecturerCourse.getLecturer().getLecturerID()%></td>
                                        <td class="range-cell"><%=lecturerCourse.getLecturer().getLecturerFirstName()+" "+lecturerCourse.getLecturer().getLecturerMiddleName()+" "+lecturerCourse.getLecturer().getLecturerLastName()%></td>
                                        <td class="range-cell"><%=lecturerCourse.getCourse().getCourseID()%></td>
                                        <td class="range-cell"><%=lecturerCourse.getCourse().getCourseName()%></td>
                                        <td class="range-cell-Action">
                                            <form action="/CollegeSchedule_war/LecturerCourses" method="get">
                                                <input type="hidden" name="hidden" value="<%=lecturerCourse.getLecturer().getLecturerID()%>">
                                                <input type="hidden" name="hidden1" value="<%=lecturerCourse.getCourse().getCourseID()%>">
                                                <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                            <!----------------------- End Lecturer Courses Table Section ---------------------!-->
                            <!----------------------- Start Add Lecturer Courses Form ---------------------!-->
                            <div id="addLeceturerCourse" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form action="/CollegeSchedule_war/LecturerCourses" method="post">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Add Lecturer Course</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>Lecturer Name</label>
                                                    <select name="lecturer_name" id="" class="form-control">
                                                        <%for(Lecturer lecturer:new LecturerServices().findAllLecturers()){%>
                                                        <% if(new LecturerCourseServices().coursesForLecturer(lecturer.getLecturerID())<2){%>
                                                        <option><%=lecturer.getLecturerID()+"- "+lecturer.getLecturerFirstName()+" "+lecturer.getLecturerMiddleName()+" "+lecturer.getLecturerLastName()%></option>
                                                        <%}%>
                                                        <%}%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Course Name</label>
                                                    <select name="course_name" id="" class="form-control">
                                                        <%for(CourseTypeDuration courseTypeDuration:new CourseTypeDurationServices().findAllCourseTypeDuration()){%>
                                                        <%if(courseTypeDuration.getPlaceType().getTypeName().equals("Standing")){%>
                                                        <option><%=courseTypeDuration.getCourse().getCourseID()+"- "+courseTypeDuration.getCourse().getCourseName()%></option>
                                                        <%}%>
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
                            <!----------------------- End Add Lecturer Courses Form ---------------------!-->
                            <!----------------------- Start Edit Lecturer Courses Form ---------------------!-->
                            <div id="editLeceturerCourse" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <form>
                                            <div class="modal-header">
                                                <h4 class="modal-title">Edit Lecturer Course</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>ID</label>
                                                    <input type="number" id="EditID" name="ID_lecCourse" class="form-control"">
                                                </div>
                                                <div class="form-group">
                                                    <label>Lecturer Name</label>
                                                    <select name="name" id="" class="form-control">
                                                        <option value="volvo">Ahmed khaled</option>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <label>Course Name</label>
                                                    <select name="course_name" id="" class="form-control"  >
                                                        <option value="volvo">Information System</option>
                                                    </select>
                                                </div>
                                            </div>
                                    </div>
                                    <div class="modal-footer">
                                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                        <input type="submit" class="btn btn-success  "   value="Add" name="add">
                                    </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                        <!----------------------- End Delete Leceturer Courses Form ---------------------!-->
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