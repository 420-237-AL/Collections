package comparables;

public interface NotreComparable {
    // Les mots clés 'public' et 'abstract' sont inutiles parce qu'ils sont implicites dans une interface.
    boolean isEqual(NotreComparable autre);
    boolean isLessThan(NotreComparable autre);
    boolean isGreaterThan(NotreComparable autre);
}
