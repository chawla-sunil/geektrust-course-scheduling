# geektrust-course-scheduling
geektrust-course-scheduling

1. https://www.geektrust.com/challenge/course-scheduling

<b>Context</b>

The head of the Learning management system (LMS) has hired you as a consultant. The LMS team has the goal of upskilling the employees with the latest topics via courses. You need to help build a system to schedule and manage the courses.

<b>Goal</b>

Your job is to build a simple command line application, which does the following:
<ul>
<li>Add course offering</li>
<ul>
<li> A course offering has course title, instructor and date. </li>
<li> A course offering has course title, instructor and date. </li>
</ul>
</ul>

<ul>
<li>Register for the course</li>
<ul>
<li>Employees can register for the courses.</li>
<li>If no. of employees registered for the course has reached the maximum, the result will be COURSE_FULL_ERROR.</li>
<li>Otherwise, result of registration will be ACCEPTED. </li>
</ul>
</ul>


<ul>
<li>Cancel registration</li>
<ul>
<li>Employees can cancel their registration until the course allotment is completed. </li>
</ul>
</ul>

<ul>
<li>Course allotment</li>
<ul>
<li> This feature allots employees to course offering, before the course offering date.</li>
<li> It should print a list of all the employees with their details along with their final course allotment status (Registration Number, Employee Name, Email, Course Offering ID, Course Name, Instructor, Date, Final Status). The list should be sorted based on the Registration number. </li>
<li> If sufficient registrations are not received then the course offering itself gets cancelled. </li>
<li> The employees who have registered will get confirmed unless the minimum number of registrations is not received. </li>
<li>Even if the course offering gets canceled due to the minimum number of employees not registered, the list should be printed. </li>
</ul>
</ul>

<b>Commands</b>



Every input command has an output. The format is as given
    <COMMAND> <parameter-1>...<parameter-n> :	<OUTPUT>

1. Add course offering

COMMAND    ||| 	PARAMETERS	         ||| OUTPUT

ADD-COURSE-OFFERING	  |||    <course-name> <instructor> <date-in-ddmmyyyy> <minEmployees> <maxEmployees>	 |||  <course-offering-id>

1a. The format of course-offering-id is OFFERING-<COURSE-NAME>-<INSTRUCTOR>

2. Register for the course
   
COMMAND	 ||| PARAMETERS	  ||| OUTPUT
   REGISTER	 |||  <email-id> <course-offering-id>  |||	<course-registration-id> <status>

2a. The combination of email-id and course-offering-id in the input should be unique
2b. The format of course-registration-id is REG-COURSE-<EMPLOYEE-NAME>-<COURSE-NAME>
2c. If number of employees has not exceeded the maximum number of employees allowed for the course offering, status will be ACCEPTED
2d. If number of employees has exceeded the maximum number of employees allowed for the course offering, status will be COURSE_FULL_ERROR
2e. If the minimum number of employees for the course offering is not reached before the course date, the status of the course offering would be COURSE_CANCELED
2f. Course-registration-id will only be returned if the status is ACCEPTED



3. Course allotment :
   COMMAND	||| PARAMETERS	 ||| OUTPUT
   ALLOT-COURSE	||| <course-offering-id>  ||| 	<course-registration-id> <email-id> <course-offering-id> <course-name> <instructor> <date-in-ddmmyyyy> <status>

3a. The output should be sorted by course-registration-id in ascending order

4. Cancel registration
4a.  The employee can cancel the course registration given a course registration id until course allotment

COMMAND	 ||| PARAMETERS	  ||| OUTPUT
CANCEL |||	<course-registration-id>	||| <course-registration-id> <status>

4b. There are 2 statuses : CANCEL_ACCEPTED, CANCEL_REJECTED
4c. CANCEL_ACCEPTED when the cancellation is successful.
4d. CANCEL_REJECTED when the course is already allotted.


<b>Assumptions</b>

a. If there is validation error in the input (data validation or mandatory fields missing) then it should print an error message INPUT_DATA_ERROR.
b. Employees can only cancel their registration until the course is allotted.
c. Instructor names are unique
d. Course names are unique
e. None of the input fields accept whitespace (whitespace acts as a delimiter between fields)
f. Course offering ID generated is a combination of OFFERING-<COURSENAME>-<INSTRUCTORNAME>
g. Registration ID generated is a combination of REG-COURSE-<EMPLOYEENAME>-<COURSENAME>
h. <EMPLOYEENAME> is extracted from email ID: everything before the @ sign in the email

   Step 1: Go to the geektrust-course-scheduling
   Step 2: run below command

        $ mvn clean install 


   Step 2: This will create a jar file geektrust-course-scheduling-1.0-SNAPSHOT.jar in the target folder.(name can be different)

        $ java -jar target/geektrust-course-scheduling-1.0-SNAPSHOT.jar input_data/input.txt 

8. You can also run it directly by executing CourseSchedulingMain.java file
   Step 1: it will ask for input in console type commands and to stop type EXIT