package app.util;

public enum RoomsURL {

	CuisineNuageux("../assets/images/cuisine/cuisine_cloudy.png"),
	CuisinePluvieux("../assets/images/cuisine/cuisine_rainy.png"),
	CuisineNeigeux("../assets/images/cuisine/cuisine/cuisine_snowy.png"),
	CuisineEnsolleillee("../assets/images/cuisine/cuisine/cuisine_sunny.png"),
	JardinNuageux("../assets/images/jardin/jardin_cloudy.png"),
	JardinPluvieux("../assets/images/jardin/jardin_rainy.png"),
	JardinNeigeux("../assets/images/jardin/jardin_snowy.png"),
	JardinEnsolleillee("../assets/images/jardin/jardin_sunny.png"),
	SalonNuageux("../assets/images/salon/salon_cloudy.png"),
	SalonPluvieux("../assets/images/salon/salon_rainy.png"),
	SalonNeigeux("../assets/images/salon/salon_snowy.png"),
	SalonEnsolleillee("../assets/images/salon/salon_sunny.png");

	private String url;
 
    RoomsURL(String url) {
        this.url = url;
    }
    
    public String getURL() {
    	return url;
    }
}