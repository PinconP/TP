package fileCirculaire;

import file.FileArrayList;

import java.io.File;

public class FileCirculaire implements IFileBornee {
    //Constructeurs
    protected int tail;
    protected int head;
    protected int taille;
    protected double queue[];
    public FileCirculaire(int tailleMax){
        this.tail =0;
        this.head =0;
        this.taille = 0;
        this.queue=new double[tailleMax];
    }
    @Override
    public boolean add(double e) {
        if (this.capacity()>this.taille){
            this.queue[this.tail]=e;
            this.tail= (this.tail+1)%this.capacity();
            this.taille++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean remove() {
        if (this.taille>0){
            this.head=(this.head+1)%this.capacity();
            this.taille--;
            return true;

        }else{
                return false;
            }
    }

    @Override
    public boolean isEmpty() {
        return (this.taille==0);
    }

    @Override
    public int size() {
        return this.taille;
    }

    @Override
    public double get() {
        assert(this.taille!=0):"pile vide";
        return this.queue[this.head];
    }

    @Override
    public boolean isFull() {
        return (this.taille==this.capacity());
    }

    @Override
    public int capacity() {
        return this.queue.length;
    }
    public String toString(){
        String message = "[";
        if (this.taille>0){
            message += this.queue[this.head];
        }
        for (int i = 1; i <this.taille; i++){
            message+= ", " + this.queue[i] ;
        }
        message+= "]";
        return message;
    }
    public boolean equals(Object test){
        if (test==null){
            return false;
        }
        if (!( test instanceof FileCirculaire)){
            return false;
        }
        int egal=0;
        FileCirculaire testcopie = (FileCirculaire) test;
        if(this.taille==testcopie.taille) {
            for (int i = 0; i < this.taille; i++) {
                if (this.queue[(this.head + i) % this.capacity()] == testcopie.queue[this.head + i] % this.capacity()) {//si c'est général on ne peut pas utiliser ==, on doit utiliser equals
                    egal++;
                }
            }
        }
        if (egal>=this.taille){
            return true;
        }else{
            return false;
        }
    }
}
