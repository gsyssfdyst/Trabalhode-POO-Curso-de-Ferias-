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
}
