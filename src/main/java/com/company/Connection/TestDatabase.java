package com.company.Connection;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.*;

public class TestDatabase {

    public static void main(String[] args) {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            JDBC.connect();
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return;
        }

        JDBC.close();
    }
}