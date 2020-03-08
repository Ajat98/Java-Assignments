package com.example.mcalc;

import static java.lang.Math.*;
import ca.roumani.i2c.*;

public class MortgageModel {
    private double principle;
    private int amortization;
    private double interest;

    public MortgageModel(String p, String a, String i) {
        this.principle = Double.parseDouble(p);
        this.amortization = Integer.parseInt(a);
        this.interest = Double.parseDouble(i);
    }

    public String computePayment()
    {
        double r = this.interest/100/12;
        double rP = r * this.principle;
        int n = -1 * (this.amortization * 12);
        double eq = (1+r);
        double bottom = Math.pow(eq, n);

        double monthlyPayment = rP / (1-bottom);

        String result = String.format("%,.2f", monthlyPayment);
        return result;

    }

    public static void main(String[] args) {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.50");
        System.out.println(myModel.computePayment());

    }



}




