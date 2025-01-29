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
                    break;
                case 2:
                    System.out.println("2. Cadastrar Usuário");
                    break;
                case 3:
                    System.out.println("3. Emprestar Livro");
                    break;
                case 4:
                    System.out.println("Devolver Livro");
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