Create models: Employee, EmployeeStatus, Address, Personal, Project, Unit

Take into account the following:

EmployeeStatus should be Enum type
Address should be embedded to Employee object

Relationship between Employee and EmployeePersonalInfo should be one-to-one
Relationship between Employee and Project should be many-to-many
Relationship between Unit and Employee should be one-to-many

Implement Service API which provides:

Create Employee / Unit / Project
Find employee / Unit / Project by id
Delete employee / Unit / Project by id
Update Employee / Unit / Project by id

Add Employee to Unit by id’s
Assign Employee for Project by id’s


===========================================================================================================

To check this tasks please change
<property name="hibernate.connection.url" value="jdbc:h2:D:\projects\IntelliJIdea\jpa\src\test\resources\h2ForJPA"/>
value to some like jdbc:h2:%your_path%
in the %project_root%\src\test\resources\META-INF\persistence.xml

and run all test cases