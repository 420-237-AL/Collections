public class Etudiant extends Personne {
    private int matricule;
    private double moyenne;
    private ProgrammeEtudes programme;

    public Etudiant(String prenom, String nom, int age, int matricule, double moyenne, ProgrammeEtudes programme) {
        super(prenom, nom, age);
        this.matricule = matricule;
        this.moyenne = moyenne;
        this.programme = programme;
    }

    public int getMatricule() {
        return matricule;
    }

    public double getMoyenne() {
        return moyenne;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + programme + " #" + matricule + "]" ;
    }
}
