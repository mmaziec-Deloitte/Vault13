package models;

public class Department {

    private DepartmentName departmentName;
    private int dwellersNumber = 0;

    enum DepartmentName {
        CAFETERIA,
        ARMOURY,
        COMMAND_CENTER,
        OFFICE,
        ENTRANCE,
        LAB
    }

    public Department(DepartmentName departmentName) {
        this.departmentName = departmentName;
        //this.dwellersNumber = dwellersNumber;
    }
}
