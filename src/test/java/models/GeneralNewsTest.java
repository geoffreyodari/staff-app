package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralNewsTest {
    @Test
    public void newsInstantiatesCorrectly(){
        String title="Kenyans go to elections";
        int author = 1;
        String contentUrl ="news/kenyans-go-to-elections";
        GeneralNews newsItem = new GeneralNews(title,author,contentUrl);
        assertTrue(newsItem instanceof GeneralNews);
    }

    @Test
    public void getTitle_getsNewsTitle(){
        String title="Man Lands on moon";
        int author = 1;
        String contentUrl ="/news/man-lands-on/moon";
        GeneralNews newsItem = new GeneralNews(title,author,contentUrl);
        assertEquals(title,newsItem.getTitle());
    }

    @Test
    public void getAuthor_getsNewsAuthor(){
        String title="Man Lands on moon";
        int author = 1;
        String contentUrl ="/news/man-lands-on/moon";
        GeneralNews newsItem = new GeneralNews(title,author,contentUrl);
        assertEquals(author,newsItem.getAuthor());
    }

    @Test
    public void getContentUrl_getsNewsUrl(){
        String title="Man Lands on moon";
        int author = 1;
        String contentUrl ="/news/man-lands-on/moon";
        GeneralNews newsItem = new GeneralNews(title,author,contentUrl);
        assertEquals(contentUrl,newsItem.getContentUrl());
    }

    @Test
    public void getType_getsNewType(){
        String title="Man Lands on moon";
        int author = 1;
        String contentUrl ="/news/man-lands-on/moon";
        GeneralNews newsItem = new GeneralNews(title,author,contentUrl);
        assertEquals("general",newsItem.getType());
    }
}
