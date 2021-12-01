package app.model;

public enum Weather {
    SUNNY(0, 0.7f, "Ensolleillé", ""),
    CLOUDY(1, 1.1f, "Nuageux", ""),
    RAINY(2, 1.3f, "Pluvieux", ""),
    SNOWY(3, 0.9f, "Neigeux", "");

    private int id;
    private float coef;
    private String name;
    private String url;

    Weather(int id, float coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
        this.id = id;
    }

    protected int getId() { return id; }
    
    protected float getCoef() { return coef; }

    protected String getName() { return name; }

    protected String getUrl() { return url; }
}