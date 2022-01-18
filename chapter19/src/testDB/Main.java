package testDB;

import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\software\\JetBrains\\IdeaProjects\\java-the-complete-java-developer-course\\chapter19\\src\\testDB\\" + DB_NAME;

    public static final String TABLE_CONTACTS = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING);
             Statement statement = conn.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS" + TABLE_CONTACTS);
            // create table
            statement.execute("CREATE TABLE IF NOT EXISTS" + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + "INTEGER" +
                    COLUMN_EMAIL + "TEXT" +
                    ")");

            // query data
            ResultSet results = statement.executeQuery("SELECT * FROM contacts");

            while (results.next()) {
                System.out.println(results.getString("name") + " "
                        + results.getInt("phone") + " "
                        + results.getString("email"));
            }

            results.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }

    }
}
