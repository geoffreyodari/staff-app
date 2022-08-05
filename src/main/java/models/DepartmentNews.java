package models;

import java.util.List;
import java.util.Objects;

public class DepartmentNews extends News {
    private String type;
    private int department;

    private String contentUrl;

    private String departmentName;


    public DepartmentNews(String title,int author,String contentUrl){
        super(title,author);
        this.type = "departmental";
        this.contentUrl =contentUrl;
    }

    public DepartmentNews(String title,int author,String contentUrl,int department){
        super(title,author);
        this.type = "departmental";
        this.contentUrl =contentUrl;
    }
    public DepartmentNews(String title,int author,String contentUrl,int department,String departmentName){
        super(title,author);
        this.type = "departmental";
        this.contentUrl =contentUrl;
        this.department = department;
        this.departmentName = departmentName;
    }
    public String getContentUrl() {
        return contentUrl;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }


    public String getType() {
        return type;
    }


    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof DepartmentNews)){
            return false;
        }else{
            DepartmentNews that = (DepartmentNews) o;
            return  Objects.equals(getTitle(), that.getTitle())&&
                    Objects.equals(getContentUrl(), that.getContentUrl());


        }

    }


}
