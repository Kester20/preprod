import java.sql.*;

/**
 * @author Arsalan
 */
public class Demo {

    private static final String URL = "jdbc:mysql://localhost:3306/web_store";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static final String query1 = "SELECT * FROM users";

    public static void main(String[] args) {
        Connection conn = null;

        PreparedStatement statement = null;

        ResultSet result = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");



            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);



            statement = conn.prepareStatement(query1);

            result = statement.executeQuery();



            while (result.next()) {

                System.out.println(result.getString(1) + " " + result.getString(2));

            }

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }finally{

            try {

                result.close();

                statement.close();

                conn.close();

            } catch (SQLException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }



        }
    }

}
