package conexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMysql {
	
	Connection connectionObj;
	
	// Constructor
	public ConexionMysql(){
		
	};

	public void conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.145:3306", "remote", "Reus_2022");
			this.connectionObj = conexion;
			System.out.println("Conectado a la base de datos con exito");
		} catch (Exception e) {
			System.out.println("Fallo conexion con la base de datos");
			System.out.println(e);
		}
	}
	
	public void desconectar() {
		try {
			this.connectionObj.close();
			System.out.println("Desconectado de la base de datos.");			
		} catch (Exception e) {
			System.out.println("Fallo al cerrar la conexion");
			System.out.println(e);
		}
	}

	/**
	 * Create a database
	 * @param name
	 */
	public void createDB(String name) {
		try {
			String query = "CREATE DATABASE " + name;
			Statement st = this.connectionObj.createStatement();
			st.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Creating database fail");
			System.out.println(e);
		}
	}
	
	/**
	 * Create a database
	 * @param name
	 */
	public void dropDB(String name) {
		try {
			String query = "DROP DATABASE " + name;
			Statement st = this.connectionObj.createStatement();
			st.executeUpdate(query);
			
		} catch (Exception e) {
			System.out.println("Drop database fail");
			System.out.println(e);
		}
	}
	
	/**
	 * Create a table in a database
	 */
	public void createTable(String dbName, String tableName) {
		try {
			String queryDb = "USE " + dbName + ";";
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);
			
			String query = "CREATE TABLE " + tableName + ""
					+ "(ID INT PRIMARY KEY AUTO_INCREMENT);";
			
			Statement st = this.connectionObj.createStatement();
			
			st.executeUpdate(query);
			System.out.println("Table created!");
			
		} catch (Exception e) {
			System.out.println("Create table fail");
			System.out.println(e);
		}
	}
	
	
	/**
	 * Drop a table in a database
	 * 
	 * @param dbName
	 * @param tableName
	 */
	public void dropTable(String dbName, String tableName) {
		try {
			// Database statement
			
			String queryDb = "USE " + dbName + ";";
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);
			
			// Drop table Statement
			String query = "DROP TABLE " + tableName + ";";
			
			Statement st = this.connectionObj.createStatement();
			stdb.executeUpdate(query);
			
			st.executeUpdate(query);
			System.out.println("Table deleted!");
			
		} catch (Exception e) {
			System.out.println("Deleting table fail");
			System.out.println(e);
		}
	}
	
	
	
}
