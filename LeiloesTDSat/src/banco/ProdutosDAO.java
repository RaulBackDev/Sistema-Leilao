package banco;

import dados.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    ConectaDAO banco = new ConectaDAO();
    String scriptSQL;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto) {
        
        try {
            scriptSQL = "INSERT INTO produtos(nome, valor, status) "
                      + "VALUES(?, ?, ?);";
            PreparedStatement comandoSQL = banco.conectar().prepareStatement(scriptSQL);
            
            comandoSQL.setString(1, produto.getNome()); comandoSQL.setFloat(2, produto.getValor());
            comandoSQL.setString(3, produto.getStatus());
            comandoSQL.execute();
            
        }catch(SQLException e) {
            //System.out.println("Falha INSERT.\nErro: "+ e.getMessage());// Debug
            banco.desconectar();
            return false;
        }
        
        //System.out.println("Sucesso INSERT.");// Debug
        banco.desconectar();
        return true;
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() {
        return listagem;
    }
      
}

