package app.model;

public enum Weather {
<<<<<<< HEAD
    SUNNY(0, 0.7, "Ensolleillé", ""),
    CLOUDY(1, 1.1, "Nuageux", ""),
    RAINY(2, 1.3, "Pluvieux", ""),
    SNOWY(3, 0.9, "Neigeux", "");
=======
    SUNNY(0, 1.0, "Ensolleillé", ""),
    CLOUDY(1, 1.1, "Nuageux", ""),
    RAINY(2, 1.2, "Pluvieux", ""),
    SNOWY(3, 1.3, "Neigeux", "");
>>>>>>> bf26fd7c218042407f1a5327c0856576364c28e7

    private int id;
    private double coef;
    private String name;
    private String url;

    Weather(int id, double coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
    }
    protected double getCoeff() { return coef; }

<<<<<<< HEAD
    protected String getName() { return name; }

    protected String getUrl() { return url; }
=======
    String getUrl() { 
    	return url; 
    }
    
    String getName() {
    	return name;
    }
>>>>>>> bf26fd7c218042407f1a5327c0856576364c28e7
}