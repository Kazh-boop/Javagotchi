package app.model;

public class Robot extends Familiar {
    
    // constructor
    public Robot(String name, String url) {
        super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Electricite"; //the robot can only "eat" electricity
        this.familiarType = "Robot";
    }

    public Robot(Robot r) {
        super();
        this.name = r.name;
        this.mood = r.mood;
        this.moodValue = r.moodValue;
        this.urlIcon = r.urlIcon;
        this.food = "Electricite";
        this.familiarType = "Robot";
    }
}
