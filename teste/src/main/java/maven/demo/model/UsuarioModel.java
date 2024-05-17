package maven.demo.model;

public class UsuarioModel {
    private int userId;
    private String email;
    private String userName;
    private String senha;
    private byte[] fotoPerfil;
    private int planoTipoPlano;

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getSenha() {
        return senha;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public int getPlanoTipoPlano() {
        return planoTipoPlano;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public void setPlanoTipoPlano(int planoTipoPlano) {
        this.planoTipoPlano = planoTipoPlano;
    }

    public UsuarioModel(String email, String userName, String senha, byte[] fotoPerfil,
            int planoTipoPlano) {
        this.email = email;
        this.userName = userName;
        this.senha = senha;
        this.fotoPerfil = fotoPerfil;
        this.planoTipoPlano = planoTipoPlano;
    }

    public UsuarioModel() {
    }
}
