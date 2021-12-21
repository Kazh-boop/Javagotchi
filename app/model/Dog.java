package app.model;

public class Dog extends Familiar {
    
    public Dog(String name) {
        super();
        this.name = name;
        this.food = "Pat�e";
        this.familiarType = "Chat";
    }

    public Dog(Dog dog) {
        super(dog);
        this.food = "Pat�e";
    }
}
