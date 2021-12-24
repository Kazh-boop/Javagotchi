package app.model;

public class Dog extends Familiar {

	public Dog(String name) {
        this.name = name;
        this.food = "Croquette";
        this.familiarType = "Chien";
    }

	public Dog(Familiar f) {
		super(f);
        this.food = "Croquette";
	}
	
    public Dog(Dog dog) {
        super(dog);
        this.food = "Croquette";
    }
}
