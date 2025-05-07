package comparables;

public class Personne implements NotreComparable {
    protected String prenom, nom;
    protected int age;
    private final String NAS;

    public Personne(String prenom, String nom, int age) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age > 0 ? age : -1;
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

    public String toString() {
        return prenom + " " + nom + " (" + age + " ans)";
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

    public static void main(String[] args) {
        Personne p1 = new Personne("Alice", "Practice", 20);
        Personne e1 = new Etudiant("Alice", "Practice", 20, 98, 60.0, ProgrammeEtudes.TINFO);
        Personne e2 = new Etudiant("Bob", "Morane", 40, 99, 60.0, ProgrammeEtudes.TEEB);

        System.out.println(p1);
        System.out.println(e1);
        System.out.println(e2);

        System.out.println("p1 == e1 : " + p1.isEqual(e1));
        System.out.println("e1 == e2 : " + e1.isEqual(e2));

        Produit banane = new Produit("Banane", 10.0f);
        System.out.println("p1 == banane : " + p1.isEqual(banane));
    }
}
