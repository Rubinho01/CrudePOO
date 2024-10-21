package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
	
	 		public static String status = "Não conectou";
		
		public ConexaoMySQL(){
			
		}
		
		
		public static java.sql.Connection getConexaoMySQL (){
			Connection connection = null;
			String driverNameString = "com.mysql.cj.jdbc.Driver";
			try {
				Class.forName(driverNameString);
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			String serverName = "localhost";
			String mydatabase = "produto_atividade";
			String url = "jdbc:mysql://"+serverName +"/" + mydatabase;
			String username = "root";
			String password = "";
			try {
				connection = DriverManager.getConnection(url, username, password);
				System.out.println("deu bom");
			}catch (SQLException e) {
				System.out.println(status);
				e.printStackTrace();
			}
			
			
			return connection;
		}
	}


