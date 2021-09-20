package model;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

class RestaurantTest {

    @BeforeEach
    void setUp() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }
    //Started with getters first
    @org.junit.jupiter.api.Test
    public void test_getName_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertEquals("allan",restaurant.getName());
    }
    @org.junit.jupiter.api.Test
    public void test_getAddress_works_Correctly() throws Exception{
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090");
        assertEquals("Moiben",restaurant.getAddress());
    }
    @org.junit.jupiter.api.Test
    public void test_getZipcode_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090");
        assertEquals("Eldoret",restaurant.getZipcode());
    }
    @org.junit.jupiter.api.Test
    public void test_getPhone_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090");
        assertEquals("0711451090",restaurant.getPhone());
    }
    @org.junit.jupiter.api.Test
    public void test_getWebsite_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertEquals("www.kulamawe.com",restaurant.getWebsite());
    }
    @org.junit.jupiter.api.Test
    public void test_getEmail_works_Correct()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertEquals("allan@kulamawe.com",restaurant.getEmail());
    }
    //Setters tests
    @org.junit.jupiter.api.Test
    public void test_setName_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("esther",restaurant.getName());
    }
    @org.junit.jupiter.api.Test
    public void test_setAddess_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("Chuka",restaurant.getAddress());
    }
    @org.junit.jupiter.api.Test
    public void test_setZipcode_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("Timbuktu",restaurant.getZipcode());
    }
    @org.junit.jupiter.api.Test
    public void test_setPhone_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("0726832007",restaurant.getPhone());
    }
    @org.junit.jupiter.api.Test
    public void test_setWebsite_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("www,moringaschool.com",restaurant.getWebsite());
    }
    @org.junit.jupiter.api.Test
    public void test_setEmail_works_Correctly()throws Exception {
        Restaurant restaurant= new Restaurant("allan","Moiben","Eldoret","0711451090","www.kulamawe.com","allan@kulamawe.com");
        assertNotEquals("test@moringaschool.com",restaurant.getEmail());
    }





}