public class Revista extends ItemBiblioteca {

    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularPrazo() {
        return 7; // Revista: 7 dias de prazo
    }

    @Override
    public double calcularMulta() {
        return 1.00; // Revista: R$ 1,00/dia
    }
}