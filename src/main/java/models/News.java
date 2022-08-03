package models;

public abstract class News {
    private String title;
    private String author;

    private int id;

    public News(String title,String author){
        this.title = title;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherNews){
        if(!(otherNews instanceof News)){
            return false;
        }else{
            News newStory = (News) otherNews;
            return this.getTitle().equals(newStory.getTitle())&&this.getAuthor().equals(newStory.getAuthor());
        }
    }

}
