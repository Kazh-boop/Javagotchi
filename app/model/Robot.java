package app.model;

public class Robot extends Familiar {
    
    // constructor
    public Robot(String name) {
        super();
        this.name = name;
        this.food = "Electricité"; //the robot can only "eat" electricity
        this.familiarType = "Robot";
    }

    public Robot(Robot r) {
        super();
        r.name = name;
        this.food = "Electricité";
        this.familiarType = "Robot";
    }
}
