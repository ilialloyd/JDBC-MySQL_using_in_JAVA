package org.example;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/12/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class Inserting_Updating_DML {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_video";
        String username = "root";
        String password = "*Lenovo2022";

        Connection connection1 = DriverManager.getConnection(url, username, password);

        Statement statement = connection1.createStatement();
        // how to inserting data to mysql database
        //this time we will use DML language. when you insert data we use that one
        /*

        //version 1

        String query = "insert into people values(3,'Mackie')";

        int count = statement.executeUpdate(query);
        System.out.println(count+" row/s affected");

         */

        // how to add separate variables
        String uname= "Ali";
        int userid = 4;

        String  query2 = "insert into people values("+ userid+",'"+uname+"')";

        int count2 = statement.executeUpdate(query2);
        System.out.println(count2+ "row affected");


        //if there are more than few data to insert we use
        //         PreparedStatement

        String uName ="Ilham";
        int userId= 5;
        //eger kod yazilan vaxt querya hansi datanin yazilacaqi melum deilse ? isaresi qeyd edilir
        String query3 = "insert into people values(?,?)";

        PreparedStatement preparedStatement = connection1.prepareStatement(query3);
        // setInt takes 2 parametr. first one is number of ?index,  and value
        preparedStatement.setInt(1,userId);
        preparedStatement.setString(2,uName);
        // and we execute queries that added values
        int count4 = preparedStatement.executeUpdate();




        statement.close();
        connection1.close();
    }
}
