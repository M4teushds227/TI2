package maven.demo.model;

public class ProdutoModel {

    private int idProduto;
    private String nome;
    private String descricao;
    private double valor;
    private int qtnDisponivel;

    // Getters
    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getqtnDisponivel() {
        return qtnDisponivel;
    }

    // Setters
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setqtnDisponivel(int qtnDisponivel) {
        this.qtnDisponivel = qtnDisponivel;
    }

    public ProdutoModel(String nome, String descricao, double valor, int qtnDisponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.qtnDisponivel = qtnDisponivel;
    }

    public ProdutoModel() {
    }
}
