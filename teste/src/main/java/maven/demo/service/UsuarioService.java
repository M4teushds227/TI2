package maven.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import maven.demo.dao.UsuarioDAO;
import maven.demo.model.UsuarioModel;

public class UsuarioService implements UsuarioDAO {

	    private Connection connection;

	    public UsuarioService(Connection connection) {
	        this.connection = connection;
	    }

	    @Override
	    public void salvarUsuario(UsuarioModel usuario,Connection connectionD) {
	        try (PreparedStatement statement = connectionD.prepareStatement(
	                "INSERT INTO Usuario (Email, UserName, Senha, FotoPerfil, Planos_Tipo_plano) VALUES (?, ?, ?, ?, ?)"
	        )) {
	            statement.setString(1, usuario.getEmail());
	            statement.setString(2, usuario.getUserName());
	            statement.setString(3, usuario.getSenha());
	            statement.setBytes(4, usuario.getFotoPerfil());
	            statement.setInt(5, usuario.getPlanoTipoPlano());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public void atualizarUsuario(UsuarioModel usuario) {
	        try (PreparedStatement statement = connection.prepareStatement(
	                "UPDATE Usuario SET Email = ?, UserName = ?, Senha = ?, FotoPerfil = ?, Planos_Tipo_plano = ? WHERE UserID = ?"
	        )) {
	            statement.setString(1, usuario.getEmail());
	            statement.setString(2, usuario.getUserName());
	            statement.setString(3, usuario.getSenha());
	            statement.setBytes(4, usuario.getFotoPerfil());
	            statement.setInt(5, usuario.getPlanoTipoPlano());
	            statement.setInt(6, usuario.getUserId());
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public void removerUsuario(int idUsuario) {
	        try (PreparedStatement statement = connection.prepareStatement(
	                "DELETE FROM Usuario WHERE UserID = ?"
	        )) {
	            statement.setInt(1, idUsuario);
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    @Override
	    public UsuarioModel buscarUsuarioPorId(int idUsuario) {
	        try (PreparedStatement statement = connection.prepareStatement(
	                "SELECT * FROM Usuario WHERE UserID = ?"
	        )) {
	            statement.setInt(1, idUsuario);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                return new UsuarioModel(
	                        resultSet.getString("Email"),
	                        resultSet.getString("UserName"),
	                        resultSet.getString("Senha"),
	                        resultSet.getBytes("FotoPerfil"),
	                        resultSet.getInt("Planos_Tipo_plano")
	                );
	            } else {
	                return null;
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}


