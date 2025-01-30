import java.time.LocalDate;

public class Lancamento {
    private String isbn;
    private String matricula;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Lancamento(String isbn, String matricula, LocalDate dataEmprestimo) {
        this.isbn = isbn;
        this.matricula = matricula;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
