Create Table HRDS.Departments(
    DEPARTMENT_ID INT 	PRIMARY KEY, 
    DEPARTMENT_NAME VARCHAR(50) NOT NULL, 
    LOCATION_ID INT, 
    MANAGER_ID INT
)

Insert Into HRDS.Departments Values(1, "Engineering", 100, 1000);
Insert Into HRDS.Departments Values(2, "Sales", 100, 1001);
Insert Into HRDS.Departments Values(3, "Marketing", 101, 1002);
Insert Into HRDS.Departments Values(4, "Finance", 103, 1004);
Insert Into HRDS.Departments Values(5, "Logistics", 100, 1005);
Insert Into HRDS.Departments Values(6, "RD", 103, 1006);
Insert Into HRDS.Departments Values(10, "PR", 103, 1010)


