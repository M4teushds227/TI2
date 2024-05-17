package maven.demo.model;

public class PlanosModel {

    private int idPlano;
    private String nome;
    private String descricao;
    private double valor;
    private String tipoPlano;

    // Getters
    public int getIdPlano() {
        return idPlano;
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

    public String getTipoPlano() {
        return tipoPlano;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    // Construtor (opcional)
    public PlanosModel(String nome, String descricao, double valor, String tipoPlano) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoPlano = tipoPlano;
    }

    // Construtor vazio (opcional)
    public PlanosModel() {
    }
}
