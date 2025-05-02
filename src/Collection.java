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

    public int trouver(ParamType element) { // Équivalent à 'ArrayList.indexOf(element)'
        for (int i = 0; i < nbElements; i++)
            if (get(i) == element) // On utilise get(i) au lieu de tab[i]; En fait le même code marcherait dans Vecteur aussi.
                return i;
        return -1;
    }
}
