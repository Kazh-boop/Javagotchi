package app.util;

public enum BowlsURL {
    CATBOWL_0("../assets/images/gamelle/chat_0"),
    CATBOWL_1("../assets/images/gamelle/chat_1"),
    CATBOWL_2("../assets/images/gamelle/chat_2"),
    CATBOWL_3("../assets/images/gamelle/chat_3"),
    CATBOWL_4("../assets/images/gamelle/chat_4"),

    DOGBOWL_0("../assets/images/gamelle/chien_0"),
    DOGBOWL_1("../assets/images/gamelle/chien_1"),
    DOGBOWL_2("../assets/images/gamelle/chien_2"),
    DOGBOWL_3("../assets/images/gamelle/chien_3"),
    DOGBOWL_4("../assets/images/gamelle/chien_4"),

    ROBOTBOWL_0("../assets/images/gamelle/robot_0"),
    ROBOTBOWL_1("../assets/images/gamelle/robot_1"),
    ROBOTBOWL_2("../assets/images/gamelle/robot_2"),
    ROBOTBOWL_3("../assets/images/gamelle/robot_3"),
    ROBOTBOWL_4("../assets/images/gamelle/robot_4"),

    RABBITBOWL_0("../assets/images/gamelle/lapin_0"),
    RABBITBOWL_1("../assets/images/gamelle/lapin_1"),
    RABBITBOWL_2("../assets/images/gamelle/lapin_2"),
    RABBITBOWL_3("../assets/images/gamelle/lapin_3"),
    RABBITBOWL_4("../assets/images/gamelle/lapin_4");

    private String url;
 
    BowlsURL(String url) {
        this.url = url;
    }
 
    public String getUrl() {
        return url;
    }
}
