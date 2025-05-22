package comparables;

public class IDReserveException extends Exception {
    private final int id;

    public IDReserveException(int id) {
        super("Le id " + id + " est déjà utilisé");
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
