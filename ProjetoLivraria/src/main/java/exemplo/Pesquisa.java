package exemplo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.LivroDao;
import model.Livro;

public class Pesquisa {
	public static void main(String[] args) {
		String titulo;
		Livro livro;
		ArrayList<Livro> livros = new ArrayList<Livro>();
		titulo = "NEVE";
		if (titulo == null) {
			titulo = "";
		}
		System.out.println("Pesquisa: " + titulo);
		try {
			LivroDao dao = new LivroDao();
			List<Livro> array = dao.consultar(titulo);
			int tamanho = array.size();
			if (tamanho > 0) {
				livros.addAll(array);
				for (int i = 0; i < livros.size(); i++) {
					livro = (Livro) livros.get(i);

					System.out.println(livro.getTitulo());
				}
			} else {
				System.out.println(titulo + "Esta vindo vazio!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
