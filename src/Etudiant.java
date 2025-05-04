public class Etudiant extends Personne {
    private int matricule;
    private double moyenne;

    public Etudiant(String prenom, String nom, int age, int matricule, double moyenne) {
        super(prenom, nom, age);
        this.matricule = matricule;
        this.moyenne = moyenne;
    }

    public int getMatricule() {
        return matricule;
    }

    public double getMoyenne() {
        return moyenne;
    }

    @Override
    public String toString() {
        return super.toString() + " [#" + matricule + "]";
    }
}
