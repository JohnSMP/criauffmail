package desafio01_uffmail;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {

    Scanner in = new Scanner(System.in);

    public String informaMatricula() {
        System.out.println("Informe a sua matrícula : ");
        return in.nextLine();
    }

    public void alunoInexistente() {
        System.out.println("\nO aluno não existe.");
    }

    public void alunoInativo() {
        System.out.println("\nApenas alunos ativos podem criar um UFFMail.");
    }

    public void possuiUffmail() {
        System.out.println("\nEsse aluno já possui um UFFMail.");
    }

    public void escolheUffmail(Aluno aluno, ArrayList<String> opcoes) {
        int opcao = 0;
        while (opcao < 1 || opcao > opcoes.size()) {
            System.out.println("\n" + aluno.getPrimeiroNome() + ", Por favor escolha uma das opções abaixo para o seu UFFMail :\n");
            for (int i = 0; i < opcoes.size(); i++) {
                System.out.println((i + 1) + " - " + opcoes.get(i));
            }
            opcao = in.nextInt();
        }
        aluno.setUffMail(opcoes.get(opcao - 1));

        System.out.println("\nA criação de seu e-mail (" + aluno.getUffMail() + ") será feita nos próximos minutos.\n"
                + "Um SMS foi enviado para " + aluno.getTelefone() + " com a sua senha de acesso. Obrigado :)");
    }
}
