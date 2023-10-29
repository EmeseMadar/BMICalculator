package org.example;

import bmi.beadando.Ferfiak;
import bmi.beadando.Nok;

public class Main {
    public static void main(String[] args) throws Exception {
        Nok no1 = new Nok(50, 160, "Nő");
        System.out.println(no1.toString());
        System.out.println("BMI Index: " + no1.calculateBMI(50,160));
        System.out.println("BMI Kategória: " + no1.getBMICategory(50,160));
        System.out.println("Magasság kategória: " + no1.getHeightCategory(no1.getMagassag()));
        System.out.println("*******************");
        Ferfiak ferfi1 = new Ferfiak(75, 180, "Férfi");
        System.out.println(ferfi1.toString());
        System.out.println("BMI Index: " + ferfi1.calculateBMI(75,180));
        System.out.println("BMI Kategória: " + ferfi1.getBMICategory(75,180));
        System.out.println("Magasság kategória: " + ferfi1.getHeightCategory(ferfi1.getMagassag()));
    }
}