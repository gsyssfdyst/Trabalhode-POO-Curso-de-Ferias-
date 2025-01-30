import java.util.*;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Livro> livros;

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
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        throw new Exception("Usuário não encontrado.");
    }

    public Livro buscarLivro(String isbn) throws Exception {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        throw new Exception("Livro não encontrado.");
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
        usuario.adicionarEmprestimo(new Emprestimo(isbn, cpf));
    }

    public void devolverLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (!usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário não possui este livro emprestado.");
        }

        livro.devolver();
        usuario.removerEmprestimo(isbn);
    }

    public void listarUsuarios() {
        List<Usuario> usuariosOrdenados = new ArrayList<>(usuarios);
        Collections.sort(usuariosOrdenados, Comparator.comparing(Usuario::getNome));
        for (Usuario u : usuariosOrdenados) {
            System.out.println(u);
        }
    }

    public void listarLivros() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
        for (Livro l : livrosOrdenados) {
            System.out.println("ISBN: " + l.getIsbn() + ", Título: " + l.getTitulo() + ", Autor: " + l.getAutores() + ", Editora: " + l.getEditora() + ", Páginas: " + l.getNumeroPaginas() + ", Quantidade: " + l.getQuantidade());
        }
    }

    public static void EmprestarLivro(String isbn, String matricula) {
        // Implementação do método EmprestarLivro
        System.out.println("Livro emprestado: ISBN " + isbn + ", Matrícula " + matricula);
    }

    public static void DevolverLivro(String isbn, String matricula) {
        // Implementação do método DevolverLivro
        System.out.println("Livro devolvido com sucesso!");
    }
}