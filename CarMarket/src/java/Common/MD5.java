/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            //BigInteger từ mảng byte. Constructor này có hai tham số:
            //signum: Dấu của số (+1, 0, hoặc -1). Ở đây, 1 có nghĩa là số dương.
            //magnitude: Mảng byte đại diện cho giá trị tuyệt đối của số.
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            //(16 byte), và mỗi byte được biểu diễn bằng hai ký tự thập lục phân
            //chuỗi băm luôn có độ dài 32 ký tự
            //MD5 tạo ra một giá trị 16 byte
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MD5 md = new MD5();
        String result = md.getMd5("dkmchobach2003");
        System.out.println(result);
    }
}



