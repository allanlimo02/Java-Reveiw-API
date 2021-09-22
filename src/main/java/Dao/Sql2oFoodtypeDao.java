package Dao;

import model.Foodtype;
import model.Restaurant;
import model.Review;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oFoodtypeDao implements FoodtypeDao{
    private final Sql2o sql2o;

    public Sql2oFoodtypeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Foodtype foodtype) {
        String sql="INSERT INTO foodtypes(name) VALUES (:name)";
        try (Connection conn =sql2o.open()){
            int id=(int)conn.createQuery(sql,true)
                    .bind(foodtype)
                    .executeUpdate()
                    .getKey();
            foodtype.setId(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
//  Create many to many relationship
    @Override
    public void addFoodtypeToRestaurant(Foodtype foodtype, Restaurant restaurant) {

    }

    @Override
    public List<Foodtype> getAll() {
        Connection conn=sql2o.open();
        return conn.createQuery("SELECT * FROM foodtypes")
                .executeAndFetch(Foodtype.class);
    }

    @Override
    public List<Restaurant> getAllRestaurantsForAFoodtype(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM reviews WHERE foodtypes = :id")
                    .addParameter("id", id).executeAndFetch(Restaurant.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM foodtypes WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql="DELETE * FROM foodtypes";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql,true)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
