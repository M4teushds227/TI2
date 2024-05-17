package maven.demo.model;

public class InteresseModel {

    private int idInteresse;
    private String descricao;
    private String nomeInteresse;

    // Getters
    public int getIdInteresse() {
        return idInteresse;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeInteresse() {
        return nomeInteresse;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeInteresse(String nomeInteresse) {
        this.nomeInteresse = nomeInteresse;
    }

    public InteresseModel(String descricao, String nomeInteresse) {
        this.descricao = descricao;
        this.nomeInteresse = nomeInteresse;
    }

    public InteresseModel() {
    }
}
