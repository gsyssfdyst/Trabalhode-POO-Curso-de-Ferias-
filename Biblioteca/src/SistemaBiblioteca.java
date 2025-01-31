import java.util.Scanner;
import java.io.IOException;

public class SistemaBiblioteca {
    private static Biblioteca biblioteca = new Biblioteca();

    private static void menu() {
        System.out.println("\n===== MENU DA BIBLIOTECA =====");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Emprestar Livro");
        System.out.println("4. Devolver Livro");
        System.out.println("5. Listar Livros");
        System.out.println("6. Listar Usuários");
        System.out.println("7. Listar Livros Emprestados");
        System.out.println("8. Remover Livro");
        System.out.println("9. Remover Usuário");
        System.out.println("10. Editar Livro");
        System.out.println("11. Editar Usuário");
        System.out.println("12. Salvar Dados");
        System.out.println("13. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        try {
            biblioteca.carregarDados();
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            menu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do teclado
            } else {
                scanner.next();
                System.out.println("Opção inválida");
                scanner.nextLine(); // Limpa o buffer do teclado
                continue;  //Voltar ao início do laço
            }
            switch (opcao) {
                case 1:
                    System.out.println("1. Cadastrar Livro");
                    System.out.print("Digite o ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    System.out.println("Digite a editora: ");
                    String editora = scanner.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    int numeroPaginas = scanner.nextInt();
                    System.out.print("Digite a quantidade de exemplares: ");
                    int quantidade = scanner.nextInt();
                    try {
                        Livro livro = new Livro(isbn, titulo, autor, editora, numeroPaginas, quantidade);
                        biblioteca.cadastrarLivro(livro);
                        System.out.println("Livro cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Cadastrar Aluno(A) ou Servidor(S)?");
                    char tipo = scanner.next().charAt(0);
                    scanner.nextLine(); // Limpa o buffer do teclado
                    System.out.println("2. Cadastrar Usuário");
                    System.out.print("Digite o CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite a matrícula: ");
                    String matricula = scanner.nextLine();
                    try {
                        if (tipo == 'A') {
                            System.out.print("Digite o curso: ");
                            String curso = scanner.nextLine();
                            UsuarioAluno aluno = new UsuarioAluno(cpf, nome, endereco, telefone, email, matricula, curso);
                            biblioteca.cadastrarUsuario(aluno);
                        } else if (tipo == 'S') {
                            System.out.print("Digite o cargo: ");
                            String cargo = scanner.nextLine();
                            UsuarioServidor servidor = new UsuarioServidor(cpf, nome, endereco, telefone, email, matricula, cargo);
                            biblioteca.cadastrarUsuario(servidor);
                        } else {
                            System.out.println("Tipo inválido");
                        }
                        System.out.println("Usuário cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("3. Emprestar Livro");
                    System.out.print("Digite o CPF do usuário: ");
                    String cpfEmprestimo = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    try {
                        biblioteca.realizarEmprestimo(cpfEmprestimo, isbnEmprestimo);
                        System.out.println("Livro emprestado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Devolver Livro");
                    System.out.print("Digite o CPF do usuário: ");
                    String cpfDevolucao = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnDevolucao = scanner.nextLine();
                    try {
                        biblioteca.devolverLivro(cpfDevolucao, isbnDevolucao);
                        System.out.println("Livro devolvido com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Listar Livros");
                    biblioteca.listarLivros();
                    break;
                case 6:
                    System.out.println("Listar Usuários");
                    biblioteca.listarUsuarios();
                    break;
                case 7:
                    System.out.println("Listar Livros Emprestados");
                    biblioteca.listarLivrosEmprestados();
                    break;
                case 8:
                    System.out.println("8. Remover Livro");
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnRemover = scanner.nextLine();
                    try {
                        biblioteca.removerLivro(isbnRemover);
                        System.out.println("Livro removido com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("9. Remover Usuário");
                    System.out.print("Digite o CPF do usuário: ");
                    String cpfRemover = scanner.nextLine();
                    try {
                        biblioteca.removerUsuario(cpfRemover);
                        System.out.println("Usuário removido com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("10. Editar Livro");
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnEditar = scanner.nextLine();
                    System.out.print("Digite o novo título: ");
                    String novoTitulo = scanner.nextLine();
                    System.out.print("Digite o novo autor: ");
                    String novoAutor = scanner.nextLine();
                    System.out.print("Digite a nova editora: ");
                    String novaEditora = scanner.nextLine();
                    System.out.print("Digite o novo número de páginas: ");
                    int novoNumeroPaginas = scanner.nextInt();
                    System.out.print("Digite a nova quantidade de exemplares: ");
                    int novaQuantidade = scanner.nextInt();
                    try {
                        biblioteca.editarLivro(isbnEditar, novoTitulo, novoAutor, novaEditora, novoNumeroPaginas, novaQuantidade);
                        System.out.println("Livro editado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("11. Editar Usuário");
                    System.out.print("Digite o CPF do usuário: ");
                    String cpfEditar = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo endereço: ");
                    String novoEndereco = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    System.out.print("Digite o novo e-mail: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Digite a nova matrícula: ");
                    String novaMatricula = scanner.nextLine();
                    try {
                        biblioteca.editarUsuario(cpfEditar, novoNome, novoEndereco, novoTelefone, novoEmail, novaMatricula);
                        System.out.println("Usuário editado com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 12:
                    System.out.println("Salvar Dados");
                    try {
                        biblioteca.salvarDados();
                        System.out.println("Dados salvos com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    break;
                case 13:
                    System.out.println("Sair");
                    try {
                        biblioteca.salvarDados();
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados: " + e.getMessage());
                    }
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 13);
    }
}