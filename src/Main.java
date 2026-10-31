public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(10);

        // Cadastro de Usuários[cite: 1]
        Usuario aluno = new Aluno("Matheus");
        Usuario professor = new Professor("João");

        // Cadastro de Itens[cite: 1]
        ItemBiblioteca livro1 = new Livro(1, "O Senhor dos Anéis");
        ItemBiblioteca livro2 = new Livro(2, "Java para Iniciantes");
        ItemBiblioteca livro3 = new Livro(3, "Clean Code");
        ItemBiblioteca revista1 = new Revista(4, "Veja");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(livro3);
        biblioteca.adicionarItem(revista1);

        System.out.println("--- Testando Empréstimos ---");

        // Empréstimos bem-sucedidos (Aluno tem limite de 3 itens)[cite: 1]
        biblioteca.emprestar(aluno, livro1);
        biblioteca.emprestar(aluno, livro2);
        biblioteca.emprestar(aluno, livro3);

        // Empréstimo recusado (Limite de 3 itens atingido)[cite: 1]
        biblioteca.emprestar(aluno, revista1);

        // Empréstimo bem-sucedido para o Professor (para testar outro usuário)
        biblioteca.emprestar(professor, revista1);

        // Listar o acervo para verificar o status de cada item[cite: 1]
        biblioteca.listarAcervo();
    }
}