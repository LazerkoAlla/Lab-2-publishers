package com.company.Query;

import com.company.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query5 {

    public static void main(String[] args) {
        Statement stmt = null;
        String firstName;
        String lastName;
        try{


            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            System.out.println("Добавление нового автора");

            System.out.print("Введите имя: ");
            firstName = (new Scanner(System.in).nextLine());
            System.out.print("Введите фамилию: ");
            lastName = (new Scanner(System.in).nextLine());

            String query = "INSERT INTO authors(firstName, lastName) " +
                    "VALUES('" + firstName + "','"+ lastName + "')";
            stmt.executeUpdate(query);




        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}