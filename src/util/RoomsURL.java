package util;

/**
 * enumeration to know the different places where the familiar can be
 */

public enum RoomsURL {

	CuisineNuageux("cuisine/cuisine_cloudy.png"),
	CuisinePluvieux("cuisine/cuisine_rainy.png"),
	CuisineNeigeux("cuisine/cuisine_snowy.png"),
	CuisineEnsolleillee("cuisine/cuisine_sunny.png"),
	JardinNuageux("jardin/jardin_cloudy.png"),
	JardinPluvieux("jardin/jardin_rainy.png"),
	JardinNeigeux("jardin/jardin_snowy.png"),
	JardinEnsolleillee("jardin/jardin_sunny.png"),
	SalonNuageux("salon/salon_cloudy.png"),
	SalonPluvieux("salon/salon_rainy.png"),
	SalonNeigeux("salon/salon_snowy.png"),
	SalonEnsolleillee("salon/salon_sunny.png");

	private String url;
	
	/**
	 * Constructor
	 * @param url
	 */
    RoomsURL(String url) {
        this.url = url;
    }
    
    /**
     * @return url
     */
    public String getURL() {
    	return url;
    }
}