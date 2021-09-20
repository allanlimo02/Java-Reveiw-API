package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getContent() {
        Review review = new Review("Good","Allan",5,3);
        assertEquals("Good",review.getContent());
    }

    @Test
    void setContent() {
        Review review = new Review("Good","Allan",5,3);
        assertNotEquals("Awesome",review.getContent());
    }

    @Test
    void getWrittenBy() {
        Review review = new Review("Good","Allan",5,3);
        assertEquals("Allan",review.getWrittenBy());
    }

    @Test
    void setWrittenBy() {
        Review review = new Review("Good","Allan",5,3);
        assertNotEquals("Grace",review.getWrittenBy());
    }

    @Test
    void getRating() {
        Review review = new Review("Good","Allan",5,3);
        assertEquals(5,review.getRating());
    }

    @Test
    void setRating() {
        Review review = new Review("Good","Allan",5,3);
        assertNotEquals(6,review.getRating());
    }

    @Test
    void getRestaurantId() {
        Review review = new Review("Good","Allan",5,3);
        assertEquals(3,review.getRestaurantId());
    }

    @Test
    void setRestaurantId() {
        Review review = new Review("Good","Allan",5,3);
        assertNotEquals(6,review.getRestaurantId());
    }
}