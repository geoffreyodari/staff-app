package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralNewsTest {
    @Test
    public void newsInstantiatesCorrectly(){
        GeneralNews newsItem = new GeneralNews("Raila Wins Elections","geoffrey");
        assertTrue(newsItem instanceof GeneralNews);
    }

    @Test
    public void getTitle_getsNewsTitle(){
        String title="Man Lands on moon";
        GeneralNews newsItem = new GeneralNews(title,"James");
        assertEquals(title,newsItem.getTitle());
    }

    @Test
    public void getAuthor_getsNewsAuthor(){
        String title="Man Lands on moon";
        String author = "Geoffrey";
        GeneralNews newsItem = new GeneralNews(title,author);
        assertEquals(author,newsItem.getAuthor());

    }
}
