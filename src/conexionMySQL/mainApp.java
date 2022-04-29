package conexionMySQL;

public class mainApp {

	public static void main(String[] args) {
		ConexionMysql conexionMysql = new ConexionMysql();
		
		conexionMysql.conectar();
//		conexionMysql.createDB("pepito");
//		conexionMysql.dropDB("pepito");
//		conexionMysql.createTable("pepe", "asd");
//		conexionMysql.dropTable("pepe", "asd");
		conexionMysql.desconectar();

	}

}
