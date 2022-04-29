package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query3_3 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            int selectID;
            String newName;
            showAllPublishers(stmt);
            System.out.println("Укажите ID издателя, имя которого желаете изменить:");
            selectID = (new Scanner(System.in).nextInt());
            System.out.println("Укажите новое имя:");
            newName = (new Scanner(System.in).nextLine());

            String query3 = "UPDATE publishers SET publisherName = '" + newName + "' where publisherID = " + selectID;
            stmt.executeUpdate(query3);
            showPublisher(stmt, selectID);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

    }

    public static void showAllPublishers(Statement stmt) throws SQLException {
        String query = "SELECT * FROM publishers";
        ResultSet rs = stmt.executeQuery(query);
        String publisherID;
        String publisherName;
        System.out.println("publisherID\t" + "publisherName");
        while (rs.next()) {
            publisherID = rs.getString("publisherID");
            publisherName = rs.getString("publisherName");
            System.out.println("\t" + publisherID + "\t" + "\t" + publisherName);
        }
    }

    public static void showPublisher(Statement stmt, int pubID) throws SQLException {
        String query3_1 = "SELECT * FROM publishers where publisherID = " + pubID;
        ResultSet rs = stmt.executeQuery(query3_1);
        String publisherID;
        String publisherName;
        while (rs.next()) {
            publisherID = rs.getString("publisherID");
            publisherName = rs.getString("publisherName");
            System.out.println("publisherID\t" + "publisherName");
            System.out.println("\t" + publisherID + "\t" + "\t" + publisherName);
        }
    }
}