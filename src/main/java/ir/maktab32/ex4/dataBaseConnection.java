package ir.maktab32.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dataBaseConnection {

        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://localhost/lettermanagement";
        static final String USER = "root";
        static final String Pass = "";

        static Connection connection = null;
        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            if (connection == null) {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, Pass);
                return connection;
            }else
            if (connection.isClosed()){
                connection = DriverManager.getConnection(DB_URL, USER, Pass);
            }
            return connection;
        }

    public static void main(String[] args) {
        Connection connection = null;
//        PreparedStatement preparedStatement = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, Pass);
            String inserQuery = "INSERT INTO letter_managment(title, privacy, indicator, sender, submitdate) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(inserQuery);
            preparedStatement.setString(1,user.getTitle());
            preparedStatement.setString(2,letter.getPrivacy());
            preparedStatement.setLong(3,letter.getIndicator());
            preparedStatement.setString(4,letter.getSender());
            preparedStatement.setString(5,letter.getSubmitDate());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

