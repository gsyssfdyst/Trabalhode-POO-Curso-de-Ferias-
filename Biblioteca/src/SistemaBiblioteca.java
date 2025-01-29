import java.util.Scanner;

public class SistemaBiblioteca {
    private static void menu() {
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        do {
            menu();
            opcao = scanner.nextInt();
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