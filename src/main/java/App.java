import Dao.Sql2oFoodtypeDao;
import Dao.Sql2oRestaurantDao;
import Dao.Sql2oReviewDao;
import model.Foodtype;
import model.Restaurant;
import model.Review;
import org.sql2o.Connection;
import com.google.gson.Gson;
import org.sql2o.Sql2o;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oFoodtypeDao foodtypeDao;
        Sql2oRestaurantDao restaurantDao;
        Sql2oReviewDao reviewDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/jadle.db;INIT=RUNSCRIPT from 'classpath:Db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        restaurantDao = new Sql2oRestaurantDao(sql2o);
        foodtypeDao = new Sql2oFoodtypeDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();
        //***************** Restaurant route********************************
        post("/restaurants/new", "application/json", (req, res) -> {
            Restaurant restaurant = gson.fromJson(req.body(), Restaurant.class);
            restaurantDao.add(restaurant);
            res.status(201);;
            return gson.toJson(restaurant);
        });

        //READ Restaurant
        get("/restaurants", "application/json", (req, res) -> {
            return gson.toJson(restaurantDao.getAll());
        });

        // Get Restaurant by ID

        get("/restaurants/:id", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("id"));
            return gson.toJson(restaurantDao.findById(restaurantId));
        });

        //**************************8 FOODTYPE ROUTE***********************88
        //creating a new foodtype route

        post("/foodtype/new", "application/json", (req, res) -> {
            Foodtype foodtype = gson.fromJson(req.body(), Foodtype.class);
            foodtypeDao.add(foodtype);
            res.status(201);;
            return gson.toJson(foodtype);
        });

        //Read Foodtypes

        get("/foodtype", "application/json", (req, res) -> {
            return gson.toJson(foodtypeDao.getAll());
        });

        //Reviews per restaurantId
        post("/restaurants/:restaurantId/reviews/new", "application/json", (req, res) -> {
            int restaurantId = Integer.parseInt(req.params("restaurantId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setRestaurantId(restaurantId); //we need to set this separately because it comes from our route, not our JSON input.
            reviewDao.add(review);
            res.status(201);
            return gson.toJson(review);
        });


        //FILTERS Common file
        after((req, res) ->{
            res.type("application/json");
        });

    }



    }

