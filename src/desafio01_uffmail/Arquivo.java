package desafio01_uffmail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

    BufferedReader br = null;
    String linha;
    Aluno aluno = null;

    public Aluno buscaAluno(String matricula) {

        try {

            br = new BufferedReader(new FileReader("arquivo.csv"));

            while ((linha = br.readLine()) != null) {

                String[] alunos = linha.split(",");

                if (alunos[1].equals(matricula)) {
                    aluno = new Aluno();
                    aluno.setNome(alunos[0]);
                    aluno.setMatricula(alunos[1]);
                    aluno.setTelefone(alunos[2]);
                    aluno.setEmail(alunos[3]);
                    aluno.setUffMail(alunos[4]);
                    aluno.setStatus(alunos[5]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return aluno;
    }

//    void trocaUffmail(Aluno aluno) throws IOException {
//        File input = new File("arquivo.csv");
//        FileWriter write = new FileWriter("arquivo.csv");
//        br = new BufferedReader(new FileReader("arquivo.csv"));
//        int i = 0;
//        while ((linha = br.readLine()) != null) {
//            String[] alunos = linha.split(",");
//            i++;
//        }
//
//    }
}
