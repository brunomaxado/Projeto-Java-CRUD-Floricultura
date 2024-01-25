/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author bruno
 */
public class Planta {
    int cod;
    String Nome;
    String NomeC;
    String Area; 
    int Qtd;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    float valor;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNomeC() {
        return NomeC;
    }

    public void setNomeC(String NomeC) {
        this.NomeC = NomeC;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int Qtd) {
        this.Qtd = Qtd;
    }
}
