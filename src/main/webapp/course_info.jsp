<%@ page import="java.util.List" %>
<%@ page import="services.CourseServices" %>
<%@ page import="services.DepartmentServices" %>
<%@ page import="entities.*" %>
<%@ page import="services.LevelServices" %>
<%@ page import="services.PlaceTypeServices" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- ===== CSS ===== -->    
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link href='css/all.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/style.css">
        
        <title>Course Information</title>
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
                    <a href="/CollegeSchedule_war/CourseTypeDuration" class="nav-link color_text active-click">
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

        <!-- ----------------------- Page content holder ----------------------- -->
        <div class="page-content" id="content">
            <!-- Toggle button -->
            <button id="sidebarCollapse" type="button" class="btn btn-light rounded-pill shadow-sm mb-4 sidebarCollapse_background sticky-top"><i class="fa fa-bars "></i></button>
            <!----------------------- Start Course Information Table Section ----------------------->
            <div class="container">
                <div class="course_info1 mb-5">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                                    <a href="#">Course <b>Places</b></a>
                                </div>
                                <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7"> 
                                    <form class="d-flex" action="/CollegeSchedule_war/CourseTypeDuration" method="get">
                                        <input class="form-control me-2 search-border" type="text"  placeholder="Search" aria-label="Search" name="search">
                                        <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                    </form>   
                                    <div class="press-btn">
                                        <a href="#addCourse1" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                        <a href="#deleteCourse1" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>   
                                        <a href="#editCourse1" class="edit"  data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>  
                                    </div>                                            
                                </div>
                            </div>
                        </div>
                        <div class="scroll scroll-two">
                            <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                <thead id="headerTable">
                                    <tr>
                                        <th></th>
                                        <th class="range-cell">Course Name</th>
                                        <th class="range-cell">Place Type Name</th>
                                        <th class="range-cell">Duration</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%List<CourseTypeDuration> courseTypeDurations=(List<CourseTypeDuration>) request.getAttribute("coursesTypesDurations");
                                for(CourseTypeDuration courseTypeDuration:courseTypeDurations){
                                %>
                                    <tr>
                                        <td></td>
                                        <td class="range-cell"><%=courseTypeDuration.getCourse().getCourseName()%></td>
                                        <td class="range-cell"><%=courseTypeDuration.getPlaceType().getTypeName()%></td>
                                        <td class="range-cell"><%=courseTypeDuration.getDuration()%></td>
                                        <td>  
                                            <form action="/CollegeSchedule_war/CourseTypeDuration" method="get">
                                                <input type="hidden" name="hidden" value="<%=courseTypeDuration.getCourse().getCourseID()%>">
                                                <input type="hidden" name="hidden1" value="<%=courseTypeDuration.getPlaceType().getTypeID()%>">
                                                <!-- <a href="#editCourse1" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a> -->
                                                <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                        <!----------------------- End Course Information Table Section ----------------------->
                        
                        <!----------------------- Start Add Course Form ----------------------->
                        <div id="addCourse1" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseTypeDuration" method="post">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Add Course Place</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                    <label for=" ">Course Name</label><br>
                                                    <select name="courseName" class="form-control">
                                                        <%for(Course course:new CourseServices().findAllCourses()){%>
                                                      <option><%=course.getCourseID()+"- "+course.getCourseName()%></option>
                                                        <%}%>
                                                    </select>
                                            </div>
                                            <div class="form-group">
                                                    <label for=" ">Place Type Name</label><br>
                                                    <select name="typeName" class="form-control">
                                                        <%for(PlaceType placeType:new PlaceTypeServices().findAllPlaceTypes()){%>
                                                        <option><%=placeType.getTypeID()+"- "+placeType.getTypeName()%></option>
                                                        <%}%>
                                                    </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Duration</label>
                                                <input type="number" step="0.25" name="duration_info" class="form-control" min="0.75" required>
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
                        <!----------------------- End Add Course Form ----------------------->
                        <!----------------------- Start Edit Course Form ----------------------->
                        <div id="editCourse1" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseTypeDuration" method="post">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Edit Course Place</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for=" ">Course Name</label><br>
                                                <select name="courseName" class="form-control">
                                                    <%for(Course course:new CourseServices().findAllCourses()){%>
                                                    <option><%=course.getCourseID()+"- "+course.getCourseName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for=" ">Place Type Name</label><br>
                                                <select name="typeName" class="form-control">
                                                    <%for(PlaceType placeType:new PlaceTypeServices().findAllPlaceTypes()){%>
                                                    <option><%=placeType.getTypeID()+"- "+placeType.getTypeName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>Duration</label>
                                                <input type="number" step="0.25" name="duration_info" class="form-control" min="0.75" required>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="Cancel">
                                            <input type="submit" class="btn btn-info " value="Save" name="action">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    <!----------------------- End Edit Course Form ----------------------->
                    <!----------------------- Start Delete Course Form ----------------------->
                        <div id="deleteCourse1" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseTypeDuration" method="get">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Delete Course Place</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">     
                                            <p>Are You Sure You Want To Delete Record ?</p>
                                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                            <input type="submit" class="btn btn-danger" name="action" value="Delete">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!----------------------- End Delete Course Form ----------------------->
                </div>

                <!----------------------- Start Course Infortion Table Section ----------------------->
                <!------------------ Start Title Table Section ----------------->
                <div class="course_info2">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                                    <a href="#">Academic <b>Groups</b></a>
                                </div>
                                <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7"> 
                                    <form class="d-flex" action="/CollegeSchedule_war/CourseDepartmentLevel" method="get">
                                        <input class="form-control me-2 search-border" type="text"  placeholder="Search" aria-label="Search" name="search">
                                        <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                    </form>   
                                    <div class="press-btn">
                                        <a href="#addCourse2" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                        <a href="#deleteCourse2" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>   
                                        <a href="#editCourse2" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>  
                                    </div>                                            
                                </div>
                            </div>
                        </div>
                        <div class="scroll scroll-two">
                            <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                <thead id="headerTable">
                                    <tr>
                                        <th></th>
                                        <th class="range-cell2">Course Name</th>
                                        <th class="range-cell2">Department Name</th>
                                        <th class="range-cell">Level Name</th>
                                        <th class="range-cell">No. of Group</th>
                                        <th class="range-cell">No. of Section</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%List<CourseDepartmentLevel> courseDepartmentLevels=(List<CourseDepartmentLevel>) request.getAttribute("coursesDepartmentsLevels");
                                    for(CourseDepartmentLevel courseDepartmentLevel:courseDepartmentLevels){
                                %>
                                    <tr>
                                        <td></td>
                                        <td class="range-cell2"><%=courseDepartmentLevel.getCourse().getCourseName()%></td>
                                        <td class="range-cell2"><%=courseDepartmentLevel.getDepartment().getDepartmentName()%></td>
                                        <td class="range-cell"><%=courseDepartmentLevel.getLevel().getLevelName()%></td>
                                        <td class="range-cell"><%=courseDepartmentLevel.getNum_of_groups()%></td>
                                        <td class="range-cell"><%=courseDepartmentLevel.getNum_of_sections()%></td>
                                        <td>
                                            <form action="/CollegeSchedule_war/CourseDepartmentLevel" method="get">
                                                <input type="hidden" name="hidden" value="<%=courseDepartmentLevel.getCourse().getCourseID()%>">
                                                <input type="hidden" name="hidden1" value="<%=courseDepartmentLevel.getLevel().getLevelID()%>">
                                                <input type="hidden" name="hidden2" value="<%=courseDepartmentLevel.getDepartment().getDepartmentID()%>">
                                                <!-- <a href="#editCourse2" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a> -->
                                                <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                            </form>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                        <!----------------------- End Course Infortion Table Section ----------------------->
                        
                        <!----------------------- Strat Add Course Form ----------------------->
                        <div id="addCourse2" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseDepartmentLevel" method="post">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Add Academic Group</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                    <label for=" ">Course Name</label><br>
                                                    <select name="courseName" class="form-control">
                                                        <%
                                                            List<Course> courses=new CourseServices().findAllCourses();
                                                            for(Course course:courses){
                                                        %>
                                                      <option><%=course.getCourseID()+"- "+course.getCourseName()%></option>
                                                        <%}%>
                                                    </select>
                                            </div>
                                            <div class="form-group">
                                                    <label for="">Department Name</label><br>
                                                    <select name="departmentName" class="form-control">
                                                        <%
                                                            List<Department> departments=new DepartmentServices().findAllDepartments();
                                                            for(Department department:departments){
                                                        %>
                                                      <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                                        <%}%>
                                                    </select>
                                            </div>
                                            <div class="form-group">
                                                    <label for="">Level Name</label><br>
                                                    <select name="levelName" class="form-control">
                                                        <%
                                                            List<Level> levels=new LevelServices().findAllLevels();
                                                            for(Level level:levels){
                                                        %>
                                                      <option><%=level.getLevelID()+"- "+level.getLevelName()%></option>
                                                        <%}%>
                                                    </select>
                                            </div>
                                            <div class="form-group">
                                                <label>No. of Group</label>
                                                <input type="number" class="form-control"   name="group" required>
                                            </div>    
                                            <div class="form-group">
                                                <label>No. of Section</label>
                                                <input type="number" class="form-control"   name="section" required>
                                            </div>   
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                            <input type="submit"  class="btn btn-success" value="Add" name="action">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!----------------------- End Add Course Form ----------------------->
                        <!----------------------- Strat Edit Course Form ----------------------->
                        <div id="editCourse2" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseDepartmentLevel" method="post">
                                        <div class="modal-header">
                                            <h4 class="modal-title">Edit Academic Group</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for=" ">Course Name</label><br>
                                                <select name="courseName" class="form-control">
                                                    <%
                                                        for(Course course:courses){
                                                    %>
                                                    <option><%=course.getCourseID()+"- "+course.getCourseName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="">Department Name</label><br>
                                                <select name="departmentName" class="form-control">
                                                    <%
                                                        for(Department department:departments){
                                                    %>
                                                    <option><%=department.getDepartmentID()+"- "+department.getDepartmentName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="">Level Name</label><br>
                                                <select name="levelName" class="form-control">
                                                    <%
                                                        for(Level level:levels){
                                                    %>
                                                    <option><%=level.getLevelID()+"- "+level.getLevelName()%></option>
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>No. of Group</label>
                                                <input type="number" class="form-control"   name="group" required>
                                            </div>
                                            <div class="form-group">
                                                <label>No. of Section</label>
                                                <input type="number" class="form-control"   name="section" required>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="cancel">
                                            <input type="submit" class="btn btn-info " value="Save" name="action">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <!----------------------- End Edit Course Form ----------------------->
                        <!----------------------- Start Delete Course Form ----------------------->
                        <div id="deleteCourse2" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/CourseDepartmentLevel" method="get">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Delete Academic Group</h4>
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
                    <!----------------------- End Delete Course Form ----------------------->
                    </div>
                    <input id="notLogin" type="hidden" value="<%=request.getSession().getAttribute("adminID")%>">
                </div>
            </div>
        </div>
        <!-- End demo content -->

<!-- End Table ------------------------------------------------------------------------------- -->
        

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