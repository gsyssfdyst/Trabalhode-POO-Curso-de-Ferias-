public class Livro {
    private String isbn;
    private String titulo;
    private String autores;
    private String editora;
    private int numeroPaginas;
    private int quantidade;

public  Livro(String isnn, String titulo, String autores, String editora, int numeroPaginas, int quantidade) {
    this.isbn = isnn;
    this.titulo = titulo;
    this.autores = autores;
    this.editora = editora;
    this.numeroPaginas = numeroPaginas;
    this.quantidade = quantidade;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}
