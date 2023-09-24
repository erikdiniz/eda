package eda.com;

public class TabelaHash {
    private  Aluno[] tabela;

    public TabelaHash(){
        this.tabela = new Aluno[20];
    }

    public int hash(int chave){
        return chave % tabela.length;
    }

    public Aluno get(int chave){
        int hash = hash(chave);
        return tabela[hash];
    }

    public void put(int chave, Aluno aluno){
        int hash = hash(chave);

        this.tabela[hash] = aluno;
    }

    public Aluno remove(int chave){
        int hash = hash(chave);
        Aluno aluno = tabela[hash];
        this.tabela[hash] = null;
        
        return aluno;
    }
}
