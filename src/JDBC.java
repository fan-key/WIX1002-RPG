import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class JDBC{
        final String URL = "jdbc:mysql://localhost:3306/rpg";
        final String USERNAME = "root";
        final String PASSWORD = "password";

        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        public void register(String user_name, String user_email, String user_password, int user_key){
            // Database connection parameters
            // SQL query to insert data
            String sql = "INSERT INTO users ( user_name, user_email , user_password , user_key) VALUES (?, ?, ?, ?)";
    
            // Establish a connection to the database
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, user_name); 
                preparedStatement.setString(2, user_email);  
                preparedStatement.setString(3, user_password); 
                preparedStatement.setInt(4, user_key);
    
                // Execute the insert query
                int rowsAffected = preparedStatement.executeUpdate();
    
                // Check if the insert was successful
                if (rowsAffected > 0) {
                    System.out.println(user_name + " registered successfully!");
                } else {
                    System.out.println("Failed to register " + user_name);
                }
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public boolean login(String user_email, String user_password){
            // Database connection parameters
            // SQL query to check if the email already exists
            String sql = "SELECT * FROM users WHERE BINARY user_email = ? AND BINARY user_password = ?";
    
            // Establish a connection to the database
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
                // Set the parameters for the SQL query
                preparedStatement.setString(1, user_email); 
                preparedStatement.setString(2, user_password); 
    
                // Execute the select query
                return preparedStatement.executeQuery().next();
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public boolean alreadyExists(String user_input, String column){

            if (!column.equals("user_name") && !column.equals("user_email") && !column.equals("user_key")) {
                throw new IllegalArgumentException("Invalid column name");
            }
            String sql = "SELECT * FROM users WHERE BINARY " + column + " = ?";
    
            // Establish a connection to the database
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
                // Set the parameters for the SQL query
                preparedStatement.setString(1, user_input); 
    
                // Execute the select query
                return preparedStatement.executeQuery().next();
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        public int getKey(String user_email){
            // Database connection parameters
            // SQL query to check if the email already exists
            String sql = "SELECT user_key FROM users WHERE BINARY user_email = ?";
    
            // Establish a connection to the database
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
    
                // Set the parameters for the SQL query
                preparedStatement.setString(1, user_email); 
                var resultSet = preparedStatement.executeQuery(); 
        
                if (resultSet.next()) { // Ensure there's a result before accessing it
                    return resultSet.getInt("user_key");
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return -1;

        }
        
        public void clear() {
            String sql = "TRUNCATE TABLE users";
            
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                
                preparedStatement.executeUpdate(); // Actually execute the query
                System.out.println("Table cleared!");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}