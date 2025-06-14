import java.util.ArrayList;
import java.util.List;

public class ByeGame extends Game{
    private String player1;
    private Game game2;

    public ByeGame(String player1, Game game2){
        super();
        this.player1 = player1;
        this.game2 = game2;
    }

    public Game getGame2() {
        return game2;
    }

    @Override
    public String getPlayer1() {
        return player1;
    }

    @Override
    public String getPlayer2() {
        return game2.getWinner();
    }

    @Override
    public List<String> getAllPlayers() {
        List<String> res = new ArrayList<String>();
        res.add(player1);
        res.addAll(game2.getAllPlayers());
        return res;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
