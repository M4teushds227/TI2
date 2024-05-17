package maven.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import maven.demo.dao.InteresseDAO;
import maven.demo.model.InteresseModel;

public class InteresseService implements InteresseDAO {

    private Connection connection;

    public InteresseService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvarInteresse(InteresseModel interesse) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Interesse (Descricao, Nome_Interesse) VALUES (?, ?)"
        )) {
            statement.setString(1, interesse.getDescricao());
            statement.setString(2, interesse.getNomeInteresse());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarInteresse(InteresseModel interesse) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE Interesse SET Descricao = ?, Nome_Interesse = ? WHERE ID_Interesse = ?"
        )) {
            statement.setString(1, interesse.getDescricao());
            statement.setString(2, interesse.getNomeInteresse());
            statement.setInt(3, interesse.getIdInteresse());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerInteresse(int idInteresse) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Interesse WHERE ID_Interesse = ?"
        )) {
            statement.setInt(1, idInteresse);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public InteresseModel buscarInteressePorId(int idInteresse) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Interesse WHERE ID_Interesse = ?"
        )) {
            statement.setInt(1, idInteresse);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new InteresseModel(
                        resultSet.getString("Descricao"),
                        resultSet.getString("Nome_Interesse")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

