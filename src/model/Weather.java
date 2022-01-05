package model;

/**
 * enumeration to know the different weather can happen during the game
 */

public enum Weather {
    SUNNY(0, 0.7f, "Ensolleillee", ""),
    CLOUDY(1, 1.1f, "Nuageux", ""),
    RAINY(2, 1.3f, "Pluvieux", ""),
    SNOWY(3, 0.9f, "Neigeux", "");

    private int id;
    private float coef;
    private String name;
    private String url;

    /**
     * Constructor
     * @param id
     * @param coef
     * @param name
     * @param url
     */
    Weather(int id, float coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
        this.id = id;
    }

    /**
     * @return id
     */
    protected int getId() { return id; }
    
    /**
     * @return coef
     */
    protected float getCoef() { return coef; }

    /**
     * @return name
     */
    protected String getName() { return name; }

    /**
     * @return url
     */
    protected String getUrl() { return url; }

    /**
     * returns the weather according to the ID
     * @param id
     * @return weather
     */
    protected static Weather getWeatherById(int id) {
       if( id == 1) {
    	   return CLOUDY;
       } else if( id == 2 ) {
    	   return RAINY;
       } else if( id == 3 ) {
    	   return SNOWY;
       }
       return SUNNY;
    }
}