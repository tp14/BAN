public class Edicoes {
    protected int edicaoid;
    protected String cidade;
    protected String uf;
    protected int qtdparticipantes;
    protected int ano;

    public Edicoes(){
        
    }

    public String toString() {
		return "Id:" + edicaoid + "    Cidade:" + cidade + "    Uf:" + uf + 
        "   Quantidade de participantes:" + qtdparticipantes + "    Ano:" + ano;
	}

    public int getEdicaoid() {
        return this.edicaoid;
    }

    public void setEdicaoid(int edicaoid) {
        this.edicaoid = edicaoid;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getQtdparticipantes() {
        return this.qtdparticipantes;
    }

    public void setQtdparticipantes(int qtdparticipantes) {
        this.qtdparticipantes = qtdparticipantes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
