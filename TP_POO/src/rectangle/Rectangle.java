package rectangle;

import java.awt.Point;
public class Rectangle extends Point {
    protected Point hautGauche;
    protected Point basDroite;
    public Rectangle(Point p1, Point p2){
        hautGauche = new Point(p1);
        basDroite =new Point(p2);
    }
    public void translate(int x, int y){
        this.hautGauche.x+=x;
        this.basDroite.x+=x;
        this.hautGauche.y+=y;
        this.basDroite.y+=y;
    }

    public Point getTopLeft() {
        return hautGauche;
    }

    public Point getBotRight() {
        return basDroite;
    }

    public boolean equals(Object test){
        if (test==null){
            return false;
        }
        if (!(test instanceof Rectangle)){
            return false;
        }
        Rectangle testCopie = (Rectangle) test;
        return this.basDroite.equals(testCopie.basDroite)&&this.hautGauche.equals(testCopie.hautGauche);
    }

}
