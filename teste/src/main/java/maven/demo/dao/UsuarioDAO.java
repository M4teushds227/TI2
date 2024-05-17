package maven.demo.dao;

import java.sql.Connection;

import maven.demo.model.UsuarioModel;

public interface UsuarioDAO {

	    void salvarUsuario(UsuarioModel usuario, Connection connectD);

	    void atualizarUsuario(UsuarioModel usuario);

	    void removerUsuario(int idUsuario);

	    UsuarioModel buscarUsuarioPorId(int idUsuario);

}
