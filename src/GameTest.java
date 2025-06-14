import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

public class GameTest {

    @Test
    public void testSeededGame_getPlayersAndWinner() {
        Game g = new SeededGame("A", "B");
        assertEquals("A", g.getPlayer1());
        assertEquals("B", g.getPlayer2());
        assertNull(g.getWinner());

        g.setWinner("B");
        assertEquals("B", g.getWinner());
        assertThrows(IllegalStateException.class, () -> g.setWinner("A"));
    }

    @Test
    public void testSeededGame_getAllPlayers() {
        Game g = new SeededGame("A", "B");
        List<String> players = g.getAllPlayers();
        assertTrue(players.containsAll(List.of("A", "B")));
        assertEquals(2, players.size());
    }

    @Test
    public void testByeGame_getPlayers() {
        Game g1 = new SeededGame("A", "B");
        g1.setWinner("A");
        Game g2 = new ByeGame("X", g1);
        assertEquals("X", g2.getPlayer1());
        assertEquals("A", g2.getPlayer2());
    }

    @Test
    public void testByeGame_getAllPlayers() {
        Game g1 = new SeededGame("A", "B");
        Game g2 = new ByeGame("X", g1);
        List<String> all = g2.getAllPlayers();
        assertTrue(all.containsAll(List.of("A", "B", "X")));
    }

    @Test
    public void testOrdinaryGame_getAllPlayers() {
        Game g1 = new SeededGame("A", "B");
        Game g2 = new SeededGame("C", "D");
        Game g3 = new OrdinaryGame(g1, g2);
        List<String> all = g3.getAllPlayers();
        assertTrue(all.containsAll(List.of("A", "B", "C", "D")));
    }

    @Test
    public void testSetWinnerInvalidConditions() {
        Game g1 = new SeededGame("A", "B");
        assertThrows(IllegalArgumentException.class, () -> g1.setWinner("X"));

        Game g2 = new SeededGame("A", "B");
        g2.setWinner("A");
        assertThrows(IllegalStateException.class, () -> g2.setWinner("B"));
    }

    @Test
    public void testVisitor_acceptCalled() {
        Game g1 = new SeededGame("A", "B");
        Game g2 = new SeededGame("C", "D");
        Game g3 = new OrdinaryGame(g1, g2);
        Game g4 = new ByeGame("X", g1);

        Visitor<String> mockVisitor = new Visitor<>() {
            @Override public String visit(SeededGame g) { return "Seeded"; }
            @Override public String visit(OrdinaryGame g) { return "Ordinary"; }
            @Override public String visit(ByeGame g) { return "Bye"; }
        };

        assertEquals("Seeded", g1.accept(mockVisitor));
        assertEquals("Ordinary", g3.accept(mockVisitor));
        assertEquals("Bye", g4.accept(mockVisitor));
    }

    @Test
    public void testRemainingPlayersVisitor() {
        Game g1 = new SeededGame("A", "B");
        g1.setWinner("A");
        Game g2 = new SeededGame("C", "D");
        g2.setWinner("C");
        Game g3 = new OrdinaryGame(g1, g2);
        g3.setWinner("C");
        Game g4 = new SeededGame("E", "F");
        g4.setWinner("F");
        Game g5 = new OrdinaryGame(g3, g4);

        RemainingPlayersVisitor visitor = new RemainingPlayersVisitor();
        List<String> remaining = g5.accept(visitor); // ✅ kein Cast, dank generischer Visitor

        // Hinweis: Die Reihenfolge kann variieren
        assertTrue(remaining.containsAll(List.of("C", "F")));
        assertEquals(2, remaining.size());
    }

}
