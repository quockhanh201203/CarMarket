/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package entity;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author admin
 */
public class email {

    /**
     * Admin mail Email: devteamk17@gmail.com Pass: dazz yesl nwgx utrg
     */
    public String sendVerificaionOTPUsingEmail(String to) {
        final String from = "devteamk17@gmail.com";
        final String password = "dazz yesl nwgx utrg";

        // Initialize properties
        //Khởi tạo và thiết lập các thuộc tính cho phiên gửi email, như tên host SMTP, cổng, xác thực và TLS.
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP host
        props.put("mail.smtp.port", "587"); // TLS: 587
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // create Authenticator
        //Authenticator cung cấp một cơ chế cho ứng dụng để xác thực với máy chủ email trước khi gửi hoặc nhận email.
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Work space
        //Khởi tạo một phiên làm việc email (Session) với các thuộc tính và bộ xác thực đã thiết lập.
        Session session = Session.getInstance(props, auth);

        // Create message
        //Tạo một đối tượng MimeMessage để đại diện cho email. Thiết lập các thuộc tính như header, người gửi, người nhận, chủ đề và ngày gửi.
        MimeMessage msg = new MimeMessage(session);
        try {
            // Content type
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            // Sender
            msg.setFrom(from);
            // Receiver
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // Email title
            msg.setSubject("Send verification OTP to ".concat(to));
            // Set send date: 
            msg.setSentDate(new Date());
            /**
             * Set receive-reply email:
             * msg.setReplyTo(InternetAddress.parse(from, false)); Send HTML
             * content: msg.setContent("<html></html>", "text/html");
             */
            //Tạo mã OTP ngẫu nhiên trong khoảng từ 100000 đến 999999 và thiết lập nội dung email là mã OTP này.
            Random rand = new Random();
            int randomOTP = rand.nextInt(999999 - 100000 + 1) + 100000;
            String OTPText = Integer.toString(randomOTP);
            // Content
            msg.setText("Your OTP is ".concat(OTPText));
            // Send mail
            Transport.send(msg);
            return OTPText;
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
     public void send(String to, String sub,
            String msg) {
        final String from = "devteamk17@gmail.com";
        final String password = "dazz yesl nwgx utrg";

        // Initialize properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP host
        props.put("mail.smtp.port", "587"); // TLS: 587
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        email mail = new email();
        String veriOTP = mail.sendVerificaionOTPUsingEmail("tuanduy043203@gmail.com");
        System.out.println(veriOTP);
    }

}
