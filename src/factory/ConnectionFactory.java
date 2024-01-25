/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.sql.Connection; // conexão SQL para Java 
import java.sql.DriverManager; // driver de conexão SQL para Java 
import java.sql.SQLException; 
import javax.swing.JOptionPane;
/**
 *
 * @author Francis
 */
public class ConnectionFactory {
    
    public Connection getConnection() {// faz a conexão com o banco de dados
         String URL = "jdbc:mysql://localhost:3306/dbaplanta";
		 try { //try tenta executar uma ação
			//DriverManager: gerencia a conexao com o banco
                        //getConnection: metodo que faz a conexao passando os
                        //parametros: URL(endereço do banco), root(login), "" (senha)
                     return DriverManager.getConnection(URL,"root","");
		 }         
		 catch(SQLException excecao) {//catch pega uma exceção retornada pelo sistema
                       //Exibe a mensagem de erro mostrada pelo sistema 
                       JOptionPane.showMessageDialog(null,"Erro ao conectar " + excecao );
			throw new RuntimeException(excecao);
		 }
     }
}
