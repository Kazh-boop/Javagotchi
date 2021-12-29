package app.model;

public enum Mood {
    HAPPY(0.6f, "Epanoui"),
    JOYFUL(0.8f, "Joyeux"),
    FINE(1f, "Neutre"),
    SAD(1.2f, "Maussade"),
    MISERABLE(1.4f, "Malheureux"),;
    
    float coef;
    String name;

    Mood(float coef, String name){
        this.coef = coef;
        this.name = name;
    }

    public float getCoef() {
        return coef;
    }

    public String getName() {
        return name;
    }
}