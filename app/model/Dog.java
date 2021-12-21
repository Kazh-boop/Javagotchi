package app.model;

public class Dog extends Familiar {
    
    public Dog(String name) {
        super();
        this.name = name;
        this.food = "Patée";
        this.familiarType = "Chat";
    }

    public Dog(Dog dog) {
        super(dog);
        this.food = "Patée";
    }
}
