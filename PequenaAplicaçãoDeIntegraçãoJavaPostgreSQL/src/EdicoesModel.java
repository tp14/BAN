import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EdicoesModel {
    private static EdicoesModel instance = null;

    private PreparedStatement insert;
    private PreparedStatement getAll;
    private PreparedStatement getMenoresEdicoes;

    private EdicoesModel() throws ClassNotFoundException, SQLException {
		
		Connection conexao = Conexao.getConexao();

        insert = conexao.prepareStatement("INSERT INTO edicoes VALUES(?,?,?,?,?)");
        getAll = conexao.prepareStatement("SELECT * FROM edicoes");
        getMenoresEdicoes = conexao.prepareStatement("SELECT * FROM edicoes WHERE qtdparticipantes IN(SELECT MIN(qtdparticipantes) FROM edicoes)");
    }

    public static EdicoesModel getInstance() throws ClassNotFoundException, SQLException {
		
		if(instance == null)
			instance = new EdicoesModel();
		
		return instance;
	}

    public void insert(Edicoes edicao) throws SQLException{

        insert.setInt(1, edicao.getEdicaoid());
        insert.setString(2, edicao.getCidade());
        insert.setString(3, edicao.getUf());
        insert.setInt(4, edicao.getQtdparticipantes());
        insert.setInt(5, edicao.getAno());
        insert.execute();
        insert.close(); 
    }

    public List<Edicoes> getAll() throws SQLException {
		List<Edicoes> ListaEdicoes = new ArrayList<Edicoes>();
		Edicoes edicao = null;
		
		ResultSet rs = getAll.executeQuery();
		while(rs.next()) {
            edicao = new Edicoes();
            edicao.setEdicaoid(rs.getInt("edicaoid"));
            edicao.setCidade(rs.getString("cidade"));
            edicao.setUf(rs.getString("uf"));
            edicao.setQtdparticipantes(rs.getInt("qtdparticipantes"));
            edicao.setAno(rs.getInt("ano"));   
            
            ListaEdicoes.add(edicao);
        }
        
        return ListaEdicoes;
	}	

    public List<Edicoes> getMenoresEdicoes() throws SQLException {
		List<Edicoes> ListaMenoresEdicoes = new ArrayList<Edicoes>();
		Edicoes edicao = null;
		
		ResultSet rs = getMenoresEdicoes.executeQuery();
		while(rs.next()) {
            edicao = new Edicoes();
            edicao.setEdicaoid(rs.getInt("edicaoid"));
            edicao.setCidade(rs.getString("cidade"));
            edicao.setUf(rs.getString("uf"));
            edicao.setQtdparticipantes(rs.getInt("qtdparticipantes"));
            edicao.setAno(rs.getInt("ano"));   
            
            ListaMenoresEdicoes.add(edicao);
        }
        
        return ListaMenoresEdicoes;
	}    
}
