package maven.demo.dao;

import java.util.List;

import maven.demo.model.ProdutoModel;

public interface ProdutoDAO {

    void salvarProduto(ProdutoModel produto);

    void atualizarProduto(ProdutoModel produto);

    void removerProduto(int idProduto);

    ProdutoModel buscarProdutoPorId(int idProduto);

    List<ProdutoModel> buscarTodosProdutos();
}