package model;

public class Robot extends Familiar {
    
    /**
     * Constructor
     * @param name
     * @param url
     */
    public Robot(String name, String url) {
        super();
        this.name = name;
        this.urlIcon = url;
        this.food = "Electricite"; //the robot can only "eat" electricity
        this.familiarType = "Robot";
    }

    /**
     * @param robot
     */
    public Robot(Robot robot) {
        super();
        this.name = robot.name;
        this.mood = robot.mood;
        this.moodValue = robot.moodValue;
        this.urlIcon = robot.urlIcon;
        this.food = "Electricite";
        this.familiarType = "Robot";
    }
}
