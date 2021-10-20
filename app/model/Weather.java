package app.model;

public enum Weather {
    SUNNY(0.7, "Ensolleillé", ""),
    CLOUDY(1, "", ""),
    RAINY(1.3, "", ""),
    SNOWY(1.1, "", "");

    int id;
    double coef;
    String name;
    String url;

    Weather(int id, double coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
    }

    String getUrl() { return url; }
}