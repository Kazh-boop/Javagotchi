package model;

public class Dog extends Familiar {

	/**
     * Constructor
     * @param name
     * @param url
     */
	public Dog(String name, String url) {
		super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Croquette"; // the dog could only eat kibbles
        this.familiarType = "Chien";
    }
	
	/**
	 * @param dog
	 */
    public Dog(Dog dog) {
		super();
        this.name = dog.name;
        this.mood = dog.mood;
        this.moodValue = dog.moodValue;
        this.urlIcon = dog.urlIcon;
        this.food = "Croquette";
        this.familiarType = "Chien";
    }
}
