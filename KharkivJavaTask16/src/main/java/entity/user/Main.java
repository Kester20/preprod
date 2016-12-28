package entity.user;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Said_Sulaiman_Arsala on 12/28/2016.
 */
public class Main {

    public static void main(String[] args) {
        Time time = new Time(System.currentTimeMillis() + 1000*30*60);
        System.out.println(time + " | "  + new Time(System.currentTimeMillis()));
        if(time.getTime() < new Time(System.currentTimeMillis()).getTime()){
            System.out.println("!!!!!");
        }
    }
}
