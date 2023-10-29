package bmi.beadando;

public class Nok extends Ember{
    public Nok(double suly, double magassag, String nem) {
        super(suly, magassag, nem);
    }
    @Override
    public String getHeightCategory(double magassag) {
        if (magassag < 155.0) {
            return "alacsony";
        } else if (magassag >= 155.0 && magassag < 170.0) {
            return "átlagos";
        } else
            return "magas";
    }
}
