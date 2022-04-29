package com.company.Query;


import com.company.Connection.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Query4 {
    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            int selectedID;
            System.out.println("Укажите ID издателя, чьи книги хотите просмотреть:");
            selectedID = (new Scanner(System.in).nextInt());
            String query = "SELECT * FROM titles WHERE publisherID = "+selectedID+" ORDER BY title";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("isbn\n"+"editionNumber\n"+"price\n"+"title\n");
            while (rs.next()){
                String isbn;
                String title;
                String editionNumber;
                String price;
                isbn = rs.getString("isbn");
                title = rs.getString("title");
                editionNumber = rs.getString("editionNumber");
                price = rs.getString("price");
                System.out.println(isbn +"\n"+editionNumber +"\n"+price +"\n"+title);

            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

    }
}