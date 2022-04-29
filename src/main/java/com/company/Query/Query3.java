package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query3 {

    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();
            String newPublisher;
            stmt = JDBC.connection.createStatement();

            System.out.println("Добавьте нового издателя:");
            newPublisher = (new Scanner(System.in).nextLine());
            String query2publishers = "INSERT INTO publishers(publisherName) VALUES('" + newPublisher + "')";
            String query2publishers2 = "SELECT * FROM publishers where publisherName = '" + newPublisher + "'";




            //String query2publishers = "INSERT INTO Publishers VALUES (16, 'Simp2')";

            System.out.println("Добавлена новая запись в publishers:");
            stmt.executeUpdate(query2publishers);
            ResultSet rs = stmt.executeQuery(query2publishers2);
            String publisherID;
            String publisherName;
            while (rs.next()){
                publisherID = rs.getString("publisherID");
                publisherName = rs.getString("publisherName");
                System.out.println( "publisherID:\t" + publisherID);
                System.out.println( "publisherName:\t" + publisherName+ "\n");
            }


        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}