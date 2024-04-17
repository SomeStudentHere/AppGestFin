package clases;

import java.io.*;
import java.util.LinkedList;

public class ContaManager {
    private LinkedList<Conta> contas;
    private Conta contaAtual;

    public ContaManager() throws IOException {
        //se ficheiro contas.txt existir carrega as contas na lista
        File contasFile = new File("contas.txt");
        if (contasFile.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(contasFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    contas.add(new Conta(data[0], data[1]));
                }
            } catch (IOException e) {
                throw new IOException(e);
            }
        }
        this.contas = new LinkedList<Conta>();
    }

    public void salvarContas() throws FileNotFoundException, UnsupportedEncodingException {
        //escreve as contas no ficheiro contas.txt
        PrintWriter writer = new PrintWriter("contas.txt", "UTF-8");
        for (var conta: contas){
            writer.write(conta.getNome() + "," + conta.getPassword() + "\n");
        }
        writer.close();
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
