package collections;

public class Liste<ParamType> extends Collection<ParamType> {
    private Noeud premier = null; // Dans une liste, il n'y a pas de tableau, seulement un pointeur vers le premier Noeud.

    // Lorsqu'une classe est seulement utile comme "partie" d'une autre, on peut la déclarer à l'intérieur de sa parente.
    private class Noeud {
        // La classe Noeud n'étant qu'un simple conteneur de données, on peut laisser ses attributs 'public'.
        public ParamType valeur;
        public Noeud suivant; // Chaque noeud contient un pointeur vers le prochain noeud de la liste.

        public Noeud(ParamType valeur) {
            this.valeur = valeur;
            this.suivant = null;
        }

        public Noeud(ParamType valeur, Noeud suivant) {
            this.valeur = valeur;
            this.suivant = suivant;
        }

        @Override
        public String toString() {
            if (suivant != null)
                return String.valueOf(valeur) + " -> " + String.valueOf(suivant.valeur);
            else
                return String.valueOf(valeur);
        }
    }

    public ParamType get(int index) {
        if (index >= nbElements)
            throw new IndexOutOfBoundsException(); // Nous verrons les Exceptions plus tard dans le cours.
        return getNoeud(index).valeur;
    }

    // Trouve le noeud à "l'index" désiré
    private Noeud getNoeud(int index) {
        if (index < 0)
            return null;

        Noeud courant = premier;
        int i = 0;
        while (courant.suivant != null && i < index) {
            courant = courant.suivant;
            i++;
        }
        return courant; // Note: Si 'index' est plus grand que nbElements, retourne le dernier noeud.
    }

    public void ajouterDebut(ParamType element) { // Cette méthode n'est pas nécessaire, mais elle est super simple.
        premier = new Noeud(element, premier);
        // La ligne ci-dessus est équivalente à:
        // Noeud nouveau = new Noeud(element);
        // nouveau.suivant = premier;
        // premier = nouveau;
        nbElements++;
    }

    public void ajouter(ParamType element) {
        ajouter(element, nbElements); // C'est moins de travail de déléguer à ajouter(element, index) que de tout réécrire.
    }

    public void ajouter(ParamType element, int index) {
        Noeud nouveau = new Noeud(element);
        if (premier == null || index == 0) {
            nouveau.suivant = premier;
            premier = nouveau;
        }
        else {
            // Étape 1: Trouver le noeud précédent celui à l'index recherché.
            Noeud precedent = getNoeud(index - 1);

            // Étape 2: Ajouter le nouveau noeud entre le noeud précédent l'index cherché et son noeud suivant actuel.
            nouveau.suivant = precedent.suivant;
            precedent.suivant = nouveau;
        }
        nbElements++;
    }

    @Override // Cette redéfinition de 'trouver()' est sensiblement plus rapide que celle de base pour obtenir son résultat.
    public int trouver(ParamType element) {
        int i = 0;
        for (Noeud courant = premier; courant != null; courant = courant.suivant) {
            if (courant.valeur == element)
                return i;
            else
                i++;
        }
        return -1;
    }

    public boolean retirer(int index) { // N'est pas exigé dans les notes de cours, mais est plutôt utile.
        if (index >= nbElements)
            return false;
        if (index == 0) { // Retirer le premier élément de la liste est super simple:
            premier = premier.suivant;
        }
        else { // Dans le cas général, on retire le noeud à l'index cible en liant son noeud précédent à son noeud suivant.
            Noeud precedent = getNoeud(index - 1);
            precedent.suivant = precedent.suivant.suivant;
        }
        nbElements--;
        return true;
    }

    // Ici ce n'est pas vraiment une "redéfinition" de la méthode retirerTout(collections.Collection) car cette variante ne fonctionne qu'avec des listes.
    public boolean retirerTout(Liste<ParamType> autre) {
        boolean reussite = true;
        // Version 2: On fait une boucle directement sur les noeuds de l'autre collections.Liste, évitant ainsi la double boucle de get().
        for (Noeud courant = autre.premier; courant != null; courant = courant.suivant)
            reussite &= retirer(courant.valeur);
        return reussite;
    }

    public void retirerTout() {
        this.premier = null;
        this.nbElements = 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (nbElements > 0) {
            s.append(premier.valeur); // Le premier élément est imprimé séparément pour éviter d'avoir une virgule de trop.
            // On commence ensuite la boucle à partir du deuxième noeud:
            for (Noeud courant = premier.suivant; courant != null; courant = courant.suivant)
                s.append(", ").append(courant.valeur);
        }
        return s + "]";
    }
}
