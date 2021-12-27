package app.model;

public enum Rooms {
    GARDEN(0,"Jardin", "", new Integer[]{1,2}),
	LIVING_ROOM(1, "Salon", "", new Integer[] {3,4}),
	KITCHEN(2, "Cuisine", "", new Integer[] {5,6});
	
	private int id;
	private String name;
	private String url;
	private Integer[] actionsAvailable;

    Rooms(int id, String name, String url, Integer[] actionsAvailable) {
    	this.id = id;
    	this.name = name;
    	this.url = url;
    	this.actionsAvailable = actionsAvailable;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public Integer[] getActionsAvailable() {
		return actionsAvailable;
	}
	
	public Rooms getRoomByID(int id)
	{
		Rooms rooms = null;
		switch(id) {
			case 0 : 
				rooms = Rooms.GARDEN;
				break;
			case 1 :
				rooms = Rooms.LIVING_ROOM;
				break;
			case 2 :
				rooms = Rooms.KITCHEN;
				break;
			default:
				break;
		}
		
		return rooms;
	}

    
}
