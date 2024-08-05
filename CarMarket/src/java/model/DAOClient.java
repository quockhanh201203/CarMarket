/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Common.MD5;
import entity.Provider;
import entity.Client;
import entity.Feedback;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class DAOClient extends DBConnect {

    public int insertAccount(Client acc) {
        int id = 0;
        String sql = "INSERT INTO [dbo].[Client]\n"
                + "           ([firstName]\n"
                + "           ,[lastName]\n"
                + "           ,[email]\n"
                + "           ,[password]\n"
                + "           ,[phoneNumber]\n"
                + "           ,[address]\n"
                + "           ,[image]\n"
                + "           ,[status]\n"
                + "           ,[createDate])"
                + "		   OUTPUT inserted.id\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, acc.getFirstName());
            pre.setString(2, acc.getLastName());
            pre.setString(3, acc.getEmail());
            pre.setString(4, acc.getPassword());
            pre.setString(5, acc.getPhoneNumber());
            pre.setString(6, acc.getAddress());
            pre.setString(7, acc.getImage());
            pre.setBoolean(8, acc.isStatus());
            // Chuyển đổi java.util.Date sang java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(acc.getCreateDate().getTime());
            pre.setDate(9, sqlDate);

            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public Client getClientById(int id) {
        Client client = null;
        String sql = "SELECT [id], [firstName], [lastName], [email], [password], [phoneNumber], [address], [image], [status], [createDate] FROM [dbo].[Client] WHERE [id] = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);

            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                client = new Client();
                client.setClientId(rs.getInt("id"));
                client.setFirstName(rs.getString("firstName"));
                client.setLastName(rs.getString("lastName"));
                client.setEmail(rs.getString("email"));
                client.setPassword(rs.getString("password"));
                client.setPhoneNumber(rs.getString("phoneNumber"));
                client.setAddress(rs.getString("address"));
                client.setImage(rs.getString("image"));
                client.setStatus(rs.getBoolean("status"));
                client.setCreateDate(rs.getDate("createDate"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return client;
    }

    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Client validate(String email, String password) {
        String sql = "SELECT * FROM Client WHERE email = ? AND password = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Client(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("image"),
                        rs.getBoolean("status"),
                        rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Client validate2(String email) {
        String sql = "SELECT * FROM Client WHERE email = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Client(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("image"),
                        rs.getBoolean("status"),
                        rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Client getClientByEmail(String email) {
        String sql = "Select * from Client where email like N'%" + email + "%'";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String Email = rs.getString(4);
                String password = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String address = rs.getString(7);
                String image = rs.getString(8);
                boolean status = rs.getBoolean(9);
                Date createDate = rs.getDate(10);

                Client client = new Client(id, firstName, lastName, Email, password, phoneNumber, address, image, status, createDate);
                return client;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        return null;
    }

    public int activeAccount(String email) {
        int n = 0;
        String sql = "UPDATE [dbo].[Client]\n"
                + "   SET  [status] = 1"
                + " WHERE email = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }

    public void changePassword(int id, String pass) {
        String sql = " update [Client] set [password]=? where [id] =?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, new MD5().getMd5(pass));
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int updateAccount(Client client, int id) {
        int n = 0;
        String sql = "UPDATE [dbo].[Client] SET "
                + "[firstName] = ?, "
                + "[lastName] = ?, "
                + "[email] = ?, "
                + "[password] = ?, "
                + "[phoneNumber] = ?, "
                + "[address] = ?, "
                + "[image] = ?, "
                + "[status] = ?, "
                + "[createDate] = ? "
                + "WHERE id = ?";

        try (PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, client.getFirstName());
            pre.setString(2, client.getLastName());
            pre.setString(3, client.getEmail());
            pre.setString(4, client.getPassword());
            pre.setString(5, client.getPhoneNumber());
            pre.setString(6, client.getAddress());
            pre.setString(7, client.getImage());
            pre.setBoolean(8, client.isStatus());
            java.sql.Date sqlDate = new java.sql.Date(client.getCreateDate().getTime());
            pre.setDate(9, sqlDate);
            pre.setInt(10, id);

            // Execute the update query
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(); // Consider using a logging framework
        }
        return n;
    }

    public int insertFeedback(Feedback feedback) {
        int id = 0;
        String sql = "INSERT INTO Feedback (note, rank, createDate, userId) "
                + "OUTPUT inserted.ID "
                + "VALUES (?, ?, ?, ?)";

        try (
                PreparedStatement pre = conn.prepareStatement(sql)) {
            pre.setString(1, feedback.getNote());
            pre.setString(2, feedback.getRank());
            java.sql.Date sqlDate = new java.sql.Date(feedback.getCreateDate().getTime());
            pre.setDate(3, sqlDate);
            pre.setInt(4, feedback.getUserId());

            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return id;
    }

    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM Feedback";

        try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String note = rs.getString("note");
                String rank = rs.getString("rank");
                Date createDate = rs.getDate("createDate");
                int userId = rs.getInt("userId");

                Feedback feedback = new Feedback(id, note, rank, createDate, userId);
                feedbackList.add(feedback);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return feedbackList;
    }

    public static void main(String[] args) {
//        // Tạo đối tượng Client
//        Date currentDate = new Date();
//        Client newClient = new Client("Tuấn", "Nguyễn", "tuanduy043@gmail.com", "abc12345", "0383534096", "Thanh Xuan, Ha Noi", null, true, currentDate);
//        int idAcc = 4;
//        Client newClient = new Client("Tuan", "Nguyen", "tuan.nguyen@example.com", "0383534096", "Thanh Xuan, Ha Noi");
//        Account newAcc = new Account("tuanduy043@gmail.com", "123456789", 1, currentDate, true);
//        // Tạo đối tượng DAOAccount và gọi phương thức insertAccount
        DAOClient daoClient = new DAOClient();
//        int result = daoClient.insertAccount(newClient);
//       // int result = daoClient.insertAccount(newAcc);
//        int resultUser = daoClient.insertUser(newUser, idAcc);
//        if(resultUser > 0){
//            System.out.println("success");
//        }else{
//            System.out.println("fail");
//        }
        Client client = daoClient.validate("tuanduy043203@gmail.com", "dkmchobach2003");
//        int status = daoClient.activeAccount("tuanduy043@gmail.com");
//        // Kiểm tra kết quả
//        System.out.println(result);
//        Account acc = daoClient.getAccountByEmail("tuanduy043@gmail.com");
//        System.out.println(acc);
        //Client newClient = daoClient.getClientByEmail("tuanduy043@gmail.com");
        System.out.println(client);
    }

}
