package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query6 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            int selectID;
            String newFirstName;
            String newLastName;
            showAllAuthors(stmt);

            System.out.println("Укажите ID автора, имя которого желаете изменить:");
            selectID = (new Scanner(System.in).nextInt());
            System.out.println("Укажите новое имя:");
            newFirstName = (new Scanner(System.in).nextLine());
            System.out.println("Укажите новую фамилию:");
            newLastName = (new Scanner(System.in).nextLine());

            String query = "UPDATE authors SET firstName = '" + newFirstName + "' where authorID = " + selectID;
            stmt.executeUpdate(query);
            query = "UPDATE authors SET lastName = '" + newLastName + "' where authorID = " + selectID;
            stmt.executeUpdate(query);
            showAuthor(stmt, selectID);
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

    }

    public static void showAllAuthors(Statement stmt) throws SQLException {
        String query = "SELECT * FROM authors";
        ResultSet rs = stmt.executeQuery(query);
        String authorID;
        String firstNAme;
        String lastName;
        System.out.println("authorID\t" + "firstNAme\t" + "lastName");
        while (rs.next()) {
            authorID = rs.getString("authorID");
            firstNAme = rs.getString("firstNAme");
            lastName = rs.getString("lastName");
            System.out.println("\t" + authorID + "\t" + firstNAme + "\t\t" + lastName);
        }
    }

    public static void showAuthor(Statement stmt, int autID) throws SQLException {
        String query3_1 = "SELECT * FROM authors where authorID = " + autID;
        ResultSet rs = stmt.executeQuery(query3_1);
        String firstNAme;
        String lastName;
        System.out.println("Новые данные автора с ID: \""+autID +"\"");
        while (rs.next()) {
            firstNAme = rs.getString("firstNAme");
            lastName = rs.getString("lastName");
            System.out.println("firstNAme\t" + "lastName");
            System.out.println("\t" + firstNAme + "\t" + "\t" + lastName);
        }
    }
}