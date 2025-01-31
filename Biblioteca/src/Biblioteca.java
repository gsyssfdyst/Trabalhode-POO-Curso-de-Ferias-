import java.util.*;
import java.io.*;

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

        // Verifica se o usuário já possui o livro emprestado
        if (usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("O usuário já possui este livro emprestado.");
        }

        // Verifica se o usuário atingiu seu limite de empréstimos
        if (usuario.atingiuLimiteEmprestimos()) {
            throw new Exception("Usuário atingiu o limite de empréstimos.");
        }

        // Verifica se há exemplares disponíveis
        if (livro.getQuantidade() <= 0) {
            throw new Exception("Não há exemplares disponíveis deste livro no momento.");
        }

        // Realiza o empréstimo
        livro.emprestar();
        usuario.adicionarEmprestimo(new Emprestimo(isbn, cpf));
    }

    public void devolverLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        // Verifica se o usuário possui o livro emprestado
        if (!usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário não possui este livro emprestado.");
        }

        // Realiza a devolução
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

    public void EmprestarLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário já possui este livro emprestado.");
        }
        if (usuario.atingiuLimiteEmprestimos()) {
            throw new Exception("Usuário atingiu o limite de empréstimos.");
        }
        if (livro.getQuantidade() <= 0) {
            throw new Exception("Não há exemplares disponíveis deste livro.");
        }

        usuario.adicionarEmprestimo(new Emprestimo(isbn, cpf));
        livro.setQuantidade(livro.getQuantidade() - 1);
        System.out.println("Livro '" + livro.getTitulo() + "' emprestado com sucesso para " + usuario.getNome() + ".");
    }

    public void DevolverLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (!usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário não possui este livro emprestado.");
        }

        usuario.removerEmprestimo(isbn);
        livro.setQuantidade(livro.getQuantidade() + 1);
        System.out.println("Livro '" + livro.getTitulo() + "' devolvido com sucesso por " + usuario.getNome() + ".");
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros emprestados:");
        for (Usuario usuario : usuarios) {
            for (Emprestimo emprestimo : usuario.getEmprestimos()) {
                Livro livro = buscarLivro(emprestimo.getIsbn());
                System.out.println("- " + livro.getTitulo() + " - " + usuario.getNome() + " - " + emprestimo.getDataEmprestimo());
            }
        }
    }

    public void salvarDados() throws IOException {
        try (PrintWriter pwUsuarios = new PrintWriter(new FileWriter("usuarios.txt"));
             PrintWriter pwLivros = new PrintWriter(new FileWriter("livros.txt"))) {
            for (Usuario usuario : usuarios) {
                if (usuario instanceof UsuarioAluno) {
                    UsuarioAluno aluno = (UsuarioAluno) usuario;
                    pwUsuarios.println(String.join(",", aluno.getCpf(), aluno.getNome(), aluno.getEndereco(), aluno.getTelefone(), aluno.getEmail(), aluno.getMatricula(), "A", aluno.getCurso()));
                } else if (usuario instanceof UsuarioServidor) {
                    UsuarioServidor servidor = (UsuarioServidor) usuario;
                    pwUsuarios.println(String.join(",", servidor.getCpf(), servidor.getNome(), servidor.getEndereco(), servidor.getTelefone(), servidor.getEmail(), servidor.getMatricula(), "S", servidor.getCargo()));
                }
            }
            for (Livro livro : livros) {
                pwLivros.println(String.join(",", livro.getIsbn(), livro.getTitulo(), livro.getAutores(), livro.getEditora(), String.valueOf(livro.getNumeroPaginas()), String.valueOf(livro.getQuantidade())));
            }
        }
    }

    public void carregarDados() throws IOException {
        usuarios.clear();
        livros.clear();
        try (BufferedReader brUsuarios = new BufferedReader(new FileReader("usuarios.txt"));
             BufferedReader brLivros = new BufferedReader(new FileReader("livros.txt"))) {
            String linha;
            while ((linha = brUsuarios.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 8 && campos[6].equals("A")) {
                    usuarios.add(new UsuarioAluno(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[7]));
                } else if (campos.length >= 8 && campos[6].equals("S")) {
                    usuarios.add(new UsuarioServidor(campos[0], campos[1], campos[2], campos[3], campos[4], campos[5], campos[7]));
                }
            }
            while ((linha = brLivros.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length >= 6) {
                    livros.add(new Livro(campos[0], campos[1], campos[2], campos[3], Integer.parseInt(campos[4]), Integer.parseInt(campos[5])));
                }
            }
        }
    }

    public void removerLivro(String isbn) throws Exception {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livros.remove(livro);
        } else {
            throw new Exception("Livro não encontrado.");
        }
    }

    public void removerUsuario(String cpf) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        if (usuario != null) {
            usuarios.remove(usuario);
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }

    public void editarLivro(String isbn, String novoTitulo, String novoAutor, String novaEditora, int novoNumeroPaginas, int novaQuantidade) throws Exception {
        Livro livro = buscarLivro(isbn);
        if (livro != null) {
            livro.setTitulo(novoTitulo);
            livro.setAutores(novoAutor);
            livro.setEditora(novaEditora);
            livro.setNumeroPaginas(novoNumeroPaginas);
            livro.setQuantidade(novaQuantidade);
        } else {
            throw new Exception("Livro não encontrado.");
        }
    }

    public void editarUsuario(String cpf, String novoNome, String novoEndereco, String novoTelefone, String novoEmail, String novaMatricula) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        if (usuario != null) {
            usuario.setNome(novoNome);
            usuario.setEndereco(novoEndereco);
            usuario.setTelefone(novoTelefone);
            usuario.setEmail(novoEmail);
            usuario.setMatricula(novaMatricula);
        } else {
            throw new Exception("Usuário não encontrado.");
        }
    }
}