package app.model;

/**
 * enumeration to know the different moods of the familiar
 */

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

    protected float getCoef() {
        return coef; // return the coefficient used to define the familiar's mood
    }

    protected String getName() {
        return name; // return the name 
    }
}