package connectionFactory;

import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vo.DataUser;

public class CreateConnection {
	Connection connection = null;
	
	DataUser user;
	
	protected String URL = "jdbc://postgresql:/localhost/datauser";
	protected String USER = "postgres";
	protected String PASSWORD = "masterkey";
	
	protected Connection CreateConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Iniciando conexão...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	public DataUser createUser(DataUser dataUser) throws IOException, ClassNotFoundException{
		try(Connection connection = CreateConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("Insert into datauser(id, email, password)" + "values(?, ?, ?)");){
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;	
	}
}
