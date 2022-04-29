package com.company.TestOfTable;

import com.company.Connection.JDBC;

import java.sql.*;

public class GetAllRows {

    public static void main(String[] args) {
        Statement stmt = null;
        try{

            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM authors order by firstName, lastName";
            System.out.println("Authors:");
            ResultSet rs1 = stmt.executeQuery(exampleQuery1);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
            String exampleQuery2 = "SELECT * FROM titles";
            System.out.println("Titles:");
            ResultSet rs2 = stmt.executeQuery(exampleQuery2);
            while (rs2.next()) {
                String isbn = rs2.getString("isbn");
                String title = rs2.getString("title");
                int editionNumber = rs2.getInt("editionNumber");
                String year = rs2.getString("year");
                int publisherID = rs2.getInt("publisherID");
                int price = rs2.getInt("price");
                System.out.println(isbn + "\t" + title + "\t" + editionNumber+ "\t" + year+ "\t" +publisherID
                        + "\t" + price);
            }
            String exampleQuery3 = "SELECT * FROM publishers";
            System.out.println("Publisher:");
            ResultSet rs3 = stmt.executeQuery(exampleQuery3);

            while (rs3.next()) {
                int publisherID = rs3.getInt("publisherID");
                String publisherName = rs3.getString("publisherName");

                System.out.println(publisherID + "\t" + publisherName + "\t");
            }
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } finally {
            // Finally block, used to close resources
            JDBC.close();
        }

    }
}
