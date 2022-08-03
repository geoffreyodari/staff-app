package models;

public class GeneralNews extends News{
    private static String type;
    public GeneralNews(String title,int author, String contentUrl){
        super(title, author,contentUrl);
        this.type="general";
    }

    public static String getType() {
        return type;
    }
}
