package clases;

import java.util.LinkedList;

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

    public boolean contaExist(String nome) {
        //verifica se uma conta existe
        for (var conta : contas) {
            if (conta.nomeValid(nome)) {
                return true;
            }
        }
        return false;
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
        throw new IllegalArgumentException("clases.Conta não encontrada!");
    }
}
