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
import modelo.Planta;

/**
 *
 * @author bruno
 */
public class PlantaDAO {

    private Connection connection;

    public PlantaDAO() {
        this.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
    }

    public void cadastrar(Planta planta) {
        String consulta = "INSERT INTO tbplanta(nome_planta,nomec_planta,area_planta,qtd_planta, valor) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getNomeC());
            stmt.setString(3, planta.getArea());
            stmt.setLong(4, planta.getQtd());
            stmt.setFloat(5, planta.getValor());

            stmt.execute();//Executa a consulta
            stmt.close();//Encerra a consulta
            //Exibe mensagem dizendo que o cadastro foi realizado com sucesso
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException excecaoaluno) { // caso ocorra algum erro retorna uma mensagem de excecao
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar " + excecaoaluno);
            throw new RuntimeException(excecaoaluno);

        }

    }

    public List<Planta> recuperar() {
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

     public void atualiza(Planta planta) {
        //Armazena a String com a consulta de atualização do aluno no banco de dados    
        String consulta = "UPDATE tbplanta SET nome_planta = ?,nomec_planta=?,area_planta=?,qtd_planta=?, valor=? WHERE cod_planta=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(consulta);//Responsável pela realização de consultas no banco de dados
            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getNomeC());
            stmt.setString(3, planta.getArea());
            stmt.setLong(4, planta.getQtd());
            stmt.setFloat(5, planta.getValor());
            stmt.setLong(6, planta.getCod());
            stmt.executeUpdate();//executa o update na tabela
            stmt.close();//encerra a execução
            //exibe mensagem
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!", "Atualização", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException u) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar " + u);
            throw new RuntimeException(u);

        }
        
    }
      public void Apaga(Planta planta){ 
         //Armazena na String com a consulta de deleção do aluno no banco de dados buscando pelo código    
        String consulta = "DELETE FROM tbplanta WHERE cod_planta=?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setLong(1, planta.getCod());
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
