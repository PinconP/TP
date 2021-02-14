package ensembles.ensemblesHeritage2020;

import java.util.ArrayList;
import java.util.Random;

public class MySet {

    /**
     * les entiers seront ranges dans une ArrayList
     */
    protected ArrayList<Double> data;

    /**
     * Constructeur par défaut (facultatif)
     */
    public MySet() {
        data = new ArrayList<Double>();
    }

    /**
     * constructeur par copie
     *
     * @param set ensemble à copier
     */
    public MySet(MySet set) {
        // version alternative :
        // content = new ArrayList<Double>();
        // content.addAll(set.content);
        data = new ArrayList<Double>(set.data);
    }

    /**
     * Supprime tous les éléments de l'ensemble.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Calcule le nb d'éléments
     *
     * @return le nb d'éléments de l'ensemble
     */
    public int size() {
        return data.size();
    }

    /**
     * Teste si l'ensemble est vide
     *
     * @return true si l'ensemble est vide, false sinon
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Ajoute "elem" dans l'ensemble uniquement si il n'est pas déjà présent.
     *
     * @param elem valeur à ajouter
     */
    public void add(double elem) {
        if (!data.contains(elem)) {
            data.add(elem);
        }
    }

    /**
     * Supprime un élément de l'ensemble.
     *
     * @param element élément à supprimer
     */
    public boolean remove(double element) {
        if (data.contains(element)) {
            data.remove(element);
            return true;
        }
        return false;
    }

    /**
     * Recherche la présence d'un élément
     *
     * @param elem élément à chercher
     * @return true si "elem" appartient à l'ensemble et false sinon
     */
    public boolean contains(double elem) {
        return data.contains(elem);
    }

    /**
     * Retourne une valeur ; si l'ensemble est vide on déclenche une assertion.
     *
     * @return une valeur au hasard de l'ensemble
     */
    public double random() {
        assert (!isEmpty()) : "random impossible, ensemble vide";
        Random rand = new Random();
        int i = rand.nextInt(size());
        double choice = data.get(i);
        return choice;
    }

    /**
     * retourne une chaîne de caractères représentative de l'état de l'ensemble
     */
    public String toString() {
        return data.toString();
    }

    /**
     * Compare l'ensemble courant à celui passé en paramètre. Les deux ensembles
     * sont égaux si ils font la même taille et qu'ils contiennent les mêmes
     * valeurs.
     *
     * @param comparedSet ensemble à comparer à l'ensemble courant
     * @return true si les ensembles sont égaux, false sinon
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this) // forcément
            return true;
        if (!(o instanceof MySet))
            return false;
        MySet comparedSet = (MySet) o;
        // Même taille?
        if (this.size() != comparedSet.size())
            return false;
        // Sinon, on teste la présence un à un ... ils ne sont pas ordonnés
        boolean egal = true;
        for (int i = 0; i < this.data.size() && egal; i++) {
            if (!comparedSet.contains(this.data.get(i)))
                // Deux éléments différents
                egal = false;
        }
        return egal;
    }
    //---------- remplacé par le fichier de test junit -----------------
    // /**
    // * Programme principal, sert ici de programme de test
    // * @param args
    // */
    // public static void main(String[] args) {
    // MyCustomSet mySet = new MyCustomSet();
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble est vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 0 : " + mySet.size());
    // System.out.println("");
    // try {
    // System.out.println("element aléatoire : " + mySet.random());
    // System.out.println("");
    // } catch(RuntimeException re) {
    // System.out.println("element aléatoire : pas trouvé");
    // }
    //
    // mySet.add(11);
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 1 : " + mySet.size());
    // System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
    // + " et 12 non : " + mySet.contains(12));
    // System.out.println("");
    // System.out.println("un seul choix possible (11) : " + mySet.random());
    // System.out.println("");
    //
    // mySet.add(12);
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 2 : " + mySet.size());
    // System.out.println("11 appartient a l'ensemble : " + mySet.contains(11)
    // + " et 12 aussi : " + mySet.contains(12));
    // System.out.println("");
    // System.out.println("deux choix possibles (11 ou 12) : " + mySet.random()
    // + " " + mySet.random() + " " + mySet.random());
    // System.out.println("");
    //
    // mySet.add(13);
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 3 : " + mySet.size());
    // System.out.println("11, 12 et 13 appartiennent a l'ensemble : "
    // + mySet.contains(11) + " " + mySet.contains(12) + " "
    // + mySet.contains(13));
    // System.out.println("");
    // System.out.println("trois choix possibles (11, 12, 13) : "
    // + mySet.random() + " " + mySet.random() + " " + mySet.random() + " "
    // + mySet.random() + " " + mySet.random());
    // System.out.println("");
    //
    // mySet.remove(13);
    // System.out.println("Apres suppression de 13, on trouve 11-12: ");
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 2 : " + mySet.size());
    // System.out.println("11, 12 appartiennent a l'ensemble mais plus 13 : "
    // + mySet.contains(11) + " " + mySet.contains(12) + " "
    // + mySet.contains(13));
    // System.out.println("");
    // System.out.println("deux choix possibles (11 ou 12) : " + mySet.random()
    // + " " + mySet.random() + " " + mySet.random());
    // System.out.println("");
    //
    // mySet.remove(11);
    // System.out.println("Apres suppression de 11, on trouve 12: ");
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble n'est pas vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 1 : " + mySet.size());
    // System.out.println("12 appartient a l'ensemble mais plus 11, ni 13 : "
    // + mySet.contains(12) + " " + mySet.contains(11) + " "
    // + mySet.contains(13));
    // System.out.println("");
    // System.out.println("un seul choix possible (12) : " + mySet.random());
    // System.out.println("");
    //
    // mySet.remove(12);
    // System.out.println("Apres suppression de 12, on trouve rien : ");
    // System.out.println(mySet.toString());
    // System.out.println("l'ensemble est vide : " + mySet.isEmpty());
    // System.out.println("sa taille est de 0 : " + mySet.size());
    // System.out.println("ni 11, ni 12, ni 13 n'appartiennent a l'ensemble: "
    // + mySet.contains(11) + " " + mySet.contains(12) + " "
    // + mySet.contains(13));
    // System.out.println("");
    // try {
    // System.out.println("element aléatoire : " + mySet.random());
    // System.out.println("");
    // } catch(RuntimeException re) {
    // System.out.println("element aléatoire : pas trouvé");
    // }
    //
    // System.out.println("Test du clear");
    // mySet.add(1);
    // mySet.add(10);
    // System.out.println("Taille avant clear : " + mySet.size());
    // mySet.clear();
    // System.out.println("Taille après clear : " + mySet.size());
    //
    // System.out.println("Test du equals");
    // MyCustomSet mySet2 = new MyCustomSet();
    // System.out.println("ensemble1 et ensemble2 sont vides, equals = "
    // + mySet.equals(mySet2));
    // mySet.add(1);
    // mySet.add(15);
    // mySet.add(9);
    // System.out.println("Premier ensemble 1, 15, 9");
    // mySet2.add(9);
    // mySet2.add(15);
    // mySet2.add(1);
    // System.out.println("Deuxieme ensemble 9, 15, 1");
    // System.out.println("Equals = "+ mySet.equals(mySet2));
    // System.out.println("On enleve 9 à ensemble 2");
    // mySet2.remove(9);
    // System.out.println("Equals = "+ mySet.equals(mySet2));
    // }
}