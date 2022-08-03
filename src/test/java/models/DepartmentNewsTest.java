package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentNewsTest {

        @Test
        public void newsInstantiatesCorrectly(){
            String title="Man Lands on moon";
            int author =1;
            String contentUrl = "/news/man-lands-on-moon";
            int department=2;
            DepartmentNews newsItem = new DepartmentNews(title,author,contentUrl,department);
            assertTrue(newsItem instanceof DepartmentNews);
        }

        @Test
        public void getTitle_getsNewsTitle(){
            String title="Man Lands on moon";
            int author =1;
            String contentUrl = "/news/man-lands-on-moon";
            int department=2;
            DepartmentNews newsItem = new DepartmentNews(title,author,contentUrl,department);
            assertEquals(title,newsItem.getTitle());
        }

        @Test
        public void getAuthor_getsNewsAuthor(){
            String title="Man Lands on moon";
            int author =1;
            String contentUrl = "/news/man-lands-on-moon";
            int department=2;
            DepartmentNews newsItem = new DepartmentNews(title,author,contentUrl,department);
            assertEquals(author,newsItem.getAuthor());

        }

        @Test
        public void getContentUrl_getsNewsContentLink(){
            String title="Man Lands on moon";
            int author =1;
            String contentUrl = "/news/man-lands-on-moon";
            int department=2;
            DepartmentNews newsItem = new DepartmentNews(title,author,contentUrl,department);
            assertEquals(contentUrl,newsItem.getContentUrl());

        }

    @Test
    public void getDepartmentId_getsDepartmentId(){
        String title="Man Lands on moon";
        int author =1;
        String contentUrl = "/news/man-lands-on-moon";
        int department=2;
        DepartmentNews newsItem = new DepartmentNews(title,author,contentUrl,department);
        assertEquals(department,newsItem.getDepartment());

    }

}
