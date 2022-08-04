package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {
    @Test
    public void newDepartment_Instantiates_Correctly(){
        Department newDepartment = new Department("Technology","Responsible for innovation");
        assertTrue(newDepartment instanceof Department);
    }


    @Test
    public void newDepartment_getsName(){
        String name = "Finance";
        Department newDepartment = new Department("Finance","Responsible funds management");
        assertEquals(name,newDepartment.getDepartmentName());
    }

    @Test
    public void newDepartment_getsDescription(){
        String description = "Responsible funds management";
        Department newDepartment = new Department("Finance","Responsible funds management");
        assertEquals(description,newDepartment.getDescription());
    }

}
