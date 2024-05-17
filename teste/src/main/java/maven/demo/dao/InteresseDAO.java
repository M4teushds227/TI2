package maven.demo.dao;

import maven.demo.model.InteresseModel;

public interface InteresseDAO {

    void salvarInteresse(InteresseModel interesse);

    void atualizarInteresse(InteresseModel interesse);

    void removerInteresse(int idInteresse);

    InteresseModel buscarInteressePorId(int idInteresse);

}
