import java.io.Serializable;

public class Emprestimo implements Serializable {
    private String isbn;
    private String cpf;

    public Emprestimo(String isbn, String cpf) {
        this.isbn = isbn;
        this.cpf = cpf;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCpf() {
        return cpf;
    }
}
