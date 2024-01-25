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
import modelo.Compra;
import modelo.Planta;

/**
 *
 * @author bruno
 */
public class CompraDAO {
    private Connection connection;

    public CompraDAO() {
        this.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
    }
     public void cadastrar(Compra compra) {
        String consulta = "INSERT INTO tbcompra(cod_planta_compra,cod_cliente_compra,quantidade_compra, valor_compra) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, compra.getCod_planta_compra());
            stmt.setString(2, compra.getCod_cliente_compra());
            stmt.setInt(3, compra.getQuantidade_compra());
            stmt.setFloat(4, compra.getValor_compra());
     

            stmt.execute();//Executa a consulta
            stmt.close();//Encerra a consulta
            //Exibe mensagem dizendo que o cadastro foi realizado com sucesso
            JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException excecaoaluno) { // caso ocorra algum erro retorna uma mensagem de excecao
            JOptionPane.showMessageDialog(null, "Erro ao comprar " + excecaoaluno);
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
          public List<Planta> recuperarr() {
        List<Planta> listaplanta = new ArrayList<>();
        String consulta = "SELECT * FROM tbplanta";
        ResultSet rs = null; // Armazena o retorno da consulta e é inicializado com null

        try {

            PreparedStatement stmt = connection.prepareStatement(consulta);//Responsável pela realização de consultas no banco de dados
            rs = stmt.executeQuery();// Armazena o retorno da cosulta
            while (rs.next()) //retorna todos os registros do banco
            {
                Planta planta = new Planta();

                planta.setCod(rs.getInt("cod_planta")); //Pega o cod_aluno do banco de dados e coloca dentro do campo codigo da classe modelo Aluno
                planta.setNome(rs.getString("nome_planta"));
                planta.setNomeC(rs.getString("nomec_planta"));
                planta.setArea(rs.getString("area_planta"));
                planta.setQtd(rs.getInt("qtd_planta"));
                planta.setValor(rs.getFloat("valor"));

                listaplanta.add(planta);
            }
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar dados " + u);
            throw new RuntimeException(u);
        }
        return (listaplanta);
    }
          public List<Compra> recuperarrr() {
        List<Compra> listacompra = new ArrayList<>();
        String consulta = "SELECT * FROM tbcompra";
        ResultSet rs = null; // Armazena o retorno da consulta e é inicializado com null

        try {

            PreparedStatement stmt = connection.prepareStatement(consulta);//Responsável pela realização de consultas no banco de dados
            rs = stmt.executeQuery();// Armazena o retorno da cosulta
            while (rs.next()) //retorna todos os registros do banco
            {
                Compra compra = new Compra();

                compra.setCod_compra(rs.getInt("cod_compra")); //Pega o cod_aluno do banco de dados e coloca dentro do campo codigo da classe modelo Aluno
               
                compra.setCod_cliente_compra(rs.getString("cod_cliente_compra"));
                compra.setQuantidade_compra(rs.getInt("quantidade_compra"));
                compra.setValor_compra(rs.getFloat("valor_compra"));
                compra.setCod_planta_compra(rs.getString("cod_planta_compra"));
                

                listacompra.add(compra);
            }
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar dados " + u);
            throw new RuntimeException(u);
        }
        return (listacompra);
    }
           public void Apaga(Compra compra){ 
         //Armazena na String com a consulta de deleção do aluno no banco de dados buscando pelo código    
        String consulta = "DELETE FROM compra WHERE cod_compra=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setLong(1, compra.getCod_compra());
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
