package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Vo.DataUser;

public class Conectar {
	Connection connection = null;
	
	protected String URL = "jdbc:postgresql://localhost:5432/datauser";
	protected String USER = "postgres";
	protected String PASSWORD = "masterkey";
	
	protected Connection getConnection() throws ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Iniciando conexão...");
		} catch (Exception e) {
			System.out.println("erro na conexão");
		}
		return getConnection();	
	}
	
	public DataUser createUser(DataUser dataUser) throws IOException, ClassNotFoundException{
		
		try(Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement("Insert into register( email, password)" + "values(?, ?)" + " where id=?");){
			preparedStatement.setInt(1, dataUser.getId());
			preparedStatement.setString(1, dataUser.getEmail());
			preparedStatement.setString(2, dataUser.getPassword());
			
			checkRegisterUser(URL, PASSWORD);
			if (dataUser.getEmail().equals("email") && dataUser.getPassword().equals("password")) {
				preparedStatement.executeQuery();
			System.out.println("Usuário cadastrado com sucesso");
			connection.close();	
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dataUser;	
	}
	
	public void checkRegisterUser(String email, String password) throws SQLException, ClassNotFoundException{
		Connection connection = getConnection();
		
		PreparedStatement statement = connection.prepareStatement("SELECT email, password "
				+ "	FROM public.\"register\";");
		ResultSet rs = statement.executeQuery();
		
		try {
		while(rs.next()) {
			if(rs.getString("password").equals("password")) {
				DataUser users = new DataUser();
				users.setEmail(email);
				users.setPassword(password);
				System.out.println("Usuário validado com sucesso: " + email);
			}
		}
	}catch(RuntimeException e){
			e.printStackTrace();
		}
	}
	
}
	

