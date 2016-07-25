package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Livro;
import util.ConnectionFactory;

public class LivroDao {

	Connection conexao;

	public LivroDao() throws SQLException {
		this.conexao = ConnectionFactory.getConexao();
	}

	public Livro consultar(int codigo) {
		Livro livro = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select AUTOR, TITULO, COD_LIVRO, IMAGEM, PRECO from ESTOQUE WHERE COD_LIVRO = ?");
			PreparedStatement consulta = conexao.prepareStatement(sql.toString());
			consulta.setInt(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;
	}

	public List<Livro> consultar(String titulo) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COD_LIVRO, TITULO, AUTOR, PRECO, IMAGEM FROM ESTOQUE WHERE TITULO LIKE ?");
			this.conexao = ConnectionFactory.getConexao();
			PreparedStatement consulta = conexao.prepareStatement(sql.toString());
			consulta.setString(1, "%" + titulo.toUpperCase() + "%");
			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				model.Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				lista.add(livro);
			}
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
