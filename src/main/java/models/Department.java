package models;

import models.dao.Sql2oStaffDao;

import java.util.List;
import java.util.Objects;

public class Department {
    String departmentName;
    String description;

    int size;
    int id;

    private static Staff staff;
    public Department(String departmentName,String description){
        this.departmentName = departmentName;
        this.description = description;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }


    public int setId(int id) {
        return this.id = id;
    }


    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Department)){
            return false;
        }else{
            Department that = (Department) o;
            return  id == that.id &&
                    Objects.equals(departmentName, that.departmentName)&&
                    Objects.equals(description, that.description);


        }

    }
}
