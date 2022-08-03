package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentNewsTest {

        @Test
        public void newsInstantiatesCorrectly(){
            DepartmentNews newsItem = new DepartmentNews("Raila Wins Elections","geoffrey",1);
            assertTrue(newsItem instanceof DepartmentNews);
        }

        @Test
        public void getTitle_getsNewsTitle(){
            String title="Man Lands on moon";
            DepartmentNews newsItem = new DepartmentNews(title,"James",1);
            assertEquals(title,newsItem.getTitle());
        }

        @Test
        public void getAuthor_getsNewsAuthor(){
            String title="Man Lands on moon";
            String author = "Geoffrey";
            DepartmentNews newsItem = new DepartmentNews(title,author,1);
            assertEquals(author,newsItem.getAuthor());

        }
}
