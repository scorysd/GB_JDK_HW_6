import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int switchWins = 0;
        int stayWins = 0;
        int step = 0;
        HashMap result = new HashMap<>();
        Random gen = new Random();
        for (int plays = 0; plays < 1000; plays++) {
            int[] doors = {0, 0, 0};
            doors[gen.nextInt(3)] = 1;
            int choice = gen.nextInt(3);
            int shown;
            do {
                shown = gen.nextInt(3);
            } while (doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];
            switchWins += doors[3 - choice - shown];
            step++;
            result.put(step, stayWins);
        }
        System.out.println("Switching wins " + switchWins + " times.");
        System.out.println("Staying wins " + stayWins + " times.");
        System.out.println(result);
    }

}

