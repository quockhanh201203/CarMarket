/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Common.MD5;
import entity.Brand;
import entity.Client;
import entity.Model;
import entity.Provider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DAOProvider extends DBConnect {

    public Provider getProviderByEmail(String email) {
        String sql = "Select * from Provider where email like N'%" + email + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt(1);
                String Email = rs.getString(2);
                String password = rs.getString(3);
                int role = rs.getInt(4);
                Date createDate = rs.getDate(5);
                boolean status = rs.getBoolean(6);
                Provider pro = new Provider(id, Email, password, role, createDate, status);
                return pro;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return null;
    }

    public void changePassword(int id, String pass) {
        String sql = " update [Provider] set [password]=? where [id] =?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, new MD5().getMd5(pass));
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Provider validate2(String email) {
        String sql = "SELECT * FROM Provider WHERE email = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Provider(rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getDate("createDate"),
                        rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Provider> getAllAccount() {
        String sql = "SELECT * FROM Provider";
        List<Provider> listProviders = new ArrayList<>();

        try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                listProviders.add(new Provider(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getDate("createDate"),
                        rs.getBoolean("status"))
                );
            }
        } catch (SQLException e) {
            // Log or re-throw the exception
            System.out.println(e.getMessage());
        }
        return listProviders;
    }

    public Provider login(String email, String password) {
        String sql = "SELECT * FROM Provider WHERE email = ? AND password = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Provider(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getInt("role"),
                        rs.getDate("createDate"),
                        rs.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Vector<Client> getAllClient() {
        String sql = "select * from [Client]";
        Vector<Client> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String address = rs.getString(7);
                String image = rs.getString(8);
                boolean status = rs.getBoolean(9);
                Date createDate = rs.getDate(10);
                Client client = new Client(id, firstName, lastName, email, password, phoneNumber, address, image, status, createDate);
                vector.add(client);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public Client getClientByID(int id) {
        String sql = "select * from Client where id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Client(
                        rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("image"),
                        rs.getBoolean("status"),
                        rs.getDate("createDate")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int statusClient(int id, boolean status) {
        int n = 0;
        String sql = "UPDATE [dbo].[Client]\n"
                + "   SET  [status] = ?"
                + " WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setBoolean(1, status);
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public int statusProvider(int id, boolean status) {
        int n = 0;
        String sql = "UPDATE [dbo].[Provider]\n"
                + "   SET  [status] = ?"
                + " WHERE id = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setBoolean(1, status);
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public int deleteClient(int id) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Client]\n"
                + "      WHERE id =" + id;
        try {
            Statement state = conn.createStatement();

            n = state.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteProvider(int id) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Provider]\n"
                + "      WHERE id =" + id;
        try {
            Statement state = conn.createStatement();

            n = state.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int insertBrands(Brand brand) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Brand]\n"
                + "           ([BrandName]\n"
                + "           ,[img])"
                + "		   OUTPUT inserted.BrandID\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, brand.getBrandName());
            pre.setString(2, brand.getBrandImg());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("BrandID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public Vector<Brand> getAllBrands() {
        String sql = "select * from [Brand]";
        Vector<Brand> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String BrandName = rs.getString(2);
                String BrandImg = rs.getString(3);
                Brand brand = new Brand(id, BrandName, BrandImg);
                vector.add(brand);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public int insertModel(Model model) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Model]\n"
                + "           ([ModelName]\n"
                + "           ,[img])"
                + "		   OUTPUT inserted.ModelID\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, model.getModelName());
            pre.setString(2, model.getModelImg());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ModelID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public Vector<Model> getAllModels() {
        String sql = "select * from [Model]";
        Vector<Model> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String ModelName = rs.getString(2);
                String ModelImg = rs.getString(3);
                Model model = new Model(id, ModelName, ModelImg);
                vector.add(model);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return vector;
    }

    public int insertProvider(Provider acc) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Provider]\n"
                + "           ([email]\n"
                + "           ,[password]\n"
                + "           ,[role]\n"
                + "           ,[createDate]\n"
                + "           ,[status])"
                + "		   OUTPUT inserted.id\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, acc.getEmail());
            pre.setString(2, acc.getPassword());
            pre.setInt(3, acc.getRole());
            
            // Chuyển đổi java.util.Date sang java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(acc.getCreateDate().getTime());
            pre.setDate(4, sqlDate);
            pre.setBoolean(5, acc.isStatus());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public static void main(String[] args) {
        DAOProvider dao = new DAOProvider();
        Client client = dao.getClientByID(1);
//        Vector<Brand> vector = dao.getAllBrands();
//        System.out.println(vector);
////        
////        Provider pro = dao.getProviderByEmail("tuan@gmail.com");
////        System.out.println(pro);
//        int n = dao.statusClient(6, true);
        //       int n = dao.deleteClient(7);
//
//        Brand brand = new Brand("Bentley", null);
//        int id = dao.insertBrands(brand);
//        System.out.println(id);
//      }
//        public static void main(String[] args) {
//        DAOProvider daoProvider = new DAOProvider();
//        
//        Model newModel = new Model();
//        newModel.setModelName("Test Model");
//        newModel.setModelImg("test_model.png");
//        
//        int generatedId = daoProvider.insertModel(newModel);
//        
//        if (generatedId > 0) {
//            System.out.println("Model inserted successfully with ID: " + generatedId);
//        } else {
//            System.out.println("Failed to insert model.");
//        }
    }
}
