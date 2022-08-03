package models;

public abstract class News {
    private String title;
    private int author;

    private String contentUrl;

    private int id;

    public News(String title,int author,String contentUrl){
        this.title = title;
        this.author = author;
        this.contentUrl =contentUrl;

    }

    public String getTitle() {
        return title;
    }

    public int getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    @Override
    public boolean equals(Object otherNews){
        if(!(otherNews instanceof News)){
            return false;
        }else{
            News newStory = (News) otherNews;
            return this.getTitle().equals(newStory.getTitle())&&this.getContentUrl().equals(newStory.getContentUrl());
        }
    }

    public int setId(int id) {
        return this.id = id;
    }
}
