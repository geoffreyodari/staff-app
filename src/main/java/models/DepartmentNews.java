package models;

public class DepartmentNews extends News {
    private String type;
    private int department;

    private String contentUrl;

    public DepartmentNews(String title,int author,String contentUrl){
        super(title,author);
        this.type = "departmental";
        this.contentUrl =contentUrl;
    }
    public DepartmentNews(String title,int author,String contentUrl,int department){
        super(title,author);
        this.type = "departmental";
        this.contentUrl =contentUrl;
        this.department = department;
    }

    public String getContentUrl() {
        return contentUrl;
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
}
