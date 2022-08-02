package models;



public class Staff {
    private String name;
    private String staffId;
    private String email;
    private String phone;
    private String role;
    private int  department;

    private int id;


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

    public String getRole() {
        return role;
    }

    public String getStaffId() {
        return staffId;
    }
}
