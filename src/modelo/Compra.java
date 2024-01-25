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
public class Compra {
    int cod_compra;
    String cod_planta_compra;
    String cod_cliente_compra;
    int quantidade_compra;
    float valor_compra;

    public int getCod_compra() {
        return cod_compra;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public String getCod_planta_compra() {
        return cod_planta_compra;
    }

    public void setCod_planta_compra(String cod_planta_compra) {
        this.cod_planta_compra = cod_planta_compra;
    }

    public String getCod_cliente_compra() {
        return cod_cliente_compra;
    }

    public void setCod_cliente_compra(String cod_cliente_compra) {
        this.cod_cliente_compra = cod_cliente_compra;
    }

    public int getQuantidade_compra() {
        return quantidade_compra;
    }

    public void setQuantidade_compra(int quantidade_compra) {
        this.quantidade_compra = quantidade_compra;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }
    
}
