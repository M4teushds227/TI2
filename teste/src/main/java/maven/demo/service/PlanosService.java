package maven.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import maven.demo.dao.PlanosDAO;
import maven.demo.model.PlanosModel;

import java.util.ArrayList;

public class PlanosService implements PlanosDAO {

    private Connection connection;

    public PlanosService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvarPlano(PlanosModel plano) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Planos (Nome, Descricao, Valor, TipoPlano) VALUES (?, ?, ?, ?)"
        )) {
            statement.setString(1, plano.getNome());
            statement.setString(2, plano.getDescricao());
            statement.setDouble(3, plano.getValor());
            statement.setString(4, plano.getTipoPlano());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarPlano(PlanosModel plano) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE Planos SET Nome = ?, Descricao = ?, Valor = ?, TipoPlano = ? WHERE ID_Plano = ?"
        )) {
            statement.setString(1, plano.getNome());
            statement.setString(2, plano.getDescricao());
            statement.setDouble(3, plano.getValor());
            statement.setString(4, plano.getTipoPlano());
            statement.setInt(5, plano.getIdPlano());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerPlano(int idPlano) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Planos WHERE ID_Plano = ?"
        )) {
            statement.setInt(1, idPlano);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlanosModel buscarPlanoPorId(int idPlano) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Planos WHERE ID_Plano = ?"
        )) {
            statement.setInt(1, idPlano);
            java.sql.ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new PlanosModel(
                        resultSet.getString("Nome"),
                        resultSet.getString("Descricao"),
                        resultSet.getDouble("Valor"),
                        resultSet.getString("TipoPlano")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlanosModel> buscarTodosPlanos() {
        List<PlanosModel> planos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Planos"
        )) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                planos.add(new PlanosModel(
                        resultSet.getString("Nome"),
                        resultSet.getString("Descricao"),
                        resultSet.getDouble("Valor"),
                        resultSet.getString("TipoPlano")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return planos;
    }
}
