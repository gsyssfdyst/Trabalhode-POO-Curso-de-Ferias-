public class UsuarioAluno extends Usuario {
    private String curso;

    public UsuarioAluno(String cpf, String nome, String endereco, String telefone, String email, String matricula, String curso) {
        super(cpf, nome, endereco, telefone, email, matricula);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public boolean atingiuLimiteEmprestimos() {
        return emprestimos.size() >= 3; // Limite de 3 livros para alunos
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Curso: %s", curso);
    }
}
