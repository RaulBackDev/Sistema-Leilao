package banco;

import dados.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    ConectaDAO banco = new ConectaDAO();
    String scriptSQL;
    
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
    
    public List<ProdutosDTO> listarProdutos() {
        List<ProdutosDTO> lista = new ArrayList();
        
        try {
            scriptSQL = "SELECT * FROM produtos;";
            PreparedStatement comandoSQL = banco.conectar().prepareStatement(scriptSQL);
            ResultSet query = comandoSQL.executeQuery();
            
            while(query.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(query.getInt("id"));
                produto.setNome(query.getString("nome"));
                produto.setValor(query.getFloat("valor"));
                produto.setStatus(query.getString("status")); 
                
                lista.add(produto);
            }
          
        }catch(SQLException e) {
            //System.out.println("Falha SELECT.\nErro: "+ e.getMessage());// DEBUG
            banco.desconectar();
            return null;
        }   
        
        //System.out.println("Sucesso SELECT.");// Debug
        banco.desconectar();
        return lista;
    }
}

