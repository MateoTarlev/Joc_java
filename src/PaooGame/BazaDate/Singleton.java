package PaooGame.BazaDate;

import java.sql.*;

public class Singleton {

    private static Singleton single_instance = null;
    private Connection connection = null;
    public String s;


    private Singleton() {
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Tabel9.db");
            stmt = connection.createStatement();

           /* String sql = "CREATE TABLE Revelation (player_score INT NOT NULL)";
            stmt.execute(sql);*/

        } catch (Exception exception){
            System.out.println(exception);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }

}
