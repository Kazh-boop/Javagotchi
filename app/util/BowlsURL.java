package app.util;

public enum BowlsURL {
    Chat0("../assets/images/gamelle/chat_0"),
    Cat1("../assets/images/gamelle/chat_1"),
    Cat2("../assets/images/gamelle/chat_2"),
    Cat3("../assets/images/gamelle/chat_3"),
    Cat4("../assets/images/gamelle/chat_4"),

    Chien0("../assets/images/gamelle/chien_0"),
    Chien1("../assets/images/gamelle/chien_1"),
    Chien2("../assets/images/gamelle/chien_2"),
    Chien3("../assets/images/gamelle/chien_3"),
    Chien4("../assets/images/gamelle/chien_4"),

    Robot0("../assets/images/gamelle/robot_0"),
    Robot1("../assets/images/gamelle/robot_1"),
    Robot2("../assets/images/gamelle/robot_2"),
    Robot3("../assets/images/gamelle/robot_3"),
    Robot4("../assets/images/gamelle/robot_4"),

    Lapin0("../assets/images/gamelle/lapin_0"),
    Lapin1("../assets/images/gamelle/lapin_1"),
    Lapin2("../assets/images/gamelle/lapin_2"),
    Lapin3("../assets/images/gamelle/lapin_3"),
    Lapin4("../assets/images/gamelle/lapin_4");

    private String url;
 
    BowlsURL(String url) {
        this.url = url;
    }
 
    public String getUrl() {
        return url;
    }
}
