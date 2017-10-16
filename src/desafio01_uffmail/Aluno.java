package desafio01_uffmail;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffmail;
    private String status;

    public String getNome() {
        return nome;
    }

    public String getPrimeiroNome() {
        return nome.split(" ")[0];
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffMail() {
        return uffmail;
    }

    public void setUffMail(String uffmail) {
        this.uffmail = uffmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return getStatus().equals("Ativo");
    }

    public ArrayList<String> criaOpcoesUffMail(Aluno aluno) {

        String[] nomePartes = aluno.getNome().split(" ");
        String primeiroNome = nomePartes[0];
        String nomeMeio = "";
        String ultimoNome;

        if (nomePartes.length > 2) {
            nomeMeio = nomePartes[1];
            ultimoNome = nomePartes[nomePartes.length - 1];
        } else {
            ultimoNome = nomePartes[1];
        }

        ArrayList<String> opcoes = new ArrayList<>();

        opcoes.add((primeiroNome + ultimoNome + "@id.uff.br").toLowerCase());
        opcoes.add((primeiroNome.charAt(0) + ultimoNome + "@id.uff.br").toLowerCase());

        if (!nomeMeio.equals("")) {
            opcoes.add((primeiroNome + "_" + nomeMeio + "@id.uff.br").toLowerCase());
            opcoes.add((primeiroNome + nomeMeio.charAt(0) + ultimoNome.charAt(0) + "@id.uff.br").toLowerCase());
            opcoes.add((primeiroNome.charAt(0) + nomeMeio + ultimoNome + "@id.uff.br").toLowerCase());
        }

        return opcoes;
    }

}
