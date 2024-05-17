package maven.demo.app;

import maven.demo.dao.*;


public class Aplicacao {
	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
		dao.Salvar_U();

	}
}
