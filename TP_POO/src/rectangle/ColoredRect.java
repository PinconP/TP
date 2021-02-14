package rectangle;

import java.awt.*;

public class ColoredRect extends Rectangle implements Comparable<ColoredRect>{
    protected Color couleur;
    public ColoredRect(Point p1, Point p2, Color c) {
        super(p1, p2);
        this.couleur=c;
    }
    protected float aire(){
        return((this.basDroite.x-this.hautGauche.x)*(this.hautGauche.y-this.basDroite.y));
    }
    @Override
    public int compareTo(ColoredRect cr) {
        if (cr.aire()==this.aire()){
            return 0;
        }else if(cr.aire()>this.aire()){
            return 1;
        }else if(cr.aire()<this.aire()){
            return -1;
        }else return 2;

    }
}
