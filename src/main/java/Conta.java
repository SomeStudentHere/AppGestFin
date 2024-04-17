import java.util.Objects;

public class Conta {
    private String nome;
    private String password;

    public Conta(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public Boolean nomeValid(String nomeToVerify) {
        return nomeToVerify.compareTo(nome) == 0;
    }

    public Boolean passwordValid(String passToVerify) {
        return passToVerify.compareTo(password) == 0;
    }
}
