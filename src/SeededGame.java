import java.util.*;

public class SeededGame extends Game {

    private String player1;
    private String player2;

    public SeededGame(String player1, String player2) {
        super();
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String getPlayer1() {
        return player1;
    }

    @Override
    public String getPlayer2() {
        return player2;
    }

    @Override
    public List<String> getAllPlayers() {
        return List.of(player1, player2);
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
