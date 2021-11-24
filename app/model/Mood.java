package app.model;

public enum Mood {
    HAPPY(0.6, "Épanoui"),
    JOYFUL(0.8, "Joyeux"),
    FINE(1, "Neutre"),
    SAD(1.2, "Maussade"),
    MISERABLE(1.4, "Malheureux"),;
    
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