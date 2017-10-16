package desafio01_uffmail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio01_UFFMail {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("alunos.csv"));
        String line = null;
        Scanner scan = null;
        int index = 0;
        List<Aluno> listaAluno = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Aluno aluno = new Aluno();
            scan = new Scanner(line);
            scan.useDelimiter(",");

            while (scan.hasNext()) {
                String info = scan.next();
                if (index == 0) {
                    aluno.setNome(info);
                } else if (index == 1) {
                    aluno.setMatricula(info);
                } else if (index == 2) {
                    aluno.setTelefone(info);
                } else if (index == 3) {
                    aluno.setEmail(info);
                } else if (index == 4) {
                    aluno.setUffMail(info);
                } else if (index == 5) {
                    aluno.setStatus(info);
                }
                index++;
            }
            index = 0;
            listaAluno.add(aluno);
        }

        //close reader
        reader.close();

        System.out.println(listaAluno);

    }

}
