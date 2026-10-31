public abstract class Usuario {
    protected String nome;
    protected int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0; // Começa com zero itens
    }

    // Método abstrato exigido no roteiro
    public abstract int obterLimiteItens();

    public String getNome() { return nome; }
    public int getQuantidadeEmprestada() { return quantidadeEmprestada; }

    // Métodos auxiliares para controlar a quantidade quando a Biblioteca agir
    public void adicionarEmprestimo() {
        this.quantidadeEmprestada++;
    }

    public void removerEmprestimo() {
        if (this.quantidadeEmprestada > 0) {
            this.quantidadeEmprestada--;
        }
    }

    // Verifica se o usuário ainda não estourou o seu limite
    public boolean podeEmprestar() {
        return this.quantidadeEmprestada < obterLimiteItens();
    }
}