import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: inserirEdicao();
                            break;
                    case 2: inserirArtigo();
                            break;
                    case 3: exibirEdicoes();
                            break;
                    case 4: exibirArtigos();
                            break;
                    case 5: exibirArtigosEdicao();
                            break;
                    case 6: exibirMenoresEdicoes();
                            break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);  
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Inserir uma nova edição");
        System.out.println("2 - Inserir um novo artigo");
        System.out.println("3 - Exibir todas as edições");
        System.out.println("4 - Exibir todos os artigos");
        System.out.println("5 - Exibir todos os artigos e suas respectivas edições");
        System.out.println("6 - Exibir as edições que tiveram a menor quantidade de participantes");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void inserirEdicao() throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Edicoes edicao = new Edicoes();
        
        System.out.println("ID:");
        edicao.setEdicaoid(in.nextInt());
        System.out.println("Cidade:");
        edicao.setCidade(in.next());	
        System.out.println("Uf:");	
        edicao.setUf(in.next());	
        System.out.println("Quantidade de participantes:");					
        edicao.setQtdparticipantes(in.nextInt());
        System.out.println("Ano:");
        edicao.setAno(in.nextInt());

        EdicoesModel.getInstance().insert(edicao);  
    }  
    
    public static void inserirArtigo() throws SQLException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        Artigos artigo = new Artigos();
        
        System.out.println("ID:");
        artigo.setArtigoid(in.nextInt());
        System.out.println("Titulo:");
        artigo.setTitulo(in.next());	
        System.out.println("Tipo:");	
        artigo.setTipoid(in.nextInt());	
        System.out.println("Edição:");					
        artigo.setEdicaoid(in.nextInt());
        
        ArtigosModel.getInstance().insert(artigo);
          
    }    

    public static void exibirEdicoes() throws ClassNotFoundException, SQLException{
        List<Edicoes> ListaEdicoes = EdicoesModel.getInstance().getAll();
        for(Edicoes ed : ListaEdicoes)
            System.out.println(ed.toString());
    }

    public static void exibirArtigos() throws ClassNotFoundException, SQLException{
        List<Artigos> ListaArtigos = ArtigosModel.getInstance().getAll();
        for(Artigos art : ListaArtigos)
            System.out.println(art.toString());
    }

    public static void exibirArtigosEdicao() throws ClassNotFoundException, SQLException{
        List<Artigos> ListaArtigosEdicao = ArtigosModel.getInstance().getArtigosEdicao();
        for(Artigos art : ListaArtigosEdicao)
            System.out.println(art.toString());
    }

    public static void exibirMenoresEdicoes() throws ClassNotFoundException, SQLException{
        List<Edicoes> ListaMenoresEdicoes = EdicoesModel.getInstance().getMenoresEdicoes();
        for(Edicoes ed : ListaMenoresEdicoes)
            System.out.println(ed.toString());
    }
}

