<%@ page import="java.util.List" %>
<%@ page import="entities.Admin" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- ===== CSS ===== -->    
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> 
        <link href='css/all.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/style.css">
        
        <title>Admin Information</title>
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
                            <a href="/CollegeSchedule_war/AdminInfo" class="nav-link color_text active-click">
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

        <!-- ----------------------- Page content holder -----------------------! -->
        <div class="page-content" id="content">
            <!-- Toggle button -->
            <button id="sidebarCollapse" type="button" class="btn btn-light rounded-pill shadow-sm mb-4 sidebarCollapse_background sticky-top"><i class="fa fa-bars "></i></button>
            <!----------------------- Start Admin Information Table Section ---------------------!-->
            <div class="container">
                <div class="adminInfo mb-5">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                                    <a href="#">Admin Information</a>
                                </div>
                                <div class="col-12 col-sm-12 col-md-12 mt-md-2 mt-sm-2 mt-2 col-lg-7">
                                    <form class="d-flex" action="/CollegeSchedule_war/AdminInfo" method="get">
                                        <input class="form-control me-2 search-border" type="search" placeholder="Search" aria-label="Search" name="search">
                                        <button class="btn btn-success btn-border" type="submit" name="action" value="Search">Search</button>
                                    </form> 
                                    <%if((int) request.getSession().getAttribute("adminID")==1){%>
                                        <div class="press-btn-admin">
                                            <a href="#addadminInfo" data-toggle="modal"><i class="fas fa-user-plus mr-2 add"></i> </a>
                                            <a href="#deleteadminInfo" data-toggle="modal"><i class="fas fa-trash-alt mr-2 delete"></i></a>
                                        </div>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                        <div class="scroll scroll-one">
                            <table id="example"class="table table-striped table-hover diplay nowrap sticky" cellspacing="0" width="100%">
                                <thead id="headerTable">
                                    <tr>
                                        <th >ID</th>
                                        <th class="range-cell">Name</th>
                                        <th class="range-cell">Email</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%List<Admin> admins=(List<Admin>) request.getAttribute("admins");
                                    for(Admin admin:admins){
                                %>
                                    <tr>
                                        <td><%=admin.getAdminID()%></td>
                                        <td class="range-cell"><%=admin.getAdminFirstName()+" "+admin.getAdminMiddleName()+" "+admin.getAdminLastName()%></td>
                                        <td class="range-cell"><%=admin.getAdminEmail()%></td>
                                        <td>
                                            <form action="/CollegeSchedule_war/AdminInfo" method="get">
                                                <input type="hidden" name="hidden" value="<%=admin.getAdminID()%>">
                                                <%if(admin.getAdminID()==(int)request.getSession().getAttribute("adminID")){%>
                                                <a href="#editadminInfo" class="edit" data-toggle="modal"><i class="fas fa-edit mr-2" data-toggle="tooltip" title="Edit"></i></a>
                                                <%}else{%>
                                                <%if((int) request.getSession().getAttribute("adminID")==1){%>
                                                <button type="submit" name="action" value="deleteOne" class="delete" data-toggle="modal"><i class="fas fa-trash-alt mr-2" data-toggle="tooltip" title="Delete"></i></button>
                                            <%}%>
                                                <%}%>
                                            </form>
                                        </td>
                                    </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
            <!----------------------- End Admin Information Table Section ----------------------!-->
                        
                        <!----------------------- Start Add Admin Information Form ----------------------!-->
                        <div id="addadminInfo" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/AdminInfo" method="post">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Add Admin Information</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">  
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input type="number" name="ID_info" class="form-control">
                                            </div>   
                                            <div class="form-group">
                                                <label>First name</label>
                                                <input type="text" name="fname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Middle name</label>
                                                <input type="text" name="mname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Last name</label>
                                                <input type="text" name="lname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="email" name="email_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label>
                                                <input type="password" name="password_info" class="form-control" required>
                                            </div>    
                                            <div class="form-group">
                                                <label>Confirm password</label>
                                                <input type="password" name="password_info1" class="form-control" required>
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
                        <!----------------------- End Add Admin Information Form ----------------------!-->
                        <!----------------------- Start Edit Admin Information Form ----------------------!-->
                        <div id="editadminInfo" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/AdminInfo" method="post">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Edit Admin Information</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label>First name</label>
                                                <input type="text" name="fname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Middle name</label>
                                                <input type="text" name="mname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Last name</label>
                                                <input type="text" name="lname_info" class="form-control" required>
                                            </div>
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="email" name="email_info" class="form-control "  required>
                                            </div>
                                            <div class="form-group">
                                                <label>Old password</label>
                                                <input type="password" name="password_info2" class="form-control" required>
                                            </div> 
                                            <div class="form-group">
                                                <label>New password</label>
                                                <input type="password" name="password_info" class="form-control" required>
                                            </div>    
                                            <div class="form-group">
                                                <label>Confirm password</label>
                                                <input type="password" name="password_info1" class="form-control" required>
                                            </div>     
                                        </div>
                                        <div class="modal-footer">
                                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" name="Cancel">
                                            <input type="submit" class="btn btn-info" value="Save" name="action">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    <!----------------------- End Edit Admin Information Form ----------------------!-->
                    <!----------------------- Start Delete Admin Information Form ----------------------!-->
                        <div id="deleteadminInfo" class="modal fade">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <form action="/CollegeSchedule_war/AdminInfo" method="get">
                                        <div class="modal-header">      
                                            <h4 class="modal-title">Delete Admin Information</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        </div>
                                        <div class="modal-body">     
                                            <p>Are you sure you want to delete Record ? </p>
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
                    <!----------------------- End Delete Admin Information Form ----------------------!-->
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