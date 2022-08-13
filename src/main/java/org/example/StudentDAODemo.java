package org.example;

import java.sql.*;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: ilialloyd
 * Date: 8/12/2022
 * Leave your comment below if you have
 * --------------------------------------------------------
 */
public class StudentDAODemo {
    public static void main(String[] args) throws SQLException {


    StudentDao dao = new StudentDao();

    dao.connect();
   // Student s = dao.getStudent(13);
        Student student = new Student();
        student.rollno=15;
        student.sName="Mackie";
        dao.addStudent(student);

    }
}

class StudentDao {
    Connection con;

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/filemansys";
        String username = "root";
        String password = "*Lenovo2022";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudent(int rollno) throws SQLException {

        Student s = new Student();
        s.rollno=rollno;

        String query = "select * from student";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+" : "+resultSet.getString(2));
        }


        return s;

    }

    public void addStudent(Student s) throws SQLException {
        String query3 = "insert student values(?,?)";
        PreparedStatement ps = con.prepareStatement(query3);
        ps.setInt(1,s.rollno);
        ps.setString(2,s.sName);
        ps.executeUpdate();


    }

}

class Student{
    String sName ;
    int rollno;
}
