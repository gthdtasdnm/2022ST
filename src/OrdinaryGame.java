import java.util.*;

public class OrdinaryGame extends Game {

    private Game game1;
    private Game game2;

    public OrdinaryGame(Game game1, Game game2) {
        super();
        this.game1 = game1;
        this.game2 = game2;
    }

    public Game getGame1() {
        return game1;
    }

    public Game getGame2() {
        return game2;
    }

    @Override
    public String getPlayer1() {
        return game1.getWinner();
    }

    @Override
    public String getPlayer2() {
        return game2.getWinner();
    }

    @Override
    public List<String> getAllPlayers() {
        List<String> result = new ArrayList<>();
        result.addAll(game1.getAllPlayers());
        result.addAll(game2.getAllPlayers());
        return result;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
