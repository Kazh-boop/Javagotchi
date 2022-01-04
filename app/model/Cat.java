package app.model;

public class Cat extends Familiar {
    
    //constructor
    public Cat(String name, String url) {
        super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Patee"; // the cat could only eat pate
        this.familiarType = "Chat";
    }

    public Cat(Cat cat) {
        super();
        this.name = cat.name;
        this.mood = cat.mood;
        this.moodValue = cat.moodValue;
        this.urlIcon = cat.urlIcon;
        this.food = "Patee";
        this.familiarType = "Chat";
    }
}
