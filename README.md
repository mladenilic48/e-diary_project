# e-diary_project


Final project description

•	Project goal was to implement elementary school electronic gradebook web application. 
•	Application has following functionality: 
    o	Grade recording
    o	Grade overview
    o	Grade search
    o	Teacher loging

•	In this project we defined following entities 
    o	Teacher(defined by first and last name)
    o	Student(defined by first and last name)
    o	Subject (minimum defined by name and teaching load)
    o	Grade(Values between 1 - 5)
    o	User(defined by username and password)
    o	Parent(defined by first name, last name and address)  

•	Relationships between entities are:
    o	Teacher is teaching some of the classes to some of the students. 
    o	Student can have multiple grades in the same class in the same semester(1-5).
    o	Class is held at multiple semesters. 
    o	Every student and teacher are mapped exactly to one user. 
    o	Every parent has at least one student and it is mapped to exactly one user. 


Additional functionality if the application and terms of usage:

•	Users can access the application by providing username and password. 
•	User type:
    o	Teacher
    o	Student
    o	Administrator
    o	Parent
    
•	If user is a student then that type of user can only view the grades. 
•	If user is the parent then that type of user can view the grades of all students that are related to the parent.
•	If user is teacher then that type of user can view all grades for all classes he is teaching as well as all students he is teacher for. User can update, delete or insert students and classes as well as search for them. 
•	FInally if user is administrator then that type of user has complete access to all the data in the system. 


Administrator duties:
 
•	Addition, removal and updating of:
    o	Classes
    o	Teachers
    o	Students
    o	Parents
    o	Grades

•	Adding and removing functionality entirely adds/removes all entity information and relationships between entities. 
•	Application has logging functionality: Storing all relevant events in the logs including all application errors.   
•	Application allows that all logs are visible only to administrator.  
•	Application will notify parents when student receives grade from the teacher. 

