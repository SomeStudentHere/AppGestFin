import java.util.LinkedList;
import java.util.Objects;

public class ContaManager {
    private LinkedList<Conta> contas;
    private Conta contaAtual;

    public ContaManager() {
        //se ficheiro contas.txt existir carrega as contas na lista
        this.contas = new LinkedList<Conta>();
    }

    public void salvarContas(){
        //escreve as contas no ficheiro contas.txt
    }

    public boolean contaExist(String nome){

    }

    public boolean login(String nome, String password){
        //tenta fazer login numa conta
        for (var conta: contas){
            if (conta.nomeValid(nome)){
                if (conta.passwordValid(password)){
                    return true;
                }
                return false;
            }
        }

        throw new IllegalArgumentException("Conta não encontrada!");
    }
}
