package maven.demo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import maven.demo.dao.ProdutoDAO;
import maven.demo.model.ProdutoModel;

public class ProdutoService implements ProdutoDAO {

    private Connection connection;

    public ProdutoService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvarProduto(ProdutoModel produto) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Produto (Nome, Descricao, Valor, QuantidadeDisponivel) VALUES (?, ?, ?, ?)"
        )) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getValor());
            statement.setInt(4, produto.getqtnDisponivel());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarProduto(ProdutoModel produto) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE Produto SET Nome = ?, Descricao = ?, Valor = ?, QuantidadeDisponivel = ? WHERE ID_Produto = ?"
        )) {
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getValor());
            statement.setInt(4, produto.getqtnDisponivel());
            statement.setInt(5, produto.getIdProduto());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerProduto(int idProduto) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM Produto WHERE ID_Produto = ?"
        )) {
            statement.setInt(1, idProduto);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProdutoModel buscarProdutoPorId(int idProduto) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Produto WHERE ID_Produto = ?"
        )) {
            statement.setInt(1, idProduto);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new ProdutoModel(
                        resultSet.getString("Nome"),
                        resultSet.getString("Descricao"),
                        resultSet.getDouble("Valor"),
                        resultSet.getInt("QuantidadeDisponivel")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProdutoModel> buscarTodosProdutos() {
        List<ProdutoModel> produtos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM Produto"
        )) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                produtos.add(new ProdutoModel(
                        resultSet.getString("Nome"),
                        resultSet.getString("Descricao"),
                        resultSet.getDouble("Valor"),
                        resultSet.getInt("QuantidadeDisponivel")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }
}