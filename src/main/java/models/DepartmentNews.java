package models;

public class DepartmentNews extends News {
    private String type;
    private int department;

    public DepartmentNews(String title,int author, String contentUrl, int department){
        super(title,author,contentUrl);
        this.department=department;
        this.type = "departmental";
    }

    public int getDepartment() {
        return department;
    }
}
