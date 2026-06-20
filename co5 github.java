import java.util.Scanner;

public class CricketScoringService {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int runs = 0;
        int wickets = 0;
        int balls = 0;

        System.out.println("===== Cricket Scoring Service =====");

        while (wickets < 10 && balls < 120) { // T20 Match

            System.out.println("\nEnter ball result:");
            System.out.println("0,1,2,3,4,6 = Runs");
            System.out.println("W = Wicket");
            System.out.println("WD = Wide");
            System.out.println("NB = No Ball");
            System.out.println("END = Finish Match");

            String input = sc.next();

            if (input.equalsIgnoreCase("END")) {
                break;
            }

            if (input.equalsIgnoreCase("W")) {
                wickets++;
                balls++;
            } 
            else if (input.equalsIgnoreCase("WD")) {
                runs += 1;
            } 
            else if (input.equalsIgnoreCase("NB")) {
                runs += 1;
            } 
            else {
                try {
                    int run = Integer.parseInt(input);

                    if (run == 0 || run == 1 || run == 2 ||
                        run == 3 || run == 4 || run == 6) {

                        runs += run;
                        balls++;
                    } else {
                        System.out.println("Invalid input!");
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    continue;
                }
            }

            int overs = balls / 6;
            int remainingBalls = balls % 6;

            System.out.println("--------------------------------");
            System.out.println("Score : " + runs + "/" + wickets);
            System.out.println("Overs : " + overs + "." + remainingBalls);
            System.out.println("--------------------------------");
        }

        System.out.println("\n===== Match Finished =====");

        int overs = balls / 6;
        int remainingBalls = balls % 6;

        System.out.println("Final Score : " + runs + "/" + wickets);
        System.out.println("Overs Played: " + overs + "." + remainingBalls);

        sc.close();
    }
}

