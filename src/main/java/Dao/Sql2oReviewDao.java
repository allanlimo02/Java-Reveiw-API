package Dao;

import model.Restaurant;
import model.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oReviewDao implements ReviewDao{
    private final Sql2o sql2o;
    public Sql2oReviewDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Review review) {
        String sql = "INSERT INTO reviews (writtenby, content, rating, restaurantid) VALUES (:writtenBy, :content, :rating, :restaurantId)";
        try(Connection conn=sql2o.open()){
            int id=(int) conn.createQuery(sql,true)
                    .bind(review)
                    .executeUpdate()
                    .getKey();
            review.setId(id);
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
    // Method to collect all the reviews
    @Override
    public List<Review> getAll() {
        Connection conn=sql2o.open();
        return conn.createQuery("SELECT * FROM reviews")
                .executeAndFetch(Review.class);
    }

    @Override
    public List<Review> getAllReviewsByRestaurant(int restaurantId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM reviews WHERE restaurantId = :restaurantId")
                    .addParameter("restaurantId", restaurantId)
                    .executeAndFetch(Review.class);
        }
    }
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM reviews WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    //To delete all from the table
    @Override
    public void clearAll() {
        String sql="DELETE * FROM reviews";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql,true)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
