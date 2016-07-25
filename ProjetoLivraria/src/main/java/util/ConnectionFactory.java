package util;

import java.sql.*;

public class ConnectionFactory {
	static final String url = "jdbc:postgresql://localhost:5432/paulo";
	static final String usuario = "postgres";
	static final String senha = "123456";

	public static Connection getConexao() throws SQLException {
			return DriverManager.getConnection(url, usuario, senha);
	}
}
