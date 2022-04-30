package conexionMySQL;

public class mainApp {

	public static void main(String[] args) {
		ConexionMysql conexionMysql = new ConexionMysql();
		
		conexionMysql.conectar();
//		conexionMysql.createDB("pepito");
//		conexionMysql.dropDB("pepito");
//		conexionMysql.createTable("pepe", "juguetes", "nombre");
//		conexionMysql.dropTable("pepe", "asd");
//		conexionMysql.insertRow("pepe", "INSERT INTO juguetes (nombre) VALUES (\"bloques\");");
//		conexionMysql.deleteRow("pepe", "juguetes", 11);
//		conexionMysql.showRows("pepe", "juguetes", 13);
		conexionMysql.showRows("pepe", "juguetes");
		conexionMysql.desconectar();

	}

}
