package com.example.taxcalculator;

public class Incometax {
    public static double calculateTax(double income) {
        // A simple tax calculation logic for demonstration
        if (income <= 10000) {
            return income * 0.10;
        } else if (income <= 50000) {
            return income * 0.20;
        } else {
            return income * 0.30;
        }
    }
}
