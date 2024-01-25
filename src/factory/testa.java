/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;
import java.sql.Connection; 
import java.sql.SQLException; 
/**
 *
 * @author Francis
 */
public class testa {
    public static void main(String[] args) throws SQLException {
        //Cria uma conexão chamando o metodo getConnection da Classe Connection Factory 
        Connection connection = new ConnectionFactory().getConnection();
         
         System.out.println("Conexão aberta!");
         connection.close();
         System.out.println("Conexão Encerrada!");
     }
}
