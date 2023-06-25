package cricket_calculator;

import java.util.Scanner;

class Player {
    String name;
    int runs;
    double strikeRate;

    Player(String name) {
        this.name = name;
        this.runs = 0;
        this.strikeRate = 0;
    }
}

class Team {
    String name;
    Player[] players;
    int score;
    int wickets;

    Team(String name) {
        this.name = name;
        this.players = new Player[5];
        this.score = 0;
        this.wickets = 0;
    }
}

public class CricketCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Team chennai = new Team("Chennai");
        Team punjab = new Team("Punjab");

        initializePlayers(chennai);
        initializePlayers(punjab);

        simulateMatch(chennai, punjab, scanner);

        System.out.println("\nMatch Summary:");
        System.out.println(chennai.name + " - " + chennai.score + "/" + chennai.wickets + " (" + getOversString(chennai.wickets) + " over)");
        System.out.println(punjab.name + " - " + punjab.score + "/" + punjab.wickets + " (" + getOversString(punjab.wickets) + " over)");

        scanner.close();
    }

    public static void initializePlayers(Team team) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter player names for team " + team.name + ":");

        for (int i = 0; i < team.players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            String playerName = scanner.nextLine();
            team.players[i] = new Player(playerName);
        }
    }

    public static void simulateMatch(Team battingTeam, Team bowlingTeam, Scanner scanner) {
        int overCount = 0;
        int ballCount = 0;
        int currentPlayerIndex = 0;

        while (overCount < 5 && battingTeam.wickets < 2) {
            Player currentPlayer = battingTeam.players[currentPlayerIndex];
            System.out.println("\nCurrent Batsman: " + currentPlayer.name);

            System.out.print("Enter runs scored: ");
            int runsScored = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            currentPlayer.runs += runsScored;
            battingTeam.score += runsScored;

            ballCount++;
            double strikeRate = (double) battingTeam.score / ballCount * 100;
            currentPlayer.strikeRate = Math.round(strikeRate * 100.0) / 100.0;

            if (runsScored % 2 != 0) {
                currentPlayerIndex = (currentPlayerIndex + 1) % battingTeam.players.length;
            }

            if (ballCount % 6 == 0) {
                overCount++;
            }

            if (overCount < 5) {
                System.out.println("Current Score: " + battingTeam.score + "/" + battingTeam.wickets +
                        " (" + getOversString(overCount) + " over)");
            }
        }
    }

    public static String getOversString(int ballCount) {
        int overs = ballCount / 6;
        int balls = ballCount % 6;
        return overs + "." + balls;
    }
}
