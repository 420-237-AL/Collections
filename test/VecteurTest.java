import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; // Ce 'import' permet de créer des annotations '@Test'.

import static org.junit.jupiter.api.Assertions.*; // Cet import contient les méthodes 'assert*()'.

class VecteurTest {
    // On peut déclarer des variables membres comme dans n'importe quelle classe.
    Vecteur v1;

    // La méthode 'setUp()' sert à initialiser les objets à tester pour éviter de toujours recopier le même code.
    @BeforeEach
    void setUp() { //
        v1 = new Vecteur();
        v1.ajouter('A');
        v1.ajouter('C');
        v1.ajouter('E');
    }

    // Attention, les tests unitaires peuvent être exécutés dans n'importe quel ordre par JUnit!
    // Vous ne devez pas assumer qu'un test sera exécuté avant ou après un autre;
    // Ils doivent tous être indépendants les uns des autres.

    @Test
    void ajouterElement() {
        // Un test unitaire "vide" (ou tout simplement sans assertions) passe toujours,
        // donc il faut toujours s'assurer d'en ajouter au moins une pour qu'il serve à quelque chose.
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());
    }

    @Test
    void ajouterIndex() {
        // Étape 1: Préparer les données du test
        // Ici, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouter('B', 1);
        v1.ajouter('D', 3);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(5, v1.getNbElements());
        assertEquals("[A, B, C, D, E]", v1.toString());
    }

    @Test
    void ajouterVecteur() {
        // Étape 1: Préparer les données du test
        // Pas besoin de préparer une tonne de données, souvent quelques-unes suffisent.
        Vecteur v2 = new Vecteur();
        v2.ajouter('F');
        v2.ajouter('G');
        v2.ajouter('H');

        // Étape 2: Utiliser la ou les méthodes à tester
        v1.ajouterTout(v2);

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(6, v1.getNbElements());
        assertEquals("[A, C, E, F, G, H]", v1.toString());
    }

    @Test
    void trouverElement() {
        // Étape 1: Préparer les données du test
        // Ici aussi, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.trouver('A')); // Trouver le premier élément
        assertEquals(1, v1.trouver('C')); // Trouver un élément au milieu
        assertEquals(2, v1.trouver('E')); // Trouver le dernier élément
        assertEquals(-1, v1.trouver('X')); // Trouver un élément inexistant
    }

    @Test
    void trouverVecteur() {
        // Étape 1: Préparer les données du test
        v1 = new Vecteur(); // Cette fois, on préfère partir d'un nouveau vecteur configuré sur mesure.
        v1.ajouter('A');
        v1.ajouter('B');
        v1.ajouter('C');
        v1.ajouter('D');
        v1.ajouter('E');

        Vecteur v2 = new Vecteur();
        v2.ajouter('A');
        v2.ajouter('C');
        v2.ajouter('E');

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertTrue(v1.trouverTout(v2)); // 'assertTrue(val)' est équivalent à 'assertEquals(true, val)'

        v2.ajouter('X');
        assertEquals(3, v1.trouverNbCommuns(v2));
        assertFalse(v1.trouverTout(v2));
    }

    @Test
    void retirerElement() {
        // Étape 1: Préparer les données du test
        // Ici aussi, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Sous-test: Commençons par tenter de retirer un élément non-existant
        assertFalse(v1.retirer('X'));
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());

        // Étape 2: Utiliser la ou les méthodes à tester
        assertTrue(v1.retirer((Character)'C')); // Retirer un élément au milieu
        assertTrue(v1.retirer((Character)'E')); // Retirer le dernier élément
        assertTrue(v1.retirer((Character)'A')); // Retirer le premier élément

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.getNbElements());
        assertEquals("[]", v1.toString());
    }

    @Test
    void retirerIndex() {
        // Étape 1: Préparer les données du test
        // Ici aussi, on se fie sur la méthode setUp() pour mettre les 3 premiers éléments dans v1.

        // Sous-test: Commençons par tenter de retirer un élément non-existant
        assertFalse(v1.retirer(3));
        assertEquals(3, v1.getNbElements());
        assertEquals("[A, C, E]", v1.toString());

        // Étape 2: Utiliser la ou les méthodes à tester
        assertTrue(v1.retirer(1)); // Retirer un élément au milieu
        assertTrue(v1.retirer(1)); // Retirer le dernier élément (maintenant à l'index 1 après le premier retrait).
        assertTrue(v1.retirer(0)); // Retirer le premier élément

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.getNbElements());
        assertEquals("[]", v1.toString());
    }

    @Test
    void retirerVecteur() {
        // Étape 1: Préparer les données du test
        v1 = new Vecteur(); // Cette fois, on a besoin d'un vecteur configuré sur mesure.
        v1.ajouter('A');
        v1.ajouter('B');
        v1.ajouter('C');
        v1.ajouter('D');
        v1.ajouter('E');

        Vecteur v2 = new Vecteur();
        v2.ajouter('A');
        v2.ajouter('C');
        v2.ajouter('E');

        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertTrue(v1.retirerTout(v2));
        assertEquals(2, v1.getNbElements());
        assertEquals("[B, D]", v1.toString());

        // Sous-test: Retirer un élément inexistant
        Vecteur v3 = new Vecteur();
        v3.ajouter('B');
        v3.ajouter('X');

        assertFalse(v1.retirerTout(v3));
        assertEquals(1, v1.getNbElements());
        assertEquals("[D]", v1.toString());
    }

    @Test
    void retirerTout() {
        // Étape 2: Utiliser la ou les méthodes à tester
        v1.retirerTout();

        // Étape 3: Valider les résultats attendus vs. obtenus
        assertEquals(0, v1.getNbElements());
        assertEquals("[]", v1.toString());
        assertTrue(v1.estVide());
    }

    @Test
    void getIndex() {
        // Étapes 2 et 3: Valider les résultats attendus vs. obtenus
        assertEquals('A', v1.get(0)); // Trouver le premier élément
        assertEquals('C', v1.get(1)); // Trouver un élément au milieu
        assertEquals('E', v1.get(2)); // Trouver le dernier élément

        // Comment tester qu'une Exception est lancée lorsqu'on accède à un index invalide?
        assertThrows(IndexOutOfBoundsException.class, () -> v1.get(3)); // Trouver un élément inexistant
    }
}
