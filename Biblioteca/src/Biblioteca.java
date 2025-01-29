import java.util.*;

public class Biblioteca {
    private Map<String, Usuario> usuarios; // Usando HashMap para usuários
    private Map<String, Livro> livros;     // Usando HashMap para livros

    public Biblioteca() {
        this.usuarios = new HashMap<>();
        this.livros = new HashMap<>();
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception {
        if (usuarios.containsKey(usuario.getCpf())) {
            throw new Exception("Usuário com este CPF já está cadastrado.");
        }
        usuarios.put(usuario.getCpf(), usuario);
    }

    public void cadastrarLivro(Livro livro) throws Exception {
        if (livros.containsKey(livro.getIsbn())) {
            throw new Exception("Livro com este ISBN já está cadastrado.");
        }
        livros.put((String) livro.getIsbn(), livro);
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
    }

    public void listarUsuarios() {
        List<Usuario> usuariosOrdenados = new ArrayList<>(usuarios.values());
        Collections.sort(usuariosOrdenados, Comparator.comparing(Usuario::getNome));
        for (Usuario u : usuariosOrdenados) {
            System.out.println(u);
        }
    }

    public void listarLivros() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros.values());
        Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
        for (Livro l : livrosOrdenados) {
            System.out.println(l);
        }
    }
}