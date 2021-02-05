package mySet;

import java.util.ArrayList;

public class MySet {
    protected ArrayList<Double>ald;

    public MySet() {
        this.ald=new ArrayList<Double>();

    }
    public MySet(MySet m) {
        this.ald = new ArrayList<Double>();
        for (int i = 0; i < m.ald.size(); i++) {
            this.ald.add(m.ald.get(i));
        }
    }
    public boolean add(double val) {
        if(this.contains(val)){
            return false;
    }
        return this.ald.add(val);}
    public int size() {
        return this.ald.size();
    }
    public boolean isEmpty() {
        return (this.ald.size()==0);
    }
    public boolean remove(double val){
        return (this.ald.remove(val));
    }
    public boolean contains(double val) {
        return (this.ald.contains(val));
    }
    public String toString() {

        return (this.ald.toString());
    }
    public void clear() {
        this.ald.clear();
    }
    public boolean equals(ArrayList<Double>ald2) {
        if (ald.equals(ald2)) {
            return true;
        }else{
            return false;
        }
    }
    public int getRandomInt(int max) {
        return (int)Math.floor(Math.random() * Math.floor((double)max));
    }

    public double random() {
        assert !this.isEmpty() : "pile vide";
        return this.ald.get(this.getRandomInt(this.ald.size()));
    }
    public boolean equals(MySet test) {
        if (test == null) {
            return false;
        }
        if (this.ald.size() != test.ald.size()) {
            return false;
        } else {
            int compteur = 0;
            for(int i = 0; i < this.ald.size(); ++i) {
                if (this.ald.contains(test.ald.get(i))) {
                    ++compteur;
                }
            }
            if (compteur >= this.ald.size()) {
                return true;
            } else {
                return false;
            }
        }
    }
                }


