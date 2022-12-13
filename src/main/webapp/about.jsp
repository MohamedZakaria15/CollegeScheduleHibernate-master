<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- ===== CSS ===== -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href='css/all.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/style.css">
    <title>User's Guide</title>
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
            <a href="about.jsp" class="nav-link color_text active-click">
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
    <!----------------------- Start Assistant Information Table Section ---------------------!-->
    <div class="container">
        <div class="User's_Guide mb-5">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="top-title col-12 col-sm-12 col-md-12 col-lg-5">
                            <a href="#">User's Guide</a>
                        </div>

                    </div>
                </div>
                <ul class="about-ul">
                    <li>
                        <h5 class="about">Degree Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                lecturer Degree:
                                Id: 1, name: professor, min hour: 3, max hour: 12.<br>
                                Assistant Degree:
                                Id: 3, name: assistant, min hour: 12, max hour: 24.
                            </b>
                            <li>The page contains 2 tables (lecturer degree and assistant degree).</li>
                            <li><b>The first table (lecture degree):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the lecturer degree.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add lecturer degree form then the admin fills out all inputs to add new data to lecturer degree(lecturer id, lecturer name, min hours of work per week, max hours of work per week ).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit lecturer form then the Admin enters the correct id that you want to edit the lecturer degree table (lecturer id, lecturer name, min hours of work per week, max hours of work per week).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted all the lecturer degrees. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this lecturer degree. If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table so it will appear in the lecturer degree table. if search data does not exist in the table so no data appear in the lecturer degree table.</li>
                                </ul>
                            </li>
                            <li><b>In the second table (assistant degree):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Assistant degree.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add assistant degree from the admin fills out all inputs to add new data to the assistant degree (assistant id, assistant name, min hours of work per week, max hours of work per week).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit assistant form then the Admin enters the correct id that you want to be edit in the assistant degree (assistant id, assistant name, min hours of work per week, max hours of work per week).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted all the assistant degrees. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this assistant degree. If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search button then press the search button, if this data exists in the table, so it will appear in the assistant degree table. if search data does not exist in the table then no data appear in the assistant degree table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Departments Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Id: 55, name: computer science
                                Id: 45, name: information system.
                            </b>
                            <li>The user can add, update delete, and search the department's table.
                            </li>
                            <ul class="inseted_ul">
                                <li>If add icon is selected, this will lead to the move to add department form then the admin fills out all inputs to add new data to the department (department Id, and department name).
                                </li>
                                <li>If the edit icon is selected, this will lead to move to the edit department form then the Admin enters the correct id that you want to be edit in the Department (department Id, and department name).</li>
                                <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted all the departments. If not, then he will select Cancel.</li>
                                <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this department If not, then he will select Cancel.</li>
                                <li>If the user deletes one of the Departments that are related to other tables (Lecturer Information, Academic Groups, Level Information, and Assistant Information tables), an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Department table. If search data does not exist in the table then no data appear in the Department table.</li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Courses Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Id: 123, name: data structure, full time: 100 h.
                            </b>
                            <li>The user can add, update delete, and search the Courses table.
                            </li>
                            <ul class="inseted_ul">
                                <li>If add icon is selected, this will lead to the move to add course form then the admin fills out all inputs to add new data to the course ( Course Id, Course name, and Full Time).
                                </li>
                                <li>If the edit icon is selected, this will lead to the move to edit course form then the Admin enters the correct id that you want to be edit in the course (Course Id, Course name, and Full Time).</li>
                                <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted all the Courses. If not, then he will select Cancel.</li>
                                <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this course If not, then he will select Cancel.</li>
                                <li>If the user deletes one of the Courses that are related to other tables (Academic Groups, Lecturer Courses,  Assistant Courses, and Course Places tables) an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Course table. if search data does not exist in the table then no data appear in the Course table.</li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Levels Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Id: 5, name: level 1.
                            </b>
                            <li>The user can add, update, delete, and search the levels table.
                            </li>
                            <ul class="inseted_ul">
                                <li>If add icon is selected, this will lead to the move to add level form then the admin fills out all inputs to add new data to the level ( level Id, and level name).
                                </li>
                                <li>If the edit icon is selected, this will lead to move to edit level form then the admin fills out all inputs to edit the level (level Id, and level name).</li>
                                <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not if he is sure, he will select Delete to be deleted all the levels. If not, then he will select Cancel.</li>
                                <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this level If not, then he will select Cancel.</li>
                                <li>If the user deletes one of the Courses that are related to other tables (Level Information and Academic Groups tables) an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the level table. If search data does not exist in the table then no data appear in the level table.</li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Place information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Place type:
                                Id: 33, name: lab
                                Id: 88, name: classroom.
                                <br>
                                Room:
                                Id: 33, name: lab, type id: 1, description: in the floor.

                            </b>
                            <li>The page contains 2 tables (Place Types and Rooms).</li>
                            <li><b>The first table (Place Types):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Place Types table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Place Type form then the admin fills out all inputs to add new data to the place type ( place Id, and place name ).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Place Type form then the admin fills out inputs to edit the Place type (place Id, and place name).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not if he is sure, he will select Delete to be deleted all the place types. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not if he is sure, he will select Delete to be deleted this place type  If not, then he will select Cancel.</li>
                                    <li>If the user deletes one of the types of places that are related to other tables (Rooms and Course Places tables), an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the level table. If search data does not exist in the table then no data appear in the place types table.
                                    </li>
                                </ul>
                            </li>
                            <li><b>In the second table (Rooms):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Rooms table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Room form then the admin fills out all inputs to add new data to the Rooms( room Id, and room name, type ID, type room, and room description).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Rooms form then the admin fills out inputs to edit the Rooms (room Id, and room name, type ID, type room, and room description).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Rooms. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Room If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Rooms table. If search data does not exist in the table then no data appear in the Rooms table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Course information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Id: 123, name: information system, place type name: lab, duration: 3.
                                <br>
                                Department Name: computer science, level name: four, No. of groups: 3, No. of sections: 10.
                            </b>
                            <li>The page contains 2 tables (Course Places and Academic Groups).</li>
                            <li><b>The first table (Course Places):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Course Places table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Course Place form then the admin fills out all the inputs on this form to add new data to the Course Place(Courses Name, Place Type Name, and Duration).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Course Place form then the admin fills out all inputs on this form to edit the Course Place (Courses Name, Place Type Name, and Duration).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Course Places. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Course Places If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Course Places table. if search data does not exist in the table then no data appear in the Course Places table.</li>
                                </ul>
                            </li>
                            <li><b>In the second table (Academic Groups):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Academic Groups table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to Academic Groups form then the admin fills out all the inputs on this form to add new data to the Academic Group(Courses Name, Department Name, Level name, No. of a group, and No. of section).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Academic Groups form then the admin fills out all inputs on this form to edit the Academic Group (Courses Name, Department Name, Level name, No. of a group, and No. of section).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Academic Groups. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Academic Group If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Academic Groups table. If search data does not exist in the table then no data appear in the Academic Groups table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Levels Information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Id: 5, name: level 4, Department name: computer science, Day name: Monday.
                            </b>
                            <li>The user can add, update, delete, and search the level information table
                            </li>
                            <ul class="inseted_ul">
                                <li>If add icon is selected, this will lead to the move to add level information form then the admin fills out all inputs on this form to add new data to the level information ( level Name, Department Name, Day Name).
                                </li>
                                <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the place information. If not, then he will select Cancel.</li>
                                <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this level information  If not, then he will select Cancel.</li>
                                <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the level table. If search data does not exist in the table then no data appear in the level information table.</li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Place information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:
                                Place type:
                                Id: 33, name: lab
                                Id: 88, name: classroom.
                                <br>
                                Room:
                                Id: 33, name: lab, type id: 1, description: in the floor.

                            </b>
                            <li>The page contains 2 tables (Place Types and Rooms).</li>
                            <li><b>The first table (Place Types):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Place Types table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Place Type form then the admin fills out all inputs to add new data to the place type ( place Id, and place name ).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Place Type form then the admin fills out inputs to edit the Place type (place Id, and place name).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not if he is sure, he will select Delete to be deleted all the place types. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not if he is sure, he will select Delete to be deleted this place type  If not, then he will select Cancel.</li>
                                    <li>If the user deletes one of the types of places that are related to other tables (Rooms and Course Places tables), an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the level table. If search data does not exist in the table then no data appear in the place types table.
                                    </li>
                                </ul>
                            </li>
                            <li><b>In the second table (Rooms):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Rooms table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Room form then the admin fills out all inputs to add new data to the Rooms( room Id, and room name, type ID, type room, and room description).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Rooms form then the admin fills out inputs to edit the Rooms (room Id, and room name, type ID, type room, and room description).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Rooms. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Room If not, then he will select Cancel.</li>
                                    <li>If the user enters data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Rooms table. If search data does not exist in the table then no data appear in the Rooms table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Lecturer information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:<br>
                                Lectuerer information<br>
                                Id: 89,
                                first name: Mosa, middle name: Khalid, last name: Amer<br>
                                Department Name: computer science,
                                degree: doctor.
                                <br>
                                Lecturer Free Days<br>
                                Lecturer Id: 89,
                                Lecturer name: Mosa kalid Amer<br>
                                Day Off 1: Saturday,
                                Day off 2: Monday
                                <br>
                                Lecturer Id: 89,
                                Lecturer name: Mosa kalid Amer<br>
                                course ID: 123,
                                Course Name: Image Processing
                            </b>
                            <li>The page contains 3 tables (Lecturer Information, Lecturer Free Days, and Lecturer Courses)</li>
                            <li><b>The first table (Lecturer Information):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the lecturer information table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add lecturer information form then the admin fills out all the entries on this form to add new data to the lecturer information (ID, lecturer Name, Department Name, and Degree).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to the edit lecturer information form then the admin fills out all inputs on this form to edit the lecturer information (ID, lecturer Name, Department Name, and Degree).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the lecturer information. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this lecturer information  If not, then he will select Cancel.</li>
                                    <li>If the user deletes one of the lecturer information that is related to other tables (Lecturer Free Days, and Lecturer Courses tables), an error message will appear indicating that he cannot delete it because it has a relationship with another table</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the lecturer information table. If search data does not exist in the table then no data appear in the lecturer information table.</li>
                                </ul>
                            </li>
                            <li><b>In the second table (Lecturer Free Days):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the lecturer Free Days table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Lecturer Free Days form then the admin fills out all the entries on this form to add new data to the lecturer Free Days (Lecturer ID, lecturer Name, and Day Name).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Free Day form then the admin fills out all inputs on this form to edit the lecturer Free Day(Lecturer ID, lecturer Name, and Day Name).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the lecturer Free Days. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this lecturer Free Day If not, then he will select Cancel.</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the lecturer Free Days table. If search data does not exist in the table then no data appear in the lecturer Free Days table.</li>
                                </ul>
                            </li>
                            <li><b>In the third table (Lecturer Courses):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the lecturer Courses table
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Courses form then the admin fills out all the entries on this form to add new data to the lecturer Courses (Lecturer ID, lecturer Name, Course ID, and  Course Name).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Courses form then the admin fills out all inputs on this form to edit the lecturer Courses(Lecturer ID, lecturer Name, Course ID, and  Course Name).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the lecturer Courses. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this lecturer Courses If not, then he will select Cancel.</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the lecturer Courses table. If search data does not exist in the table then no data appear in the lecturer Courses table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Assistant information Tap:</h5>
                        <ol class="pl-5">
                            <b>For Example:<br>
                                Assistant information<br>
                                Id: 89,
                                first name: Mosa, middle name: Khalid, last name: Amer<br>
                                Department Name: computer science,
                                degree: Assistant.
                                <br>
                                Assistant Attendance Days<br>
                                Assistant Id: 89,
                                Assistant name: Mosa kalid Amer<br>
                                Day Off 1: Saturday,
                                Day off 2: Monday
                                <br>
                                Assistant Id: 89,
                                Assistant name: Mosa kalid Amer<br>
                                course ID: 123,
                                Course Name: Image Processing
                            </b>
                            <li>1.	The page contains 3 tables (Assistant Information, Assistant Attendance Days, and Assistant Courses)</li>
                            <li><b>The first table (Assistant Information):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Assistant information table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Assistant information form then the admin fills out all the entries on this form to add new data to the Assistant information (ID, Assistant Name, Department Name, and Degree).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Assistant information form then the admin fills out all inputs on this form to edit the Assistant information (ID, Assistant Name, Department Name, and Degree).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Assistant information. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Assistant information  If not, then he will select Cancel.</li>
                                    <li>If the user deletes one of the Assistant information that is related to other tables (Assistant Attendance Days, and Assistant Courses tables), an error message will appear indicating that he cannot delete it because it has a relationship with another table.</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Assistant information table. If search data does not exist in the table then no data appear in the Assistant information table.</li>
                                </ul>
                            </li>
                            <li><b>In the second table (Assistant Attendance Days):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Assistant Attendance Days table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Assistant Attendance Days form then the admin fills out all the entries on this form to add new data to the Assistant Attendance Days (Assistant ID, Assistant Name, and Attendance Day).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Assistant Attendance Day form then the admin fills out all inputs on this form to edit the lecturer Assistant Attendance Day (Assistant ID, Assistant Name, and Attendance Day).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Assistant Attendance Days. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Assistant Attendance Day If not, then he will select Cancel.</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Assistant Attendance Days table. If search data does not exist in the table then no data appear in the Assistant Attendance Days table.</li>
                                </ul>
                            </li>
                            <li><b>In the third table (Assistant Courses):</b>
                                <ul class="inseted_ul">
                                    <li>The user can add, update, delete, and search the Assistant Courses table.
                                    </li>
                                    <li>If add icon is selected, this will lead to the move to add Assistant Courses form then the admin fills out all the entries on this form to add new data to the Assistant Courses (Assistant ID, Assistant Name, Course ID, and  Course Name).
                                    </li>
                                    <li>If the edit icon is selected, this will lead to move to edit Assistant Courses form then the admin fills out all inputs on this form to edit the Assistant Courses (Assistant ID, Assistant Name, Course ID, and Course Name).</li>
                                    <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Assistant Courses. If not, then he will select Cancel.</li>
                                    <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Assistant Courses If not, then he will select Cancel.</li>
                                    <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Assistant Courses table. If search data does not exist in the table then no data appear in the Assistant Courses table.</li>
                                </ul>
                            </li>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Show Schedule Tap:</h5>
                        <ol class="pl-5">
                            <ul class="inseted_ul">
                                <li>If there is no schedule an error message will appear, else The Schedule table will appear for lectures and sections.
                                </li>
                                <li>If the admin selects data in search options like (department name, level, and Group number) then press the search button, the table will contain information about specific department and level and Group number only.</li>
                                <li>If the user does not select a specific (department name or level or Group number) the table will contain all information about all departments, levels, and Groups.
                                </li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">User’s Guide :</h5>
                        <ol class="pl-5">
                            <ul class="inseted_ul">
                                <li>It contains guides and an explanation of how to use the site
                                </li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Time Tap:</h5>
                        <ol class="pl-5">
                            <ul class="inseted_ul">
                                <li>The user can update the Time table
                                </li>
                                <li>If the edit icon is selected, this will lead to move to edit Time form then the admin fills out all inputs on this form to edit the Time (Start Time, and End Time).</li>
                            </ul>
                        </ol>
                    </li>
                    <li>
                        <h5 class="about">Admin information Tap:</h5>
                        <ol class="pl-5">
                            <li>The user can add, update, delete, and search the Admin information table.
                            </li>
                            <ul class="inseted_ul">
                                <li>If add icon is selected, this will lead to the move to add Admin information form then the Manager only fills out all the entries on this form to add new data to the Admin information (ID, First Name, Middle Name, Last Name Email, Password, and Confirm Password).
                                </li>
                                <li>If the edit icon is selected, this will lead to move to edit Admin information form then the admin/Manager fills out all inputs on this form to edit the Admin information (ID, First Name, Middle Name, Last Name Email, Password, and Confirm Password).</li>
                                <li>If the delete icon in the header table is selected, a message will appear asking him whether he wants to confirm the deletion or not. If he is sure, he will select Delete to be deleted all the Admin information. If not, then he will select Cancel.</li>
                                <li>If the delete icon in the row is selected, a message will appear asking him whether he wants to confirm the deletion or not If he is sure, he will select Delete to be deleted this Admin information If not, then he will select Cancel.</li>
                                <li>If enter data in a search input then press the search button, if this data exists in the table, only these search data will appear in the Admin information table. If search data does not exist in the table then no data appear in the Admin information table.</li>
                            </ul>
                        </ol>
                    </li>
                </ul>
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