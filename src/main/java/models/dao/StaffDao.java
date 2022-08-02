package models.dao;

import models.Staff;

import java.util.List;

public interface StaffDao {
    //create
    void add(Staff staff);
    //void addStaffToDepartment(Staff staff, Department department);

    //read
    List<Staff> getAll();
    // List<Staff>getAllStaff(int id);

    List<Staff>findStaffId(String id);

    List<Staff>findStaffByDepartmentId(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
