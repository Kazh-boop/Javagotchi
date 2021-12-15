package app.model;

public class Cat extends Familiar {
    
    public Cat(String name) {
        super();
        this.name = name;
        this.food = "Patée";
        this.familiarType = "Chat";
    }

    public Cat(Cat cat) {
        super(cat);
        this.food = "Patée";
    }
    
    // Constructeur de test
    public Cat(String name, long period) {
    	super(period);
        this.name = name;
        this.food = "Patée";
        this.familiarType = "Chat";
    }
}
