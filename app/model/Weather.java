package app.model;

public enum Weather {
    SUNNY(0, 1.0, "Ensolleillé", ""),
    CLOUDY(1, 1.1, "Nuageux", ""),
    RAINY(2, 1.2, "Pluvieux", ""),
    SNOWY(3, 1.3, "Neigeux", "");

    private int id;
    private double coef;
    private String name;
    private String url;

    Weather(int id, double coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
    }

    String getUrl() { 
    	return url; 
    }
    
    String getName() {
    	return name;
    }
}