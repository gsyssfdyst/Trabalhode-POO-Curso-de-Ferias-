package com.biblioteca;

import .

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
        System.out.println("7. Editar Livro");
        System.out.println("8. Editar Usuário");
        System.out.println("9. Remover Livro");
        System.out.println("10. Remover Usuário");
        System.out.println("11. Salvar Dados");
        System.out.println("12. Carregar Dados");
        System.out.println("13. Listar Usuários por Tipo");
        System.out.println("14. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
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
            try {
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
                        Livro livro = new Livro(isbn, titulo, autor, editora, numeroPaginas, quantidade);
                        biblioteca.cadastrarLivro(livro);
                        System.out.println("Livro cadastrado com sucesso!");
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
                        break;
                    case 3:
                        System.out.println("3. Emprestar Livro");
                        System.out.print("Digite o CPF do usuário: ");
                        String cpfEmprestimo = scanner.nextLine();
                        System.out.print("Digite o ISBN do livro: ");
                        String isbnEmprestimo = scanner.nextLine();
                        biblioteca.realizarEmprestimo(cpfEmprestimo, isbnEmprestimo);
                        System.out.println("Livro emprestado com sucesso!");
                        break;
                    case 4:
                        System.out.println("Devolver Livro");
                        System.out.print("Digite o CPF do usuário: ");
                        String cpfDevolucao = scanner.nextLine();
                        System.out.print("Digite o ISBN do livro: ");
                        String isbnDevolucao = scanner.nextLine();
                        biblioteca.devolverLivro(cpfDevolucao, isbnDevolucao);
                        System.out.println("Livro devolvido com sucesso!");
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
                        System.out.println("Editar Livro");
                        System.out.print("Digite o ISBN do livro a ser editado: ");
                        String isbnEditar = scanner.nextLine();
                        System.out.print("Digite o novo título: ");
                        String novoTitulo = scanner.nextLine();
                        System.out.print("Digite o novo autor: ");
                        String novoAutor = scanner.nextLine();
                        System.out.println("Digite a nova editora: ");
                        String novaEditora = scanner.nextLine();
                        System.out.print("Digite o novo número de páginas: ");
                        int novoNumeroPaginas = scanner.nextInt();
                        System.out.print("Digite a nova quantidade de exemplares: ");
                        int novaQuantidade = scanner.nextInt();
                        Livro novoLivro = new Livro(isbnEditar, novoTitulo, novoAutor, novaEditora, novoNumeroPaginas, novaQuantidade);
                        biblioteca.editarLivro(isbnEditar, novoLivro);
                        System.out.println("Livro editado com sucesso!");
                        break;
                    case 8:
                        System.out.println("Editar Usuário");
                        System.out.print("Digite o CPF do usuário a ser editado: ");
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
                        System.out.print("Digite o tipo de usuário (A para Aluno, S para Servidor): ");
                        char novoTipo = scanner.next().charAt(0);
                        scanner.nextLine(); // Limpa o buffer do teclado
                        if (novoTipo == 'A') {
                            System.out.print("Digite o novo curso: ");
                            String novoCurso = scanner.nextLine();
                            UsuarioAluno novoAluno = new UsuarioAluno(cpfEditar, novoNome, novoEndereco, novoTelefone, novoEmail, novaMatricula, novoCurso);
                            biblioteca.editarUsuario(cpfEditar, novoAluno);
                        } else if (novoTipo == 'S') {
                            System.out.print("Digite o novo cargo: ");
                            String novoCargo = scanner.nextLine();
                            UsuarioServidor novoServidor = new UsuarioServidor(cpfEditar, novoNome, novoEndereco, novoTelefone, novoEmail, novaMatricula, novoCargo);
                            biblioteca.editarUsuario(cpfEditar, novoServidor);
                        } else {
                            System.out.println("Tipo inválido");
                        }
                        System.out.println("Usuário editado com sucesso!");
                        break;
                    case 9:
                        System.out.println("Remover Livro");
                        System.out.print("Digite o ISBN do livro a ser removido: ");
                        String isbnRemover = scanner.nextLine();
                        biblioteca.removerLivro(isbnRemover);
                        System.out.println("Livro removido com sucesso!");
                        break;
                    case 10:
                        System.out.println("Remover Usuário");
                        System.out.print("Digite o CPF do usuário a ser removido: ");
                        String cpfRemover = scanner.nextLine();
                        biblioteca.removerUsuario(cpfRemover);
                        System.out.println("Usuário removido com sucesso!");
                        break;
                    case 11:
                        System.out.println("Salvar Dados");
                        System.out.print("Digite o nome do arquivo: ");
                        String arquivoSalvar = scanner.nextLine();
                        biblioteca.salvarDados(arquivoSalvar);
                        System.out.println("Dados salvos com sucesso!");
                        break;
                    case 12:
                        System.out.println("Carregar Dados");
                        System.out.print("Digite o nome do arquivo: ");
                        String arquivoCarregar = scanner.nextLine();
                        biblioteca.carregarDados(arquivoCarregar);
                        System.out.println("Dados carregados com sucesso!");
                        break;
                    case 13:
                        System.out.println("Listar Usuários por Tipo");
                        System.out.print("Digite o tipo de usuário (A para Aluno, S para Servidor): ");
                        char tipoListar = scanner.next().charAt(0);
                        if (tipoListar == 'A') {
                            biblioteca.listarUsuariosPorTipo(UsuarioAluno.class);
                        } else if (tipoListar == 'S') {
                            biblioteca.listarUsuariosPorTipo(UsuarioServidor.class);
                        } else {
                            System.out.println("Tipo inválido");
                        }
                        break;
                    case 14:
                        System.out.println("Sair");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcao != 14);
    }
}
