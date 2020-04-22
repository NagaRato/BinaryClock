import java.time.LocalTime;
import java.time.Period;

import java.util.function.Function;

public class BinairyClock {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            double halfTimeSeconds = LocalTime.now().getSecond() + 60*LocalTime.now().getMinute() + 3600*LocalTime.now().getHour();
            double fraction = halfTimeSeconds/86400;
            Double binFraction = new Double(fraction*Math.pow(2, 16));
            System.out.println("halfTimeSeconds = " + halfTimeSeconds);
            System.out.println("fractie van de dag vanaf middernacht: " + fraction + " " + binFraction + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + ":" + LocalTime.now().getSecond());
            for (int i = 0; i <16; i++) {
                boolean lamp = Math.floor(binFraction) % 2 == 0;
                binFraction = Math.floor(binFraction/2.0);
                System.out.print(lamp ? " ." : " X");
                if ((i+1) % 4 == 0) {
                    System.out.println(" ");
                }
            }
            System.out.println();
            Thread.sleep(1000);
        }
    }
}