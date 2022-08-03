package models;

public class DepartmentNews extends News {

    private int department;

    public DepartmentNews(String title,String author,int department){
        super(title,author);
        this.department=department;
    }

    public int getDepartment() {
        return department;
    }
}
