package maven.demo.dao;

import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import maven.demo.model.UsuarioModel;
import maven.demo.service.UsuarioService;

public class DAO {
	private Connection conexao;
	
	public DAO() {		
		conexao = null;
	}	
	
	public boolean conectar() {
		String driverName = "org.postgresql.Driver";
		String servername = "localhost";
		String mydatabase = "nexoT";
		int porta = 5432;
		String url = "jdbc:postgresql://" + servername + ":" + porta + "/" + mydatabase;
		String username = "postgres";
		String password = "227076";
		boolean status = false;
		
		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conectou");
		}catch (ClassNotFoundException e) {
			 System.err.println("Conexão nao foi encontrada -- Driver não encontrado" + e.getMessage());
		}catch (SQLException e) {
			 System.err.println("Conexão nao foi encontrada -- " + e.getMessage());
		}
		return status;
	}
	
	public boolean close() {
		boolean status = false;
		
		try {
			conexao.close();
			status = true;
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	
	public void Salvar_U() {
		try {
			BufferedImage image = ImageIO.read(new File("image.jpg"));
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(image, "JPEG", byteArrayOutputStream);
			byte[] imageBytes = byteArrayOutputStream.toByteArray();
			UsuarioModel user = new UsuarioModel("teste1", "teste1","teste1", imageBytes, 0);
			UsuarioService userS = new UsuarioService(conexao);
			userS.salvarUsuario(user, conexao);
		}catch (ImagingOpException e) {
			System.err.println("Erro na leitura da imagem " + e.getMessage());
		}catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}