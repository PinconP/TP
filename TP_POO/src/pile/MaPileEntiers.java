package pile;

public class MaPileEntiers implements IPileEntiers{
    private int[] maPile;//les attributs
    private int taille; //la taille est initialisée par défaut à zéro

    public MaPileEntiers (int tailleMax) {//constructeurs
        this.maPile = new int[tailleMax];

    }
    public int get() {
        assert (taille>0) : "Valeur négative get() impossible"; {
            return this.maPile[taille -1];
        }
    }
    public boolean add(int val) {
        if (taille<this.maPile.length) {
            this.maPile[taille]=val;
            this.taille++;
            return true;
        }else {
            return false;
        }
    }

    public boolean remove() {
        if (taille > 0) {
            this.taille --;
            return true;
        }else {
            return false;
        }
    }
    public String toString() {
        String message = "[";
        if (this.taille>0){
            message += this.maPile[0];
        }
        for (int i = 1; i <this.taille; i++){
            message+= ", " + this.maPile[i] ;
        }
        message+= "]";
        return message;
    }
    public int size() {
        int size = this.taille;
        return size;
    }

    public int capacity() {
        int tailleMax = this.maPile.length;
        return tailleMax;
    }

    public boolean isFull() {
        return (taille!=0);
    }

    public boolean isEmpty() {
        return (taille ==0);
    }
    public boolean equals(MaPileEntiers test) {
        if (test != (MaPileEntiers) test) {
            return false;
        } else if (this.taille != test.taille) {
            return false;
        } else {
            int compteur = 0;

            for(int i = 0; i < this.taille; ++i) {
                if (this.maPile[i] == test.maPile[i]) {
                    ++compteur;
                }
            }
            if (compteur >= this.taille) {
                return true;
            } else {
                return false;
            }
        }
    }

}

















