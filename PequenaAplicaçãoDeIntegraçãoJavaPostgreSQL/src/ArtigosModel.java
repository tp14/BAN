import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtigosModel {
    private static ArtigosModel instance = null;

    private PreparedStatement insert;
    private PreparedStatement getAll;
    private PreparedStatement getArtigosEdicao;

    private ArtigosModel() throws ClassNotFoundException, SQLException {
		
		Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("INSERT INTO artigos VALUES(?,?,?,?)");
        getAll = conexao.prepareStatement("SELECT * FROM artigos");
        getArtigosEdicao = conexao.prepareStatement("SELECT * FROM artigos NATURAL JOIN edicoes");
    }

    public static ArtigosModel getInstance() throws ClassNotFoundException, SQLException {
		
		if(instance == null)
			instance = new ArtigosModel();
		
		return instance;
	}

    public void insert(Artigos artigo) throws SQLException{

			insert.setInt(1, artigo.getArtigoid());
			insert.setString(2, artigo.getTitulo());
			insert.setInt(3, artigo.getTipoid());
			insert.setInt(4, artigo.getEdicaoid());
            insert.execute();
            insert.close();	
	}	

    public List<Artigos> getAll() throws SQLException {
		List<Artigos> ListaArtigos = new ArrayList<Artigos>();
		Artigos artigo = null;
		
		ResultSet rs = getAll.executeQuery();
		while(rs.next()) {
            artigo = new Artigos();
            artigo.setArtigoid(rs.getInt("artigoid"));
            artigo.setTitulo(rs.getString("titulo"));
            artigo.setTipoid(rs.getInt("tipoid"));
            artigo.setEdicaoid(rs.getInt("edicaoid"));
                  
            ListaArtigos.add(artigo);
        }
        
        return ListaArtigos;
	}		

    public List<Artigos> getArtigosEdicao() throws SQLException {
		List<Artigos> ListaArtigosEdicao = new ArrayList<Artigos>();
        Artigos artigo = null;
		Edicoes edicao = null;

		ResultSet rs = getArtigosEdicao.executeQuery();
		while(rs.next()) {
            artigo = new Artigos();
            artigo.setArtigoid(rs.getInt("artigoid"));
            artigo.setTitulo(rs.getString("titulo"));
            artigo.setTipoid(rs.getInt("tipoid"));
            artigo.setEdicaoid(rs.getInt("edicaoid"));

            edicao = new Edicoes();
            edicao.setEdicaoid(rs.getInt("edicaoid"));
            edicao.setCidade(rs.getString("cidade"));
            edicao.setUf(rs.getString("uf"));
            edicao.setQtdparticipantes(rs.getInt("qtdparticipantes"));
            edicao.setAno(rs.getInt("ano"));   
            artigo.setEdicao(edicao);
            
            ListaArtigosEdicao.add(artigo);
        }
        
        return ListaArtigosEdicao;
	}	
}
