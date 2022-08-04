package models;


import java.util.List;
import java.util.Objects;

public class Staff {
    private String name;
    private String staffId;
    private String email;
    private String phone;
    private String role;
    private int  department;
    private String departmentName;
    private int id;



    public Staff(String name, String staffId,String email,String phone,String role){
        this.name = name;
        this.staffId = staffId;
        this.email = email;
        this.phone = phone;
        this.role = role;

    };

    public Staff(String name, String staffId,String email,String phone,String role,int department){
        this.name = name;
        this.staffId = staffId;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.department = department;

    };


    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }


    public String getRole() {
        return role;
    }

    public String getStaffId() {
        return staffId;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Staff) ){
            return false;
        }else{
            Staff that = (Staff) o;
            return id == that.id &&
                    Objects.equals(name, that.name) &&
                    Objects.equals(email, that.email) &&
                    Objects.equals(staffId, that.staffId);

        }
    }

}
