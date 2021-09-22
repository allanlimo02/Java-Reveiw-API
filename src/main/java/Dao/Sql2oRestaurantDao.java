package Dao;

import model.Foodtype;
import model.Restaurant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oRestaurantDao implements RestaurantDao{
   // Create a sql20 variable thats visible for this class
    private final Sql2o sql2o;
    public Sql2oRestaurantDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Restaurant restaurant) {
        String sql = "ADD INTO restaurants (name,address,zipcode,phone,website,email) VALUES (:name,:address,:zipcode,:phone,:website,:email)";
        try ( Connection conn=sql2o.open();){
            int id=(int)conn.createQuery(sql,true)
                    .bind(restaurant)
                    .executeUpdate()
                    .getKey();
            restaurant.setId(id);
            }catch(Exception ex){
            System.out.println(ex);
        }
    }

    // Creating many-to-many relationship
    @Override
    public void addRestaurantToFoodType(Restaurant restaurant, Foodtype foodtype) {

    }

    //return all the restaurants
    @Override
    public List<Restaurant> getAll() {
        Connection conn=sql2o.open();
        return conn.createQuery("SELECT * FROM restaurants")
                .executeAndFetch(Restaurant.class);
    }
    //finding by Restaurant ID
    @Override
    public Restaurant findById(int id) {
        String sql = "SELECT FROM restaurants WHERE id=:id";
        return null;

    }

    @Override
    public void update(int id, String name, String address, String zipcode, String phone, String website, String email) {


    }
    //delete restaurant by Id
    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM restaurants WHERE id=:id";
        try(Connection conn=sql2o.open();)
        {conn.createQuery(sql,true)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void clearAll() {
        String sql="DELETE * FROM restaurants";
        try(Connection conn=sql2o.open();){
            conn.createQuery(sql,true)
                    .executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
