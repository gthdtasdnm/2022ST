public interface Visitor<T> {
    T visit(SeededGame g);
    T visit(OrdinaryGame g);
    T visit(ByeGame g);
}
