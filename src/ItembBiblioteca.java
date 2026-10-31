public abstract class ItemBiblioteca {
    protected int codigo;
    protected String titulo;
    protected boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true; // Todo item novo começa disponível
    }

    // Métodos abstratos exigidos no roteiro
    public abstract int calcularPrazo();
    public abstract double calcularMulta();

    public int getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    // Não deve ter o um setDisponivel() público
    protected void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}