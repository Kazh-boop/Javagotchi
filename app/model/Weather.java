package app.model;

public enum Weather {
    SUNNY(0, 0.7, "Ensolleillé", ""),
    CLOUDY(1, 1.1, "", ""),
    RAINY(2, 1.3, "", ""),
    SNOWY(3, 0.9, "", "");

    int id;
    double coef;
    String name;
    String url;

    Weather(int id, double coef, String name, String url){
        this.coef = coef;
        this.name = name;
        this.url = url;
    }

    String getName() { return name; }

    String getUrl() { return url; }
}