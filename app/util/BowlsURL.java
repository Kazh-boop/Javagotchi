package app.util;

public enum BowlsURL {
    Chat0("../assets/images/gamelle/chat_0.png"),
    Chat1("../assets/images/gamelle/chat_1.png"),
    Chat2("../assets/images/gamelle/chat_2.png"),
    Chat3("../assets/images/gamelle/chat_3.png"),
    Chat4("../assets/images/gamelle/chat_4.png"),

    Chien0("../assets/images/gamelle/chien_0.png"),
    Chien1("../assets/images/gamelle/chien_1.png"),
    Chien2("../assets/images/gamelle/chien_2.png"),
    Chien3("../assets/images/gamelle/chien_3.png"),
    Chien4("../assets/images/gamelle/chien_4.png"),

    Robot0("../assets/images/gamelle/robot_0.png"),
    Robot1("../assets/images/gamelle/robot_1.png"),
    Robot2("../assets/images/gamelle/robot_2.png"),
    Robot3("../assets/images/gamelle/robot_3.png"),
    Robot4("../assets/images/gamelle/robot_4.png"),

    Lapin0("../assets/images/gamelle/lapin_0.png"),
    Lapin1("../assets/images/gamelle/lapin_1.png"),
    Lapin2("../assets/images/gamelle/lapin_2.png"),
    Lapin3("../assets/images/gamelle/lapin_3.png"),
    Lapin4("../assets/images/gamelle/lapin_4.png");

    private String url;
 
    BowlsURL(String url) {
        this.url = url;
    }
 
    public String getUrl() {
        return url;
    }
}
