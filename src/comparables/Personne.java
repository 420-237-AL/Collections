package comparables;

public class Personne implements NotreComparable {
    protected String prenom, nom;
    protected int age;
    private final String NAS;

    public Personne(String prenom, String nom, int age)
            throws IllegalArgumentException /* Ici, le "throws ..." est optionnel. */ {
        this.prenom = prenom;
        this.nom = nom;
        //this.age = age > 0 ? age : -1;
        if (age <= 0)
            throw new IllegalArgumentException("L'âge doit être positif.");
        this.NAS = nom + prenom.substring(0, 2) + age;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean isEqual(NotreComparable autre) {
        //if (autre.getClass() == comparables.Personne.class) {
        if (autre instanceof Personne) {
            Personne pAutre = (Personne) autre;
            return this.NAS.equals(pAutre.NAS);
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

    @Override
    public String toString() {
        return prenom + " " + nom;
    }

    public static void main(String[] args) {
        Personne p1 = null, e1 = null, e2 = null;
        try {
            p1 = new Personne("Alice", "Practice", 10);
            e1 = new Etudiant("Alice", "Practice", 20, 98, 60.0, ProgrammeEtudes.TINFO);
            e2 = new Etudiant("Bob", "Morane", -30, 99, 60.0, ProgrammeEtudes.TEEB);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            e2 = new Etudiant("Bob", "Morane", 40, 99, 60.0, ProgrammeEtudes.TEEB);
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Le tableau des personnes est plein!");
        }
        catch (Exception e) {
            System.err.println("Une erreur est survenue :(");
        }

        System.out.println(p1);
        System.out.println(e1);
        System.out.println(e2);

        System.out.println("p1 == e1 : " + p1.isEqual(e1));
        System.out.println("e1 == e2 : " + e1.isEqual(e2));

        try {
            Produit banane = new Produit("Banane", 10.0f);
            System.out.println(banane);
            System.out.println("p1 == banane : " + p1.isEqual(banane));
        }
        catch (IDReserveException e) {
            System.err.println(e.getMessage());
            throw new IllegalStateException("Produits avec id identiques détectés.");
        }
    }
}
