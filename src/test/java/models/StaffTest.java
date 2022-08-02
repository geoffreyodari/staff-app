package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest {
   @Test
    public void new_Staff_Instantiates_Correctly(){
       Staff newStaff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
       assertTrue(newStaff instanceof  Staff);
   }


   @Test
    public void staff_gets_name(){
       String name ="Geoffrey";
       Staff newStaff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
       assertEquals(name,newStaff.getName());
   }

    @Test
    public void staff_gets_staffId(){
        String staffId ="001";
        Staff newStaff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        assertEquals(staffId,newStaff.getStaffId());
    }

    @Test
    public void staff_gets_Department(){
        int department =1;
        Staff newStaff = new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
        assertEquals(department,newStaff.getDepartment());
    }


 //Helper Method
    public Staff generateStaff(){
       return new Staff("Geoffrey","001","g@email.com","2355","Developer",1);
    }

}
