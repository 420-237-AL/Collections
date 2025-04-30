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

    public void ajouterTout(Collection<ParamType> autre) { // Équivalent à 'ArrayList.addAll(collection)'
        int stop = autre.getNbElements(); // Cette ligne permet d'éviter une boucle infinie si autre == this;
        for (int i = 0; i < stop; i++)
            this.ajouter(autre.get(i));
    }
}
