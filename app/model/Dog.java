package app.model;

public class Dog extends Familiar {

    //constructor
	public Dog(String name) {
		super();
        this.name = name;
        this.food = "Croquette"; // the dog could only eat kibbles
        this.familiarType = "Chien";
    }
	
    public Dog(Dog dog) {
		super();
        dog.name = name;
        this.food = "Croquette";
        this.familiarType = "Chien";
    }
}
