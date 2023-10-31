package algoritmos;
import java.util.ArrayList;

import solucoes.Aluno;

public class TabelaHashEncadeamento {
    private  ArrayList<Aluno>[] tabela;

    public TabelaHashEncadeamento(){
        this.tabela = new ArrayList[20];
    }

    public int hash(int chave){
        return chave % tabela.length;
    }

    public Aluno get(int chave){
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null)
            return null;
        
        for (Aluno aluno : alunos){
            if (aluno.getMatricula() == chave){
                return aluno;
            }
        }

        return null;
    }

    public void put(int chave, Aluno valor){
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null){
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;
        }
    }

    public Aluno remove(int chave){
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        for (Aluno aluno : alunos){
            if (aluno.getMatricula() == chave){
                alunos.remove(aluno);
                return aluno;
            }
        }

        return null;
    }
}
