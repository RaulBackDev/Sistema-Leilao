package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaDAO {
    Connection conxServer;  
    String url = "jdbc:mysql://localhost:3306/uc11?serverTimezone=America/Sao_Paulo", user = "root", s = "raul";
    
    // Método para receber conexão com MySql
    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conxServer = DriverManager.getConnection(url, user, s);
            
        }catch (ClassNotFoundException | SQLException e){
            //System.out.println("Falha ao tentar conexão com Banco de dados:\n "+ e.getMessage());// Debug
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados.");// Debug
            return null;
        }     
        
        //System.out.println("Sucesso na conexão com Banco de dados");// Debug
        return conxServer;
    }
    
    // Método para desconectar do MySql
    public void desconectar() {
        try {
            if(conxServer != null) {
                conxServer.close();
            }   
            
        }catch(SQLException e) {
            //System.out.println("Falha ao tentar desconectar:\n "+ e.getMessage());// Debug
            JOptionPane.showMessageDialog(null, "Não foi possível desconectar do banco.");// Debug
        }
        //System.out.println("Sucesso na desconexão");// Debug
    } 
}
