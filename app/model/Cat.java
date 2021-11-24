package app.model;

public class Cat extends Familiar {
    
    public Cat(String name) {
        super();
        this.name = name;
        this.food = "Patée";
    }

    public Cat(Cat cat) {
        super(cat);
        this.food = "Patée";
    }
}
