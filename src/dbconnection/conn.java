package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class conn {

    Connection c;
    public static Statement s;

    public conn() {
        try {
            //register the driver
            Class.forName("com.mysql.jdbc.Driver");
            //dbconnection);
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "");

            s = c.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new conn();
    }

}

