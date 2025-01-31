public class UsuarioServidor extends Usuario {
    private String cargo;

    public UsuarioServidor(String cpf, String nome, String endereco, String telefone, String email, String matricula, String cargo) {
        super(cpf, nome, endereco, telefone, email, matricula);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean atingiuLimiteEmprestimos() {
        return emprestimos.size() >= 5; // Limite de 5 livros para servidores
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Cargo: %s", cargo);
    }
}