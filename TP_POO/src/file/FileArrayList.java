package file;
import java.util.ArrayList;
public class FileArrayList implements IFile {
    protected ArrayList<Double>data = new ArrayList<>();
    @Override

    public boolean add(double e) {
        boolean j = true;
        for (int i = 0; i<this.data.size();i++){
            if (this.data.get(i)==e){
                j = false;
            }

        }
        if (j){
            this.data.add(e);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean remove() {
        assert (this.data.size()>0):"la file est vide";
        this.data.remove(0);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.data.size()==0;
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public double get() {
        assert (this.data.size()>0):"la file est vide";
        return this.data.get(0);
    }
    public String toString() {
        String message = "[";
        if (this.data.size()>0){
            message += this.data.get(0);
        }
        for (int i = 1; i <this.data.size(); i++){
            message+= ", " + this.data.get(i) ;
        }
        message+= "]";
        return message;
    }
    public boolean equals(Object test){
        if (!( test instanceof FileArrayList)){
            return false;
        }
        int egal = 0;
        FileArrayList testcopie = (FileArrayList) test;
        if (this.data.size()==testcopie.size()){
            for (int i =0; i<this.data.size();i++){
                if (this.data.get(i).equals(testcopie.data.get(i))) {
                    egal++;
                }
            }
        }
        if (egal>=this.data.size()) {
        return true;
        }else{
            return false;
        }
    }
}
