package util;

import java.sql.*;

public class TestaConexao {
	public static void main(String[] args) {
		Connection con;
		try {
			con = ConnectionFactory.getConexao();
			if (con != null)
				System.out.println("Conexao estabelecida!");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
