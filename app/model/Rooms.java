package app.model;


/**
 * enumeration of the different rooms
 */

public enum Rooms {
    GARDEN(0,"Jardin", "", new Integer[]{1,2}),
	LIVING_ROOM(1, "Salon", "", new Integer[] {3,4}),
	KITCHEN(2, "Cuisine", "", new Integer[] {5,6});
	
	private int id;
	private String name;
	private String url;
	private Integer[] actionsAvailable;

	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param url
	 * @param actionsAvailable
	 */
    Rooms(int id, String name, String url, Integer[] actionsAvailable) {
    	this.id = id;
    	this.name = name;
    	this.url = url;
    	this.actionsAvailable = actionsAvailable;
    }

    /**
     * @return id
     */
	public int getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return actionsAvailable
	 */
	public Integer[] getActionsAvailable() {
		return actionsAvailable;
	}

	/**
	 * each room is associated with an ID
	 * @return rooms
	 */
	public Rooms getRoomByID(int id)
	{
		Rooms rooms = null;
		switch(id) {
			case 0 : 
				rooms = Rooms.GARDEN;
				break;
			case 2 :
				rooms = Rooms.KITCHEN;
				break;
			default:
				rooms = Rooms.LIVING_ROOM;
				break;
		}
		
		return rooms;
	}
}
