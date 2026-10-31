public class Professor extends Usuario {

    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int obterLimiteItens() {
        return 5; // Professor pode ter até 5 itens simultâneos
    }
}