package models;

import java.util.List;
import java.util.Objects;

public class DepartmentNews extends News {
    private String type;
    private int department;

    private int id;

    private Department myDepartment;
    private String name;


    public DepartmentNews(String title,int author, String contentUrl, int department){
        super(title,author,contentUrl);
        this.department=department;
        this.type = "departmental";

    }

    public DepartmentNews(String title,int author, String contentUrl, int department,String name){
        super(title,author,contentUrl);
        this.department=department;
        this.type = "departmental";
        this.name = name;
    }

    public String getName() {
        return this.name ;
    }

    public int getDepartment() {
        return department;
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
