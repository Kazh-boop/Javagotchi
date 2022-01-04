package app.util;

enum RoomsURL {

	KITCHEN_CLOUDY("../assets/images/cuisine/cuisine_cloudy.png"),
	KITCHEN_RAINY("../assets/images/cuisine/cuisine_rainy.png"),
	KITCHEN_SNOWY("../assets/images/cuisine/cuisine/cuisine_snowy.png"),
	KITCHEN_SUNNY("../assets/images/cuisine/cuisine/cuisine_sunny.png"),
	GARDEN_CLOUDY("../assets/images/jardin/jardin_cloudy.png"),
	GARDEN_RAINY("../assets/images/jardin/jardin_rainy.png"),
	GARDEN_SNOWY("../assets/images/jardin/jardin_snowy.png"),
	GARDEN_SUNNY("../assets/images/jardin/jardin_sunny.png"),
	LIVINGROOM_CLOUDY("../assets/images/salon/salon_cloudy.png"),
	LIVINGROOM_RAINY("../assets/images/salon/salon_rainy.png"),
	LIVINGROOM_SNOWY("../assets/images/salon/salon_snowy.png"),
	LIVINGROOM_SUNNY("../assets/images/salon/salon_sunny.png");

	private String url;
 
    RoomsURL(String url) {
        this.url = url;
    }
 
    public String getUrl() {
        return url;
    }
}