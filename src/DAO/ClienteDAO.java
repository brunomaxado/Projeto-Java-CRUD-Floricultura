/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author bruno
 */
public class ClienteDAO {

    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
    }

    public void cadastrar(Cliente cliente) {
        String consulta = "INSERT INTO tbcliente(nome_cliente,nascimento_cliente,cpf_cliente,telefone_cliente, cidade_cliente, bairro_cliente) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getNascimento());
            stmt.setString(3, cliente.getCPF());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCidade());

            stmt.setString(6, cliente.getBairro());

            stmt.execute();//Executa a consulta
            stmt.close();//Encerra a consulta
            //Exibe mensagem dizendo que o cadastro foi realizado com sucesso
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException excecaoaluno) { // caso ocorra algum erro retorna uma mensagem de excecao
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + excecaoaluno);
            throw new RuntimeException(excecaoaluno);

        }

    }

    public List<Cliente> recuperar() {
        List<Cliente> listaclientes = new ArrayList<>();
        String consulta = "SELECT * FROM tbcliente";
        ResultSet rs = null; // Armazena o retorno da consulta e é inicializado com null

        try {

            PreparedStatement stmt = connection.prepareStatement(consulta);//Responsável pela realização de consultas no banco de dados
            rs = stmt.executeQuery();// Armazena o retorno da cosulta
            while (rs.next()) //retorna todos os registros do banco
            {
                Cliente cliente = new Cliente();

                cliente.setCod(rs.getInt("cod_cliente")); //Pega o cod_aluno do banco de dados e coloca dentro do campo codigo da classe modelo Aluno
                cliente.setNome(rs.getString("nome_cliente"));
                cliente.setNascimento(rs.getString("nascimento_cliente"));
                cliente.setCPF(rs.getString("cpf_cliente"));
                cliente.setTelefone(rs.getString("telefone_cliente"));
                cliente.setCidade(rs.getString("cidade_cliente"));
                cliente.setBairro(rs.getString("bairro_cliente"));
                listaclientes.add(cliente);
            }
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar dados " + u);
            throw new RuntimeException(u);
        }
        return (listaclientes);
    }

    public void atualiza(Cliente cliente) {
        //Armazena a String com a consulta de atualização do aluno no banco de dados    
        String consulta = "UPDATE tbcliente SET nome_cliente = ?,nascimento_cliente=?,cpf_cliente=?,telefone_cliente=?, cidade_cliente = ?, bairro_cliente = ? WHERE cod_cliente=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);//Responsável pela realização de consultas no banco de dados
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getNascimento());
            stmt.setString(3, cliente.getCPF());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getBairro());
            stmt.setLong(7, cliente.getCod());
            stmt.executeUpdate();//executa o update na tabela
            stmt.close();//encerra a execução
            //exibe mensagem
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + u);
            throw new RuntimeException(u);

        }
        
    }
     public void Apaga(Cliente cliente){ 
         //Armazena na String com a consulta de deleção do aluno no banco de dados buscando pelo código    
        String consulta = "DELETE FROM tbcliente WHERE cod_cliente=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setLong(1, cliente.getCod());
            stmt.executeUpdate();//executa a deleção
            stmt.close();
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso!","Exclusão",JOptionPane.INFORMATION_MESSAGE );
        } 
        catch (SQLException u) { 
            JOptionPane.showMessageDialog(null,"Erro ao atualizar " + u );
            throw new RuntimeException(u);
          
        }
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
