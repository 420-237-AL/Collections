public class Produit {
    private String nom;
    private float prix;
    private final int id; // une "fausse" constante

    private static int nbProduits;
    public static final float PRIX_MAX = 1000;
    public static final double TAXE = 0.15; // une "vraie" constante

    public static int getNbProduits() {
        return nbProduits;
    }

    public double calulerTaxe() {
        return prix * (1 + TAXE);
    }

    public Produit(String nom, float prix, int id) {
        this.nom = nom;
        this.prix = prix;
        this.id = id;
    }

    public Produit(String nom, double prix, int id) {
//        this.nom = nom;
//        this.prix = (float)prix;
//        this.id = id;
        this(nom, (float)prix, id);
    }

    public Produit(String nom, float prix) {
//        this.nom = nom;
//        this.prix = prix;
//        this.id = nbProduits++;
        this(nom, prix, nbProduits++);
    }

    // Constructeur de copie
    public Produit(Produit original) {
        this.nom = original.nom;
        this.prix = original.prix;
        this.id = original.id;
    }

    public Produit copier() {
        // La méthode copier utilise le constructeur de copie
        return new Produit(this);
    }

    public boolean comparer(Produit autre) {
        return (this.nom.equalsIgnoreCase(autre.nom)
                && this.id == autre.id);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        if (prix > 0 && prix <= PRIX_MAX)
            this.prix = prix;
    }

    public Produit getById(int id_cherche) {
        if (this.id == id_cherche)
            return this;
        return null;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    @Override // Annotation optionnelle
    public String toString() {
        return nom + " : " + prix + " : " + id;
    }
}






















