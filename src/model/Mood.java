package model;

/**
 * enumeration to know the different moods of the familiar
 */

public enum Mood {
    HAPPY(0.6f, "Epanoui"),
    JOYFUL(0.8f, "Joyeux"),
    FINE(1f, "Neutre"),
    SAD(1.2f, "Maussade"),
    MISERABLE(1.4f, "Malheureux"),;
    
	private float coef;
    private String name;
    
    /**
     * Constructor
     * @param coef
     * @param name
     */
    Mood(float coef, String name){
        this.coef = coef;
        this.name = name;
    }

    /**
     * @return coef float
     */
    public float getCoef() {
        return coef;
    }

    /**
     * @return name String
     */
    public String getName() {
        return name;
    }
}