package eda.com;

public class TabelaHashEnderecamento {
    private Aluno[] tabela;
    private int size;
    private double fatorDeCarga;

    private static final Aluno APAGADO = new Aluno(Integer.MIN_VALUE, "APAGADO");

    public TabelaHashEnderecamento(){
        this.tabela = new Aluno[20];
        this.size = 0;
        this.fatorDeCarga = 0.75;
    }

    public int hash(int chave){
        return chave % this.tabela.length;
    }

    public int hashMultiplicacao(int chave){
        double a = 0.4845184248;
        double hash = chave*a;
        hash = (hash % 1) * tabela.length;
        return (int)hash;
    }

    public void put(int chave, Aluno valor){
        if (this.size/this.tabela.length >= this.fatorDeCarga){
            resize();
            put(chave, valor);

        } else {
            int hash = hashMultiplicacao(chave);
            tabela[hash] = valor;
            this.size += 1;
        }
    }

    private void resize(){
        Aluno[] novaTabela = new Aluno[tabela.length*2];
        Aluno[] tabelaCopia = this.tabela;

        this.tabela = novaTabela;

        for (Aluno aluno : tabelaCopia){
            if (aluno != null){
                int hash = hashMultiplicacao(aluno.getMatricula());
                tabela[hash] = aluno;
            }
        }
    }

    public Aluno remove(int chave){
        int sondagem = 0;
        int hash;

        while (sondagem < tabela.length){
            hash = (hashMultiplicacao(chave) + sondagem) % tabela.length;

            if (tabela[hash] != null && tabela[hash].getMatricula() == chave) {
                Aluno aluno = tabela[hash];
                tabela[hash] = APAGADO;
                this.size -= 1;
                return aluno;
            }
            sondagem += 1;
        }

        return null;
    }

    public Aluno get(int chave){
        int hash;
        int sondagem = 0;

        while (sondagem < tabela.length){
            hash = (hashMultiplicacao(chave) + sondagem) % 
            tabela.length;
            
            if (tabela[hash] == null)
                return null;
            
            if (tabela[hash].getMatricula() == chave){
                return tabela[hash];
            }
            sondagem += 1;
        }

        return null;        
    }

    public int size(){
        return this.size;
    }
}
