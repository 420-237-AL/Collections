public class Vecteur<ParamType> extends Collection<ParamType> {
    private static final int CAPACITE_INITIALE = 5, RATIO_AGRANDISSEMENT = 2;

    private ParamType[] tab; // Les données du Vecteur sont stockées dans un tableau (array).

    // Constructeur avec une capacité initiale configurable (n'est pas exigé dans les notes de cours)
    public Vecteur(int capaciteInitiale) {
        this.tab = (ParamType[])(new Object[capaciteInitiale]);
    }

    // Constructeur vide (qui utilise la capacité initiale par défaut)
    public Vecteur() {
        this(CAPACITE_INITIALE); // Délégation au constructeur avec une taille initiale.
    }

    private boolean estPlein() {
        return nbElements == tab.length;
    }

    public ParamType get(int index) { // Appelé 'getElementAt()' dans les notes de cours
        if (index >= nbElements)
            throw new IndexOutOfBoundsException(); // Nous verrons les Exceptions plus tard dans le cours.
        return tab[index];
    }

    private void resize(int nouvelleCapacite) { // Permet d'agrandir ou de réduire la capacité du Vecteur.
        assert nouvelleCapacite >= nbElements;
        ParamType[] newTab = (ParamType[]) (new Object[nouvelleCapacite]);
        for (int i = 0; i < nbElements; i++)
            newTab[i] = tab[i];
        tab = newTab;
    }

    private void agrandir(int taille) {
        if (nbElements + taille > tab.length)
            resize(nbElements + taille);
    }

    private void agrandir() {
        resize(tab.length * RATIO_AGRANDISSEMENT);
    }

    public void ajouter(ParamType element) { // Équivalent à 'ArrayList.add(element)'
        if (estPlein())
            agrandir();
        tab[nbElements++] = element;
    }

    public void ajouter(ParamType element, int index) { // Équivalent à 'ArrayList.add(index, element)'
        if (estPlein())
            agrandir();
        for (int i = nbElements; i >= index; i--)
            tab[i] = tab[i - 1];
        tab[index] = element;
        nbElements++;
    }

    @Override // Cette version de ajouterTout() est optimisée pour la classe Vecteur.
    public void ajouterTout(Collection<ParamType> autre) {
        agrandir(autre.getNbElements()); // On agrandit d'un coup le vecteur à une taille suffisante.
        super.ajouterTout(autre); // Puis on continue "normalement" avec la méthode de notre superclasse.
    }

    public boolean retirer(int index) { // N'est pas exigé dans les notes de cours, mais est plutôt utile.
        if (index >= nbElements) // Ceci est une "clause de garde", ça sert à quitter immédiatement la fonction en cas d'erreur.
            return false;
        nbElements--;
        for (int i = index; i < nbElements; i++)
            tab[i] = tab[i + 1];
        return true;
    }

    public void retirerTout() { // Équivalent à 'ArrayList.clear()'
        this.tab = (ParamType[])(new Object[CAPACITE_INITIALE]); // Créer un nouveau tableau va libérer la mémoire de l'ancien.
        this.nbElements = 0;
    }

    @Override
    public String toString() { // N'est pas exigé dans les notes de cours, mais est très pratique.
        StringBuilder s = new StringBuilder("["); // Un 'StringBuilder' est comme une 'String', mais beaucoup plus efficace
        if (nbElements > 0)                       // quand on veut fréquemment ajouter (append) des caractères à la string.
            s.append(tab[0]); // Le premier élément est imprimé séparément pour éviter d'avoir une virgule de trop.
        for (int i = 1; i < nbElements; i++) // On commence ensuite la boucle à partir du deuxième noeud:
            s.append(", ").append(tab[i]);
        return s + "]";
    }
}
