import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String matricula;
    private List<Emprestimo> emprestimos;


    public Usuario(String cpf, String nome, String endereco, String telefone, String email, String matricula) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.matricula = matricula;
        this.emprestimos = new ArrayList<>();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean possuiLivroEmprestado(String isbn) {
        return emprestimos.stream().anyMatch(e -> e.getIsbn().equals(isbn));
    }

    public boolean atingiuLimiteEmprestimos() {
        return emprestimos.size() >= getLimiteEmprestimos();
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void removerEmprestimo(String isbn) {
        this.emprestimos.removeIf(e -> e.getIsbn().equals(isbn));
    }
}