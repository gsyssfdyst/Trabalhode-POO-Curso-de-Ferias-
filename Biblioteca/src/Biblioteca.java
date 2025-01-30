import java.util.*;

public class Biblioteca {
   private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    
    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();

    }

   

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(usuario.getCpf())) {
                throw new Exception("Usuário com este CPF já está cadastrado.");
            }
        }
        usuarios.add(usuario);
    }

    public void cadastrarLivro(Livro livro) throws Exception {
        for (Livro l : livros) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                throw new Exception("Livro com este ISBN já está cadastrado.");
            }
        }
        livros.add(livro);
    }

    public Usuario buscarUsuario(String cpf) throws Exception {
        Usuario usuario = usuarios.get(cpf);
        if (usuario == null) {
            throw new Exception("Usuário não encontrado.");
        }
        return usuario;
    }

    public Livro buscarLivro(String isbn) throws Exception {
        Livro livro = livros.get(isbn);
        if (livro == null) {
            throw new Exception("Livro não encontrado.");
        }
        return livro;
    }

    public void realizarEmprestimo(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário já possui este livro emprestado.");
        }
        if (usuario.atingiuLimiteEmprestimos()) {
            throw new Exception("Usuário atingiu o limite de empréstimos.");
        }

        livro.emprestar();
        usuario.adicionarEmprestimo(new Emprestimo(isbn, cpf, new Date()));
    }

    public void devolverLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (!usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário não possui este livro emprestado.");
        }

        livro.devolver();
        usuario.removerEmprestimo(isbn);
    //public static void listarUsuarios() {
        List<Usuario> usuariosOrdenados = new ArrayList<>(usuarios.values());
        Collections.sort(usuariosOrdenados, Comparator.comparing(Usuario::getNome));
        for (Usuario u : usuariosOrdenados) {
            System.out.println(u);
        }


    public static void listarUsuarios() {
        // Implementação do método listarUsuarios

        System.out.println("Listando usuários...");

    }

    
// Parte 2 do exercício

    public static void EmprestarLivro(String isbn, String matricula) {

        // Implementação do método EmprestarLivro

        System.out.println("Livro emprestado: ISBN " + isbn + ", Matrícula " + matricula);

    }

    public static void DevolverLivro(String isbn, String matricula) {

        // Implement the logic to return a book here

        System.out.println("Livro devolvido com sucesso!");

    }

     public static void listarLivros() {
        // Implementação do método listarLivros
        List<Livro> livrosOrdenados = new ArrayList<>(livros.values());
        Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
        for (Livro l : livrosOrdenados) {
            System.out.println(l);
        }


        System.out.println("Listando livros...");
     
    }



}

    }
}