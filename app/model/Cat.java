package app.model;

public class Cat extends Familiar {
    
    //constructor
    public Cat(String name) {
        super();
        this.name = name;
        this.food = "Patée"; // the cat could only eat pate
        this.familiarType = "Chat";
    }

    public Cat(Cat cat) {
        super();
        this.name = cat.name;
        this.food = "Patée";
        this.familiarType = "Chat";
    }
}
