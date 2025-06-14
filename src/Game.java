import java.util.*;

public abstract class Game {

    private static int counter = 0;
    private int id;
    private String winner;

    public Game() {
        this.id = counter++;
        this.winner = null;
    }

    public int getId() {
        return id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String w) {
        if (this.winner != null) {
            throw new IllegalStateException("Winner already set.");
        }

        String p1 = getPlayer1();
        String p2 = getPlayer2();

        if (p1 == null || p2 == null) {
            throw new IllegalStateException("Players not yet decided.");
        }

        if (!w.equals(p1) && !w.equals(p2)) {
            throw new IllegalArgumentException("Winner must be one of the players.");
        }

        this.winner = w;
    }

    // Muss von allen konkreten Spielen implementiert werden
    public abstract String getPlayer1();
    public abstract String getPlayer2();
    public abstract List<String> getAllPlayers();

    // Für das Visitor-Pattern
    public abstract <T> T accept(Visitor<T> v);
}

