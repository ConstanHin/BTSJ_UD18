package conexionMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionMysql {

	Connection connectionObj;

	// Constructor
	public ConexionMysql() {

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
	 * 
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
	 * 
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
	public void createTable(String dbName, String tableName, String columnName) {
		try {
			String queryDb = "USE " + dbName + ";";
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "CREATE TABLE " + tableName + "" + "(ID INT PRIMARY KEY AUTO_INCREMENT, " + columnName
					+ " VARCHAR(20) NOT NULL);";

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

	/**
	 * Insert a row in the table
	 *  
	 * @param dbName
	 * @param inserQuery
	 */
	public void insertRow(String dbName, String insertQuery) {
		try {
			// Database use statement

			String queryDb = "USE " + dbName + ";";

			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);

			// Insert into the table statement
			String query = insertQuery;

			Statement st = this.connectionObj.createStatement();

			st.executeUpdate(query);
			System.out.println("Inserted row/s!");

		} catch (Exception e) {
			System.out.println("Inserting row/s fail");
			System.out.println(e);
		}
	}
	
	/**
	 * Delete table row by id
	 *  
	 * @param dbName
	 * @param inserQuery
	 */
	public void deleteRow(String dbName, String tableName, int id) {
		try {
			// Database use statement

			String queryDb = "USE " + dbName + ";";

			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);

			// Insert into the table statement
			String query = "DELETE FROM " + tableName + " WHERE ID=" + id + ";";

			Statement st = this.connectionObj.createStatement();

			st.executeUpdate(query);
			System.out.println("Deleted row with id: " + id);

		} catch (Exception e) {
			System.out.println("Deleting row/s fail");
			System.out.println(e);
		}
	}
	
	/**
	 * 
	 * @param dbName
	 * @param tableName
	 * @param id
	 */
	public void showRows(String dbName, String tableName, int id) {
		try {
			// Database use statement
			
			String queryDb = "USE " + dbName + ";";
			
			Statement stdb = this.connectionObj.createStatement();
			stdb.executeUpdate(queryDb);
			
			// Insert into the table statement
			String query = "SELECT * FROM " + tableName + " WHERE ID=" + id + ";";
			
			Statement st = this.connectionObj.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			rs.next();
			System.out.println( rs.getString("ID") + rs.getString("nombre"));
			
			System.out.println("Showing rows with id: " + id);
			
		}catch (Exception e) {
			System.out.println("Showing row/s fail");
			System.out.println(e);
		}
	}

}
