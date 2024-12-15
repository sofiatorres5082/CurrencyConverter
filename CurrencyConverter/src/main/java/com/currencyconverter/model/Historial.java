package com.currencyconverter.model;

public class Historial {
    private String base;
    private String target;
    private double amount;
    private double result;

    public Historial(String base, String target, double amount, double result) {
        this.base = base;
        this.target = target;
        this.amount = amount;
        this.result = result;
    }

    public String getBase() {
        return base;
    }

    public String getTarget() {
        return target;
    }

    public double getAmount() {
        return amount;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return amount + " " + base + " = " + result + " " + target;
    }
}
