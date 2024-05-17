package maven.demo.dao;

import java.util.List;

import maven.demo.model.PlanosModel;

public interface PlanosDAO {

    void salvarPlano(PlanosModel plano);

    void atualizarPlano(PlanosModel plano);

    void removerPlano(int idPlano);

    PlanosModel buscarPlanoPorId(int idPlano);

    List<PlanosModel> buscarTodosPlanos();
}