package bmi.beadando;

import com.sun.jdi.request.ExceptionRequest;

public abstract class Ember {
    private double suly;
    private double magassag;
    private String nem;

    public double getSuly() {
        return suly;
    }

    public void setSuly(double suly) throws Exception {
        if (suly <= 0) {
            throw new IllegalArgumentException("Súly nem lehet 0 vagy negatív.");
        }
        this.suly = suly;
    }

    public double getMagassag() {
        return magassag;
    }

    public void setMagassag(double magassag) throws Exception {
        if (magassag <= 0) {
            throw new IllegalArgumentException("Magasság nem lehet 0 vagy negatív.");
        }
        this.magassag = magassag;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }

    public Ember(double suly, double magassag, String nem) {
        this.suly = suly;
        this.magassag = magassag;
        this.nem = nem;
    }

    public double calculateBMI(double suly, double magassag) throws Exception {
        try {
            setSuly(suly);
            setMagassag(magassag);
        }catch (Exception e){
            throw e;
        }
        double BMIIndex = this.suly/(this.magassag/100 * this.magassag/100);
        return BMIIndex;
    }

    public String getBMICategory(double suly, double magassag) throws Exception {
        double BMIIndex = 0;
        try{
            BMIIndex=calculateBMI(suly,magassag);

        }catch(Exception e){
            throw e;
        }
        if (BMIIndex >=1 && BMIIndex< 16.0) {
            return "Súlyos soványság";
        } else if (BMIIndex >= 16.0 && BMIIndex <= 16.99) {
            return "Mérsékelt soványság";
        } else if (BMIIndex >= 17.0 && BMIIndex <= 18.49) {
            return "Enyhe soványság";
        } else if (BMIIndex >= 18.5 && BMIIndex <= 24.99) {
            return "Normális testsúly";
        } else if (BMIIndex >= 25.0 && BMIIndex <= 29.99) {
            return "Túlsúlyos";
        } else if (BMIIndex >= 30.0 && BMIIndex <= 34.99) {
            return "Enyhe elhízás";
        } else if (BMIIndex >= 35.0 && BMIIndex <= 39.99) {
            return "Közepes elhízás";
        } else if (BMIIndex >= 40.0) {
            return "Súlyos elhízás";
        } else {
            return "Nem érvényes BMI érték";
        }
    }
    abstract String getHeightCategory(double magassag);

    @Override
    public String toString() {
        return "Ember{" +
                "súly=" + suly + " kg" +
                ", magasság=" + magassag + " cm" +
                ", nem='" + nem + '\'' +
                '}';
    }
}
