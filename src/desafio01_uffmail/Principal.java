package desafio01_uffmail;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Interface interage = new Interface();
        Arquivo listaAlunos = new Arquivo();
        Aluno aluno = listaAlunos.buscaAluno(interage.informaMatricula());

        if (aluno == null) {
            interage.alunoInexistente();
        } else if (aluno.isAtivo() == false) {
            interage.alunoInativo();
        } else {
            ArrayList<String> opcoes = aluno.criaOpcoesUffMail(aluno);
            interage.escolheUffmail(aluno, opcoes);
        }
    }
}
