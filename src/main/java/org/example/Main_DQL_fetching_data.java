package org.example;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: ${USER}
 * Date: ${DATE}
 * Leave your comment below if you have
 * --------------------------------------------------------
 *              7 Steps
 * 1. import  java.sql*
 * 2. Load and register the driver -> com.mysql.jdbc.Driver
 * 3. Create connection -> Connection
 * 4. Create the statement -> Statement
 * 5. execute the query ->
 * 6. process the result
 * 7. close().
 * Connection - A connection(session) with a spesific database
 * DriverManager - Basic service for managing JDBC drivers
 * Statement - An interface that represents a SQL statement. You need a connection object
 * to create a statement object
 * ResultSet - A table of data representing the result returned from the database
 *
 * 3 types of languages in SQL : DDL, DML,DQL
 *
 */
public class Main_DQL_fetching_data {
    public static void main(String[] args) throws Exception {
        // first you download com.mysql.jdbc.Driver file - dependency
        //then we register the method
        //Step 1
    //    Class.forName("com.mysql.jdbc.Driver");

        //Connection - A connection(session) with a spesific database
        //DriverManager - Basic service for managing JDBC drivers
//---------------------------------------------------------------
        //Step 2 - Establish connection
        Connection connection = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/jdbc_video", "root", "*Lenovo2022");
//or and better way
        String url = "jdbc:mysql://localhost:3306/jdbc_video";
        String username = "root";
        String password = "*Lenovo2022";

        Connection connection1 = DriverManager.getConnection(url, username, password);
//-------------------------------------------------------------------
        //Step 3: Create Statement for execute

        //Statement - An interface that represents a SQL statement. You need a connection object
        //            to create a statement object
        Statement statement = connection1.createStatement();
//----------------------------------------------------------------------
        //Executing Query
        // Best way to create new String and work with that
        String query = "select * from people";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
           // System.out.println(resultSet.getString("firstname"));
            System.out.println(resultSet.getInt(1)+" : "+resultSet.getString(2));
        }
        //or if you need specific data you can give specific order
        String query2 = "select * from people where id=2";
        resultSet = statement.executeQuery(query2); //DQL
        resultSet.next(); // this is important. event you need one data you should put next() method
        String name = resultSet.getString("firstname");
        System.out.println(name);

// 3 types of languages in SQL : DDL, DML,DQL
        // DQL - when you fetch data. or when you use executeQuery method


        // how to inserting data to mysql database
        //this time we will use DML language. when you insert data we use that one


        statement.close();
        connection1.close();

    }
}