public class Livro extends ItemBiblioteca {

    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularPrazo() {
        return 14; // Livro: 14 dias de prazo
    }

    @Override
    public double calcularMulta() {
        return 0.50; // Livro: R$ 0,50 de multa
    }
}