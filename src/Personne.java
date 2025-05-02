public class Personne {
    private String nom, prenom;
    private String adresse;
    private int age;

    public Personne(String nom, String prenom, String adresse, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.age = age > 0 ? age : -1;
    }

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = "";
        this.age = age > 0 ? age : -1;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAge() {
        return age;
    }

    public void afficher() {
        System.out.println(prenom + " " + nom + " (" + age + " ans)");
    }

/*
    public static boolean compare(Personne p1, Personne p2) {
        if (p1.age > p2.age) {
            System.out.println(p1.prenom + " est plus vieux que " + p2.prenom);
            return true;
        }
        else {
            System.out.println(p2.prenom + " est plus vieux que " + p1.prenom);
            return false;
        }
    }
 */

    public boolean compareAvec(Personne autre) {
        if (this.age > autre.age) {
            System.out.println("Je (" + this.prenom + ") suis plus vieux que " + autre.prenom);
            return true;
        }
        else {
            System.out.println(autre.prenom + " est plus vieux que moi (" + this.prenom + ")");
            return false;
        }
    }

    public static void main(String[] args) {
        Personne david = new Personne("Giasson", "David", "4.170.3", 30);

        //System.out.println(david.prenom + " " + david.nom + " (" + david.age + " ans)"); // Ça marche, mais c'est long...
        //afficher(david); // Ne compilera pas (sans créer une fonction "afficher(Personne p)")
        david.afficher(); // Ça c'est penser en OO :)

        Personne michel = new Personne("Généreux", "Michel",  50);
        michel.afficher();

        Personne alice = new Personne(" au pays des merveilles", "Alice", 15);

        System.out.println();

        david.compareAvec(michel);
        michel.compareAvec(david);

        david.compareAvec(alice);
        michel.compareAvec(alice);
    }
}
