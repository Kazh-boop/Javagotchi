package app.model;

public class Dog extends Familiar {
    
    public Dog(String name) {
        super();
        this.name = name;
        this.food = "Croquette";
        this.familiarType = "Chien";
    }

    public Dog(Dog dog) {
        super(dog);
        this.food = "Croquette";
    }
}
