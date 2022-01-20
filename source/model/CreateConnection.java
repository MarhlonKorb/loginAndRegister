package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vo.DataUser;

public class CreateConnection {
	Connection connection = null;
	
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
			 PreparedStatement preparedStatement = connection.prepareStatement("Insert into user(id, email, password)" + "values(?, ?, ?)");){
			preparedStatement.setInt(1, dataUser.getId());
			preparedStatement.setString(2, dataUser.getEmail());
			preparedStatement.setString(3, dataUser.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeQuery();
			
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dataUser;	
	}
	
	public void checkRegisterUser(String email, String password) throws SQLException, ClassNotFoundException{
		Connection connection = CreateConnection();
		
		PreparedStatement statement = connection.prepareStatement("select * from datauser users where users.email=?");
		ResultSet rs = statement.executeQuery();
		
		try {
		while(rs.next()) {
			if(rs.getString("password").equals("password")) {
				DataUser users = new DataUser();
				users.setEmail(email);
				users.setPassword(password);
				System.out.println("Usuário cadastrado com sucesso:" + email);
			}
		}
	}catch(RuntimeException e){
			e.printStackTrace();
		}
	}
	
}
	

