package bmi.beadando;

public class Ferfiak extends Ember {
    public Ferfiak(double suly, double magassag, String nem) {
        super(suly, magassag, nem);
    }
    @Override
    public String getHeightCategory(double magassag){
        if (magassag < 165.0) {
            return "alacsony";
        }else if (magassag >= 165.0 && magassag < 180.0) {
            return "átlagos";
        }else
            return "magas";
    }
}