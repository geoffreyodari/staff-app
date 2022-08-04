package models;

public class GeneralNews extends News{
    private String type;

    private String contentUrl;
    public GeneralNews(String title,int author,String contentUrl){
        super(title, author);
        this.type="general";
        this.contentUrl = contentUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public String getType() {
        return this.type;
    }
}
