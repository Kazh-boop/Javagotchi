package app.model;
import java.util.Timer;
import java.util.TimerTask;

public class TimeManager {
    

    public TimeManager() {
        int i = 0;
        Timer t = new  Timer();
        Cat c = new Cat("Aa");
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                c.setHappiness(c.getHappiness() - c.decreaseValue());
            }
        }, 10);
    }
}
