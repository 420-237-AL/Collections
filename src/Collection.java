public abstract class Collection<ParamType> {
    protected int nbElements = 0;

    public int getNbElements() { // Équivalent à 'ArrayList.size()'
        return nbElements;
    }
    public boolean estVide() { // Équivalent à 'ArrayList.isEmpty()'
        return nbElements == 0;
    }

    public abstract ParamType get(int index);

    public abstract void ajouter(ParamType element);
    public abstract void ajouter(ParamType element, int index);

    public void ajouterTout(Collection<ParamType> autre) { // Équivalent à 'List.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }

    public int trouver(ParamType element) { // Équivalent à 'List.indexOf(element)'
        for (int i = 0; i < nbElements; i++)
            if (get(i) == element) // La complexité de cette méthode va dépendre de celle de 'get(index)'.
                return i;
        return -1;
    }

    // Cette "surcharge" de trouverTout() retourne le nombre d'éléments communs entre les collections;
    public int trouverNbCommuns(Collection<ParamType> autre) { // Elle accepte toutes les sortes de Collection.
        int communs = 0;
        for (int i = 0; i < autre.getNbElements(); i++)
            if (this.trouver(autre.get(i)) != -1)
                communs++;
        return communs;
    }

    public boolean trouverTout(Collection<ParamType> autre) {
        return (this.trouverNbCommuns(autre) == autre.getNbElements()); // Pas besoin d'un 'if' puisque l'opérateur '==' retourne déjà un booléen.
    }

    public abstract boolean retirer(int index); // N'est pas exigé dans les notes de cours, mais est plutôt utile.

    public boolean retirer(ParamType element) {
        int index = trouver(element);
        return index != -1 ? retirer(index) : false;
    }

    public boolean retirerTout(Collection<ParamType> autre) {
        boolean reussite = true;
        for (int i = 0; i < autre.getNbElements(); i++)
            reussite &= this.retirer(autre.get(i)); // L'opérateur '&=' est comme l'opérateur '+=' mais pour l'opération '&&'.
        return reussite;
    }
}
