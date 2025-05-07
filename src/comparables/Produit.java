package comparables;

public class Produit implements NotreComparable {
    private String nom;
    private double prix;
    private final int id; // une "fausse" constante

    private static int nbProduits;
    public static final double PRIX_MAX = 1000;
    public static final double TAXE = 0.15; // une "vraie" constante

    public static int getNbProduits() {
        return nbProduits;
    }

    public double calculerTaxe() {
        return prix * (1 + TAXE);
    }

    public Produit(String nom, double prix, int id) {
        this.nom = nom;
        this.prix = prix;
        this.id = id;
    }

    public Produit(String nom, float prix) {
        this(nom, prix, nbProduits++);
    }

    // Constructeur de copie
    public Produit(Produit original) {
        this.nom = original.nom;
        this.prix = original.prix;
        this.id = original.id;
    }

    public Produit copier() {
        // La méthode copier() utilise le constructeur de copie
        return new Produit(this);
    }

    public String getNom() {
        return this.nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        if (prix > 0 && prix <= PRIX_MAX)
            this.prix = prix;
    }

    public int getId() {
        return id;
    }

    @Override // Annotation optionnelle
    public String toString() {
        return nom + " : " + prix + " : " + id;
    }

    public boolean comparer(Produit autre) {
        return (this.nom.equalsIgnoreCase(autre.nom)
                && this.id == autre.id);
    }

    @Override
    public boolean isEqual(NotreComparable autre) {
        if (autre instanceof Produit) {
            Produit pAutre = (Produit) autre;
            return (this.nom.equalsIgnoreCase(pAutre.nom)
                    && this.id == pAutre.id);
        }
        return false;
    }

    @Override
    public boolean isLessThan(NotreComparable autre) {
        return false;
    }

    @Override
    public boolean isGreaterThan(NotreComparable autre) {
        return false;
    }
}
