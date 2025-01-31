package com.biblioteca;

import java.io.*;
import java.util.*;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    // Cadastra um novo usuário na biblioteca
    public void cadastrarUsuario(Usuario usuario) throws Exception {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(usuario.getCpf())) {
                throw new Exception("Usuário com este CPF já está cadastrado.");
            }
        }
        usuarios.add(usuario);
    }

    // Cadastra um novo livro na biblioteca
    public void cadastrarLivro(Livro livro) throws Exception {
        for (Livro l : livros) {
            if (l.getIsbn().equals(livro.getIsbn())) {
                throw new Exception("Livro com este ISBN já está cadastrado.");
            }
        }
        livros.add(livro);
    }

    // Busca um usuário pelo CPF
    public Usuario buscarUsuario(String cpf) throws Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        throw new Exception("Usuário não encontrado.");
    }

    // Busca um livro pelo ISBN
    public Livro buscarLivro(String isbn) throws Exception {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        throw new Exception("Livro não encontrado.");
    }

    // Realiza o empréstimo de um livro para um usuário
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

    // Realiza a devolução de um livro por um usuário
    public void devolverLivro(String cpf, String isbn) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        Livro livro = buscarLivro(isbn);

        if (!usuario.possuiLivroEmprestado(isbn)) {
            throw new Exception("Usuário não possui este livro emprestado.");
        }

        livro.devolver();
        usuario.removerEmprestimo(isbn);
    }

    // Lista todos os usuários cadastrados na biblioteca
    public void listarUsuarios() {
        List<Usuario> usuariosOrdenados = new ArrayList<>(usuarios);
        Collections.sort(usuariosOrdenados, Comparator.comparing(Usuario::getNome));
        for (Usuario u : usuariosOrdenados) {
            System.out.println(u);
        }
    }

    // Lista todos os livros cadastrados na biblioteca
    public void listarLivros() {
        List<Livro> livrosOrdenados = new ArrayList<>(livros);
        Collections.sort(livrosOrdenados, Comparator.comparing(Livro::getTitulo));
        for (Livro l : livrosOrdenados) {
            System.out.println("ISBN: " + l.getIsbn() + ", Título: " + l.getTitulo() + ", Autor: " + l.getAutores() + ", Editora: " + l.getEditora() + ", Páginas: " + l.getNumeroPaginas() + ", Quantidade: " + l.getQuantidade());
        }
    }

    // Salva os dados dos usuários e livros em um arquivo
    public void salvarDados(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(usuarios);
            oos.writeObject(livros);
        }
    }

    // Carrega os dados dos usuários e livros de um arquivo
    public void carregarDados(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            usuarios = (List<Usuario>) ois.readObject();
            livros = (List<Livro>) ois.readObject();
        }
    }

    // Edita os dados de um usuário existente
    public void editarUsuario(String cpf, Usuario novoUsuario) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        usuarios.remove(usuario);
        usuarios.add(novoUsuario);
    }

    // Edita os dados de um livro existente
    public void editarLivro(String isbn, Livro novoLivro) throws Exception {
        Livro livro = buscarLivro(isbn);
        livros.remove(livro);
        livros.add(novoLivro);
    }

    // Remove um usuário da biblioteca
    public void removerUsuario(String cpf) throws Exception {
        Usuario usuario = buscarUsuario(cpf);
        usuarios.remove(usuario);
    }

    // Remove um livro da biblioteca
    public void removerLivro(String isbn) throws Exception {
        Livro livro = buscarLivro(isbn);
        livros.remove(livro);
    }

    // Lista todos os usuários por tipo (Aluno ou Servidor)
    public void listarUsuariosPorTipo(Class<? extends Usuario> tipo) {
        for (Usuario usuario : usuarios) {
            if (tipo.isInstance(usuario)) {
                System.out.println(usuario);
            }
        }
    }
}
