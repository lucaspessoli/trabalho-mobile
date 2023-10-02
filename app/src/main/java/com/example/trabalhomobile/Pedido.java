package com.example.trabalhomobile;

public class Pedido {
    private int codigoItem,quantidadeItem;
    private double valorUnitarioItem;

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public double getValorUnitarioItem() {
        return valorUnitarioItem;
    }

    public void setValorUnitarioItem(double valorUnitarioItem) {
        this.valorUnitarioItem = valorUnitarioItem;
    }
}
