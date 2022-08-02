package models;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewsTest {

    @Test
    public void newsInstantiatesCorrectly(){
        News newsItem = new News("Raila Wins Elections",1);
        assertTrue(newsItem instanceof News);
    }




}
