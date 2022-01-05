package util;

/**
 * enumeration to know the different states of the familiar bowl
 */

public enum BowlsURL {
    Chat0("gamelle/chat_0.png"),
    Chat1("gamelle/chat_1.png"),
    Chat2("gamelle/chat_2.png"),
    Chat3("gamelle/chat_3.png"),
    Chat4("gamelle/chat_4.png"),

    Chien0("gamelle/chien_0.png"),
    Chien1("gamelle/chien_1.png"),
    Chien2("gamelle/chien_2.png"),
    Chien3("gamelle/chien_3.png"),
    Chien4("gamelle/chien_4.png"),

    Robot0("gamelle/robot_0.png"),
    Robot1("gamelle/robot_1.png"),
    Robot2("gamelle/robot_2.png"),
    Robot3("gamelle/robot_3.png"),
    Robot4("gamelle/robot_4.png"),

    Lapin0("gamelle/lapin_0.png"),
    Lapin1("gamelle/lapin_1.png"),
    Lapin2("gamelle/lapin_2.png"),
    Lapin3("gamelle/lapin_3.png"),
    Lapin4("gamelle/lapin_4.png");

    private String url;
    
    /**
     * Constructor
     * @param url
     */
    private BowlsURL(String url) {
        this.url = url;
    }
    
    /**
     * getter
     * @return url
     */
    public String getUrl() {
        return url;
    }
}
