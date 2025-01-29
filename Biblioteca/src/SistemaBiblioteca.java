import java.util.Scanner;

public class SistemaBiblioteca {
    private static void menu() {
        System.out.println("\n===== MENU DA BIBLIOTECA =====");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Cadastrar Usuário");
        System.out.println("3. Emprestar Livro");
        System.out.println("4. Devolver Livro");
        System.out.println("5. Listar Livros");
        System.out.println("6. Listar Usuários");
        System.out.println("7. Sair");
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
                    break;
                case 2:
                    System.out.println("Cadastrar Aluno(A) ou Servidor(S)?");
                    char tipo = scanner.next().charAt(0);
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
                    } else if (tipo == 'S') {
                        System.out.print("Digite o cargo: ");
                        String cargo = scanner.nextLine();
                    } else {
                        System.out.println("Tipo inválido");
                    }

                    break;
                case 3:
                    System.out.println("3. Emprestar Livro");
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário: ");
                    String matriculaEmprestimo = scanner.nextLine();
                    Biblioteca.EmprestarLivro(isbnEmprestimo, matriculaEmprestimo);
                    break;
                case 4:
                    System.out.println("Devolver Livro");
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnDevolucao = scanner.nextLine();
                    System.out.print("Digite a matrícula do usuário: ");
                    String matriculaDevolucao = scanner.nextLine();
                    Biblioteca.DevolverLivro(isbnDevolucao, matriculaDevolucao);
                    break;
                
                case 5:
                    System.out.println("Listar Livros");
                    break;
                case 6:
                    System.out.println("Listar Usuários");
                    break;
                case 7:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 7);





    }



}