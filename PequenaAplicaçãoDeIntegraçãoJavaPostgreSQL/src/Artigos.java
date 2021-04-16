public class Artigos {
    protected int artigoid;
    protected String titulo;
    protected int tipoid;
    protected int edicaoid;
    protected Edicoes edicao;

    public Artigos(){

    }

    public String toString() {
        if(edicao == null)
		    return "Id:" + artigoid + "    Título:" + titulo + "    Tipo Id:" + tipoid + 
            "   Edição id:" + edicaoid;
        else
            return "Id:" + artigoid + "    Título:" + titulo + "    Tipo Id:" + tipoid + 
            "   Edição id:" + edicaoid + "    Cidade:" + edicao.getCidade() + "    Uf:" +
            edicao.getUf() + "   Quantidade de participantes:" + edicao.getQtdparticipantes() 
            + "    Ano:" + edicao.getAno();
	}

    public int getArtigoid() {
        return this.artigoid;
    }

    public void setArtigoid(int artigoid) {
        this.artigoid = artigoid;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipoid() {
        return this.tipoid;
    }

    public void setTipoid(int tipoid) {
        this.tipoid = tipoid;
    }

    public int getEdicaoid() {
        return this.edicaoid;
    }

    public void setEdicaoid(int edicaoid) {
        this.edicaoid = edicaoid;
    }

    public Edicoes getEdicao() {
        return this.edicao;
    }

    public void setEdicao(Edicoes edicao) {
        this.edicao = edicao;
    }
}
