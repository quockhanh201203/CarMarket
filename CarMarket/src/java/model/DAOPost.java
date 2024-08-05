/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.sun.jdi.connect.spi.Connection;
import entity.Brand;
import entity.Car;
import entity.CarImage;
import entity.Model;
import entity.Origin;
import entity.Post;
import entity.engine;
import entity.exteriorColor;
import entity.gearbox;
import entity.interiorColor;
import entity.numberOfDoors;
import entity.numberOfSeats;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAOPost extends DBConnect {

    public int insertCar(Car car) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Car]\n"
                + "           ([brandId]\n"
                + "           ,[modelId]\n"
                + "            ,[userId])"
                + "		   OUTPUT inserted.id\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, car.getBrandId());
            pre.setInt(2, car.getModelId());
            pre.setInt(3, car.getUserId());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public boolean deleteCar(int carId) {
        String sql = "DELETE FROM [dbo].[Car] WHERE id = ?";
        boolean isDeleted = false;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, carId);
            int affectedRows = pre.executeUpdate();

            // If affectedRows is greater than 0, it means the car was successfully deleted
            if (affectedRows > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return isDeleted;
    }

    public Vector<engine> getAllEngine() {
        String sql = "select * from [engine]";
        Vector<engine> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int EngineId = rs.getInt(1);
                String EngineName = rs.getString(2);
                engine engine = new engine(EngineId, EngineName);
                vector.add(engine);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<gearbox> getAllGearbox() {
        String sql = "select * from [gearbox]";
        Vector<gearbox> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int GearboxId = rs.getInt(1);
                String GearboxName = rs.getString(2);
                gearbox gearbox = new gearbox(GearboxId, GearboxName);
                vector.add(gearbox);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<numberOfSeats> getAllSeat() {
        String sql = "select * from [numberOfSeats]";
        Vector<numberOfSeats> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int NumberOfSeatsId = rs.getInt(1);
                String NumberOfSeatsName = rs.getString(2);
                numberOfSeats seat = new numberOfSeats(NumberOfSeatsId, NumberOfSeatsName);
                vector.add(seat);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<Origin> getAllOrigin() {
        String sql = "select * from [origin]";
        Vector<Origin> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int originId = rs.getInt(1);
                String originName = rs.getString(2);
                Origin origin = new Origin(originId, originName);
                vector.add(origin);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<exteriorColor> getAllExteriorColor() {
        String sql = "select * from [exteriorColor]";
        Vector<exteriorColor> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int exteriorColorId = rs.getInt(1);
                String exteriorColorName = rs.getString(2);
                exteriorColor color = new exteriorColor(exteriorColorId, exteriorColorName);
                vector.add(color);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<numberOfDoors> getAllDoor() {
        String sql = "select * from [numberOfDoors]";
        Vector<numberOfDoors> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int NumberOfDoorsId = rs.getInt(1);
                String NumberOfDoorsName = rs.getString(2);
                numberOfDoors door = new numberOfDoors(NumberOfDoorsId, NumberOfDoorsName);
                vector.add(door);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<interiorColor> getAllInteriorColor() {
        String sql = "select * from [interiorColor]";
        Vector<interiorColor> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int interiorColorId = rs.getInt(1);
                String interiorColorName = rs.getString(2);
                interiorColor color = new interiorColor(interiorColorId, interiorColorName);
                vector.add(color);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public int insertPost(Post post) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Post]\n"
                + "           ([userId]\n"
                + "           ,[carId]\n"
                + "           ,[carName]\n"
                + "           ,[originId]\n"
                + "           ,[gearboxId]\n"
                + "           ,[engineId]\n"
                + "           ,[interiorColorId]\n"
                + "           ,[exteriorColorId]\n"
                + "           ,[numberOfSeatsId]\n"
                + "           ,[numberOfDoorsId]\n"
                + "           ,[priceCar]\n"
                + "           ,[postDate]\n"
                + "           ,[status]\n"
                + "           ,[descriptions]\n"
                + "           ,[Year])"
                + "		   OUTPUT inserted.id\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, post.getUserId());
            pre.setInt(2, post.getCarId());
            pre.setString(3, post.getCarName());
            pre.setInt(4, post.getOriginId());
            pre.setInt(5, post.getGearboxId());
            pre.setInt(6, post.getEngineId());
            pre.setInt(7, post.getInteriorColorId());
            pre.setInt(8, post.getExteriorColorId());
            pre.setInt(9, post.getNumberOfSeatsId());
            pre.setInt(10, post.getNumberOfDoorsId());
            pre.setFloat(11, post.getPriceCar());
            java.sql.Date sqlDate = new java.sql.Date(post.getPostDate().getTime());
            pre.setDate(12, sqlDate);
            pre.setBoolean(13, post.isStatus());
            pre.setString(14, post.getDescriptions());
            pre.setInt(15, post.getYear());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public boolean deletePost(int postId) {
        String sql = "DELETE FROM [dbo].[Post] WHERE id = ?";
        boolean isDeleted = false;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, postId);
            int affectedRows = pre.executeUpdate();

            // If affectedRows is greater than 0, it means the post was successfully deleted
            if (affectedRows > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return isDeleted;
    }

    public int insertImg(CarImage img) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[carImage]\n"
                + "           ([postId]\n"
                + "            ,[postImg])"
                + "		   OUTPUT inserted.ImageID\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, img.getPostId());
            pre.setString(2, img.getPostImg());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ImageID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public Vector<Post> getAllPost() {
        String sql = "select * from [Post]";
        Vector<Post> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("id"));
                post.setUserId(rs.getInt("userId"));
                post.setCarId(rs.getInt("carId"));
                post.setCarName(rs.getString("carName"));
                post.setOriginId(rs.getInt("originId"));
                post.setGearboxId(rs.getInt("gearboxId"));
                post.setEngineId(rs.getInt("engineId"));
                post.setInteriorColorId(rs.getInt("interiorColorId"));
                post.setExteriorColorId(rs.getInt("exteriorColorId"));
                post.setNumberOfSeatsId(rs.getInt("numberOfSeatsId"));
                post.setNumberOfDoorsId(rs.getInt("numberOfDoorsId"));
                post.setPriceCar(rs.getFloat("priceCar"));
                post.setPostDate(rs.getDate("postDate"));
                post.setStatus(rs.getBoolean("status"));
                post.setDescriptions(rs.getString("descriptions"));
                post.setYear(rs.getInt("year"));

                // Fetch images for the post
                List<CarImage> images = getImageByPostId(post.getPostId());
                post.setImages(images);

                vector.add(post);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public engine getEngineById(int id) {
        String sql = "select * from [engine] where EngineID = ?";
        engine resultEngine = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int EngineId = rs.getInt("EngineID");
                String EngineName = rs.getString("EngineName");
                resultEngine = new engine(EngineId, EngineName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultEngine;
    }

    public gearbox getGearboxById(int id) {
        String sql = "select * from [gearbox] where GearboxID = ?";
        gearbox resultGearbox = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int GearboxId = rs.getInt("GearboxID");
                String GearboxName = rs.getString("GearboxName");
                resultGearbox = new gearbox(GearboxId, GearboxName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultGearbox;
    }

    public numberOfSeats getSeatById(int id) {
        String sql = "select * from [numberOfSeats] where NumberOfSeatsID = ?";
        numberOfSeats resultSeat = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int NumberOfSeatsId = rs.getInt("NumberOfSeatsID");
                String NumberOfSeatsName = rs.getString("NumberOfSeatsName");
                resultSeat = new numberOfSeats(NumberOfSeatsId, NumberOfSeatsName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultSeat;
    }

    public exteriorColor getExteriorColorById(int id) {
        String sql = "select * from [exteriorColor] where ExteriorColorID = ?";
        exteriorColor resultColor = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int exteriorColorId = rs.getInt("ExteriorColorID");
                String exteriorColorName = rs.getString("ExteriorColorName");
                resultColor = new exteriorColor(exteriorColorId, exteriorColorName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultColor;
    }

    public Origin getOriginById(int id) {
        String sql = "select * from [origin] where OriginID = ?";
        Origin resultOrigin = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int originId = rs.getInt("OriginID");
                String originName = rs.getString("OriginName");
                resultOrigin = new Origin(originId, originName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultOrigin;
    }

    public numberOfDoors getDoorById(int id) {
        String sql = "select * from [numberOfDoors] where NumberOfDoorsID = ?";
        numberOfDoors resultDoor = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int NumberOfDoorsId = rs.getInt("NumberOfDoorsID");
                String NumberOfDoorsName = rs.getString("NumberOfDoorsName");
                resultDoor = new numberOfDoors(NumberOfDoorsId, NumberOfDoorsName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultDoor;
    }

    public interiorColor getInteriorColorById(int id) {
        String sql = "select * from [interiorColor] where InteriorColorID = ?";
        interiorColor resultColor = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int interiorColorId = rs.getInt("InteriorColorID");
                String interiorColorName = rs.getString("InteriorColorName");
                resultColor = new interiorColor(interiorColorId, interiorColorName);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultColor;
    }

    public List<CarImage> getImageByPostId(int postId) {
        List<CarImage> images = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[carImage] WHERE postId = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, postId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int imageId = rs.getInt("ImageID");
                String postImg = rs.getString("postImg");
                // Create CarImage object
                CarImage image = new CarImage(imageId, postId, postImg);
                images.add(image);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return images;
    }

    public boolean deleteImageByPostId(int postId) {
        String sql = "DELETE FROM [dbo].[carImage] WHERE postId = ?";
        boolean isDeleted = false;

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, postId);
            int affectedRows = pre.executeUpdate();

            // If affectedRows is greater than 0, it means images were successfully deleted
            if (affectedRows > 0) {
                isDeleted = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return isDeleted;
    }

    public void deleteImageByImageId(int imageId) {
        String sql = "DELETE FROM [dbo].[carImage] WHERE ImageID = ?";
        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setInt(1, imageId);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Car getCarById(int id) {
        Car car = null;
        String sql = "SELECT * FROM [dbo].[Car] WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int brandId = rs.getInt("brandId");
                int modelId = rs.getInt("modelId");
                int userId = rs.getInt("userId");
                // Create Car object
                car = new Car(id, brandId, modelId, userId);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return car;
    }

    public Brand getBrandById(int id) {
        Brand brand = null;
        String sql = "SELECT * FROM [Brand] WHERE BrandID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                String brandName = rs.getString("BrandName");
                String brandImg = rs.getString("img");
                // Create Brand object
                brand = new Brand(id, brandName, brandImg);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return brand;
    }

    public Model getModelById(int id) {
        Model model = null;
        String sql = "SELECT * FROM [Model] WHERE ModelID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                String modelName = rs.getString("ModelName");
                String modelImg = rs.getString("img");
                // Create Model object
                model = new Model(id, modelName, modelImg);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return model;
    }

    public Post getPostById(int postId) {
        String sql = "SELECT * FROM [Post] WHERE id = ?";
        Post post = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int PostId = rs.getInt(1);
                int userId = rs.getInt(2);
                int carId = rs.getInt(3);
                String carName = rs.getString(4);
                int originId = rs.getInt(5);
                int gearboxId = rs.getInt(6);
                int engineId = rs.getInt(7);
                int interiorColorId = rs.getInt(8);
                int exteriorColorId = rs.getInt(9);
                int numberOfSeatsId = rs.getInt(10);
                int numberOfDoorsId = rs.getInt(11);
                float priceCar = rs.getFloat(12);
                Date postDate = rs.getDate(13);
                Boolean status = rs.getBoolean(14);
                String description = rs.getString(15);
                int year = rs.getInt(16);
                List<CarImage> images = getImageByPostId(PostId);
                post = new Post(PostId, userId, carId, carName, originId, gearboxId, engineId, interiorColorId, exteriorColorId, numberOfSeatsId, numberOfDoorsId, priceCar, postDate, status, description, year);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return post;
    }

    public List<Post> getPostsSortedByDate() {
        String sql = "SELECT * FROM [Post] ORDER BY postDate DESC";
        List<Post> posts = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("id"));
                post.setUserId(rs.getInt("userId"));
                post.setCarId(rs.getInt("carId"));
                post.setCarName(rs.getString("carName"));
                post.setOriginId(rs.getInt("originId"));
                post.setGearboxId(rs.getInt("gearboxId"));
                post.setEngineId(rs.getInt("engineId"));
                post.setInteriorColorId(rs.getInt("interiorColorId"));
                post.setExteriorColorId(rs.getInt("exteriorColorId"));
                post.setNumberOfSeatsId(rs.getInt("numberOfSeatsId"));
                post.setNumberOfDoorsId(rs.getInt("numberOfDoorsId"));
                post.setPriceCar(rs.getFloat("priceCar"));
                post.setPostDate(rs.getDate("postDate"));
                post.setStatus(rs.getBoolean("status"));
                post.setDescriptions(rs.getString("descriptions"));
                post.setYear(rs.getInt("year"));

                // Fetch images for the post
                List<CarImage> images = getImageByPostId(post.getPostId());
                post.setImages(images);

                posts.add(post);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return posts;
    }

    public void updatePostStatus(int postId, boolean newStatus) {
        String sql = "UPDATE [Post] SET status = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, newStatus);
            ps.setInt(2, postId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Post> searchPost(String year, String engine, String color, String gearbox, String origin, String price) {
        List<Post> posts = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Post WHERE 1=1");

        if (year != null && !year.isEmpty()) {
            sql.append(" AND Year = ?");
        }
        if (engine != null && !engine.isEmpty()) {
            sql.append(" AND engineId = ?");
        }
        if (color != null && !color.isEmpty()) {
            sql.append(" AND exteriorColorId = ?");
        }
        if (gearbox != null && !gearbox.isEmpty()) {
            sql.append(" AND gearboxId = ?");
        }
        if (origin != null && !origin.isEmpty()) {
            sql.append(" AND originId = ?");
        }
        if (price != null && !price.isEmpty() && !price.equals("default")) {
            sql.append(" AND priceCar BETWEEN ? AND ?");
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
            int paramIndex = 1;

            if (year != null && !year.isEmpty()) {
                stmt.setString(paramIndex++, year);
            }
            if (engine != null && !engine.isEmpty()) {
                stmt.setString(paramIndex++, engine);
            }
            if (color != null && !color.isEmpty()) {
                stmt.setString(paramIndex++, color);
            }
            if (gearbox != null && !gearbox.isEmpty()) {
                stmt.setInt(paramIndex++, Integer.parseInt(gearbox));
            }
            if (origin != null && !origin.isEmpty()) {
                stmt.setInt(paramIndex++, Integer.parseInt(origin));
            }
            if (price != null && !price.isEmpty() && !price.equals("default")) {
                String[] priceRange = price.split("-");
                stmt.setFloat(paramIndex++, Float.parseFloat(priceRange[0]));
                stmt.setFloat(paramIndex++, Float.parseFloat(priceRange[1]));
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("id"));
                post.setUserId(rs.getInt("userId"));
                post.setCarId(rs.getInt("carId"));
                post.setCarName(rs.getString("carName"));
                post.setOriginId(rs.getInt("originId"));
                post.setGearboxId(rs.getInt("gearboxId"));
                post.setEngineId(rs.getInt("engineId"));
                post.setInteriorColorId(rs.getInt("interiorColorId"));
                post.setExteriorColorId(rs.getInt("exteriorColorId"));
                post.setNumberOfSeatsId(rs.getInt("numberOfSeatsId"));
                post.setNumberOfDoorsId(rs.getInt("numberOfDoorsId"));
                post.setPriceCar(rs.getFloat("priceCar"));
                post.setPostDate(rs.getDate("postDate"));
                post.setStatus(rs.getBoolean("status"));
                post.setDescriptions(rs.getString("descriptions"));
                post.setYear(rs.getInt("year"));

                // Fetch images for the post
                List<CarImage> images = getImageByPostId(post.getPostId());
                post.setImages(images);

                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    public Vector<Post> getPostByClientID(int clientId) {
        String sql = "SELECT * FROM [Post] WHERE userId = ?";
        Vector<Post> vector = new Vector<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int postId = rs.getInt("id");
                int userId = rs.getInt("userId");
                int carId = rs.getInt("carId");
                String carName = rs.getString("carName");
                int originId = rs.getInt("originId");
                int gearboxId = rs.getInt("gearboxId");
                int engineId = rs.getInt("engineId");
                int interiorColorId = rs.getInt("interiorColorId");
                int exteriorColorId = rs.getInt("exteriorColorId");
                int numberOfSeatsId = rs.getInt("numberOfSeatsId");
                int numberOfDoorsId = rs.getInt("numberOfDoorsId");
                float priceCar = rs.getFloat("priceCar");
                Date postDate = rs.getDate("postDate");
                boolean status = rs.getBoolean("status");
                String description = rs.getString("descriptions");
                int year = rs.getInt("year");
                Post post = new Post(postId, userId, carId, carName, originId, gearboxId, engineId, interiorColorId, exteriorColorId, numberOfSeatsId, numberOfDoorsId, priceCar, postDate, status, description, year);
                vector.add(post);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Vector<Post> getPostByBrand(int brandId) {
        String sql = "SELECT p.* FROM Post p "
                + "JOIN Car c ON p.carId = c.id "
                + "WHERE c.brandId = ?";
        Vector<Post> vector = new Vector<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, brandId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("id"));
                post.setUserId(rs.getInt("userId"));
                post.setCarId(rs.getInt("carId"));
                post.setCarName(rs.getString("carName"));
                post.setOriginId(rs.getInt("originId"));
                post.setGearboxId(rs.getInt("gearboxId"));
                post.setEngineId(rs.getInt("engineId"));
                post.setInteriorColorId(rs.getInt("interiorColorId"));
                post.setExteriorColorId(rs.getInt("exteriorColorId"));
                post.setNumberOfSeatsId(rs.getInt("numberOfSeatsId"));
                post.setNumberOfDoorsId(rs.getInt("numberOfDoorsId"));
                post.setPriceCar(rs.getFloat("priceCar"));
                post.setPostDate(rs.getDate("postDate"));
                post.setStatus(rs.getBoolean("status"));
                post.setDescriptions(rs.getString("descriptions"));
                post.setYear(rs.getInt("year"));

                // Fetch images for the post
                List<CarImage> images = getImageByPostId(post.getPostId());
                post.setImages(images);

                vector.add(post);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Post> getPostByModel(int modelId) {
        String sql = "SELECT p.* FROM Post p "
                + "JOIN Car c ON p.carId = c.id "
                + "WHERE c.modelId = ?";
        Vector<Post> vector = new Vector<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, modelId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setPostId(rs.getInt("id"));
                post.setUserId(rs.getInt("userId"));
                post.setCarId(rs.getInt("carId"));
                post.setCarName(rs.getString("carName"));
                post.setOriginId(rs.getInt("originId"));
                post.setGearboxId(rs.getInt("gearboxId"));
                post.setEngineId(rs.getInt("engineId"));
                post.setInteriorColorId(rs.getInt("interiorColorId"));
                post.setExteriorColorId(rs.getInt("exteriorColorId"));
                post.setNumberOfSeatsId(rs.getInt("numberOfSeatsId"));
                post.setNumberOfDoorsId(rs.getInt("numberOfDoorsId"));
                post.setPriceCar(rs.getFloat("priceCar"));
                post.setPostDate(rs.getDate("postDate"));
                post.setStatus(rs.getBoolean("status"));
                post.setDescriptions(rs.getString("descriptions"));
                post.setYear(rs.getInt("year"));

                // Fetch images for the post
                List<CarImage> images = getImageByPostId(post.getPostId());
                post.setImages(images);

                vector.add(post);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public boolean updateCar(Car car) {
        boolean success = false;
        String sql = "UPDATE [dbo].[Car]\n"
                + "SET brandId = ?,\n"
                + "    modelId = ?,\n"
                + "    userId = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, car.getBrandId());
            pre.setInt(2, car.getModelId());
            pre.setInt(3, car.getUserId());
            pre.setInt(4, car.getCarId()); // assuming the Car object has an getId() method to get the car's ID

            int rowsAffected = pre.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return success;
    }

    public boolean updatePostByID(Post post) {
        String sql = "UPDATE [Post] SET userId = ?, carId = ?, carName = ?, originId = ?, gearboxId = ?, engineId = ?, interiorColorId = ?, exteriorColorId = ?, numberOfSeatsId = ?, numberOfDoorsId = ?, priceCar = ?, postDate = ?, status = ?, descriptions = ?, Year = ? WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, post.getUserId());
            ps.setInt(2, post.getCarId());
            ps.setString(3, post.getCarName());
            ps.setInt(4, post.getOriginId());
            ps.setInt(5, post.getGearboxId());
            ps.setInt(6, post.getEngineId());
            ps.setInt(7, post.getInteriorColorId());
            ps.setInt(8, post.getExteriorColorId());
            ps.setInt(9, post.getNumberOfSeatsId());
            ps.setInt(10, post.getNumberOfDoorsId());
            ps.setFloat(11, post.getPriceCar());
            ps.setDate(12, new java.sql.Date(post.getPostDate().getTime()));
            ps.setBoolean(13, post.isStatus());
            ps.setString(14, post.getDescriptions());
            ps.setInt(15, post.getYear());
            ps.setInt(16, post.getPostId());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static void main(String[] args) {
        DAOPost dao = new DAOPost();
        //       dao.updatePostStatus(7, true);
//        numberOfSeats seats = dao.getSeatById(3);
//        System.out.println(seats);
//        Vector<Origin> result = dao.getAllOrigin();
//        System.out.println(result);
//        Date currentDate = new Date();
//        Post post = new Post(2, 8, "CX5", 3, 3, 1, 1, 1, 1, 3, 200000000, currentDate, true, "New", 2021);
//        int result = dao.insertPost(post);
//        if (result > 0) {
//            System.out.println("success");
//        }
//
//        List<Post> posts = dao.searchPost("", "", "", "", "", "1000000000-2000000000");
//
//        for (Post post : posts) {
//            System.out.println("Post ID: " + post.getPostId());
//            System.out.println("Car Name: " + post.getCarName());
//            System.out.println("Year: " + post.getYear());
//            System.out.println("Engine ID: " + post.getEngineId());
//            System.out.println("Exterior Color ID: " + post.getExteriorColorId());
//            System.out.println("Gearbox ID: " + post.getGearboxId());
//            System.out.println("Price: " + post.getPriceCar());
//            System.out.println("Status: " + post.isStatus());
//            System.out.println("Description: " + post.getDescriptions());
//            System.out.println("------------------------------");
//        }
    }
}
