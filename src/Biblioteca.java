public class Biblioteca {
    private ItemBiblioteca[] acervo; // Array de tamanho fixo
    private int totalItens;

    public Biblioteca(int capacidadeMaxima) {
        this.acervo = new ItemBiblioteca[capacidadeMaxima];
        this.totalItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if (totalItens < acervo.length) {
            acervo[totalItens] = item;
            totalItens++;
        } else {
            System.out.println("Acervo cheio! Não é possível adicionar mais itens.");
        }
    }

    public void emprestar(Usuario usuario, ItemBiblioteca item) {
        if (item.isDisponivel() && usuario.podeEmprestar()) {
            item.setDisponivel(false); // Disponibilidade muda via emprestar()
            usuario.adicionarEmprestimo();
            System.out.println("Sucesso: '" + item.getTitulo() + "' emprestado para " + usuario.getNome() + ".");
        } else {
            System.out.println("Recusado: Limite atingido por " + usuario.getNome() + " ou item '" + item.getTitulo() + "' indisponível.");
        }
    }

    public void devolver(Usuario usuario, ItemBiblioteca item) {
        if (!item.isDisponivel()) {
            item.setDisponivel(true); // Disponibilidade muda via devolver()
            usuario.removerEmprestimo();
            System.out.println("Sucesso: '" + item.getTitulo() + "' devolvido por " + usuario.getNome() + ".");
        }
    }

    public void listarAcervo() {
        System.out.println("\n--- Acervo da Biblioteca ---");
        // Único laço, sem nenhum if verificando o tipo do item
        for (int i = 0; i < totalItens; i++) {
            ItemBiblioteca item = acervo[i];
            String status = item.isDisponivel() ? "Disponível" : "Emprestado";

            // O polimorfismo chama calcularPrazo() e calcularMulta() da classe correta (Livro ou Revista) automaticamente
            System.out.println("Cód: " + item.getCodigo() + " | " + item.getTitulo() +
                    " | Prazo: " + item.calcularPrazo() + " dias" +
                    " | Multa: R$ " + item.calcularMulta() + "/dia" +
                    " | Status: " + status);
        }
        System.out.println("----------------------------\n");
    }
}