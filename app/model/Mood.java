package app.model;

public enum Mood {
    HAPPY(0.7, "Content"),
    FINE(1, "Normal"),
    SAD(1.3, "Triste");
    
    double coef;
    String name;

    Mood(double coef, String name){
        this.coef = coef;
        this.name = name;
    }

    protected double getCoef() {
        return coef;
    }

    protected String getName() {
        return name;
    }
}