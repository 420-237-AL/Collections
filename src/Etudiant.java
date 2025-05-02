public class Etudiant {
    public String nom;
    public int matricule;
    public double moyenne;

    /* Constructeur de la classe Étudiant (nous verrons ça plus tard...)
    public Etudiant(String nom, int matricule, double moyenne) {
        this.nom = nom;
        this.matricule = matricule;
        this.moyenne = moyenne;
    }
    */

    /* Méthode qui compile et marche, mais le paramètre "e" est redondant.
    public void afficher(Etudiant e) {
        //System.out.println(david.nom + " (" + david.matricule + ") : " + david.moyenne); // Ne compile pas
        System.out.println(e.nom + " (" + e.matricule + "): " + e.moyenne);
    }
    */

    public void afficher() {
        //System.out.println(e.nom + " (" + e.matricule + "): " + e.moyenne); // Ne compile pas
        System.out.println(nom + " (" + matricule + "): " + moyenne);
        //System.out.printf("%s (%d): %.2f\n", nom, matricule, moyenne); // Avec printf, c'est plus lisible.
    }

    /* Méthode toString standard de Java (alternative à "afficher()") */
    @Override
    public String toString() {
        return nom + " (" + matricule + "): " + moyenne;
        //return String.format("%s (%d): %.2f\n", nom, matricule, moyenne);
    }
}
