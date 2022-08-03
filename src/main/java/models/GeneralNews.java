package models;

public class GeneralNews extends News{
    private String type;
    public GeneralNews(String title,int author, String contentUrl){
        super(title, author,contentUrl);
        this.type="general";
    }

    public String getType() {
        return this.type;
    }
}
