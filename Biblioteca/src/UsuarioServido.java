public class UsuarioServido extends Usuario {
    private  String cargo;

    public UsuarioServido(String cpf, String nome, String endereco, String telefone, String email, String matricula, String cargo) {
        super(cpf, nome, endereco, telefone, email, matricula);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
