package desafio01_uffmail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    BufferedReader br = null;
    String linha;
    Aluno aluno = null;

    public Aluno buscaAluno(String matricula) {

        try {
            br = new BufferedReader(new FileReader("arquivo.csv"));

            while ((linha = br.readLine()) != null) {
                String[] camposAluno = linha.split(",");

                if (camposAluno[1].equals(matricula)) {
                    aluno = new Aluno();
                    aluno.setNome(camposAluno[0]);
                    aluno.setMatricula(camposAluno[1]);
                    aluno.setTelefone(camposAluno[2]);
                    aluno.setEmail(camposAluno[3]);
                    aluno.setUffMail(camposAluno[4]);
                    aluno.setStatus(camposAluno[5]);
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

    public void atualizaArquivo(Aluno aluno) {
        ArrayList<Aluno> arrayAlunos = getListaAlunos(aluno);
        salvaNoArquivo(arrayAlunos);
    }

    public ArrayList<Aluno> getListaAlunos(Aluno aluno) {
        ArrayList<Aluno> arrayAlunos = new ArrayList<>();

        try {
            br = new BufferedReader(new FileReader("arquivo.csv"));
            Aluno alunoLido;

            while ((linha = br.readLine()) != null) {
                String[] camposAluno = linha.split(",");

                alunoLido = new Aluno();
                alunoLido.setNome(camposAluno[0]);
                alunoLido.setMatricula(camposAluno[1]);
                alunoLido.setTelefone(camposAluno[2]);
                alunoLido.setEmail(camposAluno[3]);
                alunoLido.setUffMail(camposAluno[4]);
                alunoLido.setStatus(camposAluno[5]);

                if (alunoLido.getMatricula().equals(aluno.getMatricula())) {
                    alunoLido.setUffMail(aluno.getUffMail());
                }
                arrayAlunos.add(alunoLido);
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
        return arrayAlunos;
    }

    public void salvaNoArquivo(ArrayList<Aluno> arrayAlunos) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("arquivo.csv");

            for (int i = 0; i < arrayAlunos.size(); i++) {
                fileWriter.append(arrayAlunos.get(i).getNome());
                fileWriter.append(",");
                fileWriter.append(arrayAlunos.get(i).getMatricula());
                fileWriter.append(",");
                fileWriter.append(arrayAlunos.get(i).getTelefone());
                fileWriter.append(",");
                fileWriter.append(arrayAlunos.get(i).getEmail());
                fileWriter.append(",");
                fileWriter.append(arrayAlunos.get(i).getUffMail());
                fileWriter.append(",");
                fileWriter.append(arrayAlunos.get(i).getStatus());
                fileWriter.append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}