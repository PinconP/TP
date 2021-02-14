package ensembles.ensemblesHeritage2020;
import java.util.Collections;

public class MySortedSet extends MySet{
    //constructeur
    public MySortedSet(){
        super();
    }//constructeur par copie
    public MySortedSet(MySortedSet mss) {
        super(mss);
    }
    public void add(double e){
        if (!this.data.contains(e)){//si la valeur n'est pas déjà dans le MySortedSet
            this.data.add(e);//on l'ajoute
            Collections.sort(this.data);//on trie à nouveau

        }
    }
    public double get(int i){
        assert(this.data.size()!=0&&i>=0&&i<this.data.size());{//on vérifie que l'indice demandé existe
            return this.data.get(i);//on renvoie la ième valeur
        }
    }
    public MySortedSet union(MySortedSet test){
        MySortedSet u = new MySortedSet();//on crée un MySortedSet union
        for (int i =0;i<this.data.size();i++){//on y ajoute toutes les valeurs du this
            u.add(this.data.get(i));
        }
        for (int i = 0; i<test.size();i++){//on y ajoute toutes les valeurs du paramètre
            u.add(test.get(i));
        }
        Collections.sort(u.data);//on trie le MySortedSet union
        return u;
    }
    public double nearest(double valeur){
    assert(this.data.size()!=0):"MySortedSet est vide";
    //Premier cas particulier: la valeur est contenue dans le MySortedSet
    if (this.data.contains(valeur)){
        return valeur;
        }
    //Deuxième cas particulier: la valeur est plus grande que toutes les valeurs du MySortedSet
    if(this.data.get(this.data.size()-1)<valeur){
        return this.data.get(this.data.size()-1);
        }
    //Troisième cas particulier: la valeur est plus petite que toutes les valeurs du MySortedSet
    if(valeur<this.data.get(0)){
        return this.data.get(0);
        }
    //méthode suivante faite avec Titouan car je n'ai pas réussi à le faire par dichotomie comme j'avais pensé le faire (le test ne passait pas)
    for (int i=1;i<this.data.size(); i++ ){//on parcourt le MySortedSet du début à la fin
        if ( this.data.get(i)<valeur && valeur<this.data.get(i+1)){//on le parcourt jusq'à trouver 2 valeurs qui encadre la valeur rentrée en paramètre
            if (Math.abs(valeur-this.data.get(i))<Math.abs(valeur-this.data.get(i+1))){//on regarde laquelle des deux valeurs encadrantes est la plus proche de la valeur paramètre
                return this.data.get(i);
            }else{
                return this.data.get(i+1);
                }
            }
        }return 0;
    }
    public MySortedSet intersection(MySortedSet test){
        //on crée un MySortedSet qui stocke uniquement les valeurs intersections
        MySortedSet i = new MySortedSet();
        //on fait une boucle qui regarde si chaque valeur du paramètre est contenue dans le MySortedSet de départ
        for (int j = 0;j<test.size();j++ ){
            if(this.data.contains(test.get(j))) {
                i.add(test.get(j)); //on ajoute chaque valeur contenue par les deux dans le MySortedSet intersection
            }
        }
        return i;
    }
    public MySortedSet difference(MySortedSet test){//même esprit qu'intersection mais on fait l'inverse
        MySortedSet d;
        d = this.union(test); // on crée un MySortedSet différence
        for (int i= 0; i<test.size();i++){
            if (this.data.contains(test.get(i))){
                d.remove(test.get(i));//on enlève toutes les occurences des valeurs présentes dans le test et le this
            }
        }
        return d;
    }
    public boolean subset(MySortedSet sub){
        if (sub.size()>this.size()){//on vérifie que le subset est de taille inférieure au MySortedSet
            return false;
        }
        boolean egal = true;//le booléen est vrai
        for(int i =0; i<sub.size();i++){//on parcourt le subset
            if(!this.contains(sub.get(i))){//si une valeur du subset n'est pas dans le this
                egal=false;//le booléen devient faux
            }
        }
        return egal;
    }


}
