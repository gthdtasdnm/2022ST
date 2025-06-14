import java.util.*;
import java.util.stream.Collectors;

public class RemainingPlayersVisitor implements Visitor<List<String>> {

    @Override
    public List<String> visit(SeededGame g) {
        return List.of(g.getPlayer1(), g.getPlayer2());
    }

    @Override
    public List<String> visit(OrdinaryGame g) {
        return filterPlayers(g.getPlayer1(), g.getPlayer2());
    }

    @Override
    public List<String> visit(ByeGame g) {
        return filterPlayers(g.getPlayer1(), g.getPlayer2());
    }

    private List<String> filterPlayers(String p1, String p2) {
        return Arrays.asList(p1, p2).stream()
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }
}

