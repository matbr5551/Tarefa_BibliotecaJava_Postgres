public class Aluno extends Usuario {

    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int obterLimiteItens() {
        return 3; // Aluno pode ter até 3 itens simultâneos
    }
}