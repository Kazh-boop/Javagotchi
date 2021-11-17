package app.model;

public enum Weather {
    SUNNY(0, 0.7, "Ensolleillé", ""),
    CLOUDY(1, 1.1, "Nuageux", ""),
    RAINY(2, 1.3, "Pluvieux", ""),
    SNOWY(3, 0.9, "Neigeux", "");

    private int id;
    private double coef;
    private String name;
    private String url;

    Weather(int id, double coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
        this.id = id;
    }

    protected int getId() { return id; }
    protected double getCoeff() { return coef; }

    protected String getName() { return name; }

    protected String getUrl() { return url; }
}