#include <stdlib.h>
#include <stdio.h>
#include "Geometrie.h"
#include <math.h>
Point2D creerPoint(float x, float y){
    Point2D pointcree;
    pointcree.px=x;
    pointcree.py=y;
    return pointcree;
}

Vecteur2D creerVecteur(Point2D a, Point2D b){
    Vecteur2D vecteurcree;
    vecteurcree.vx=b.px-a.px;
    vecteurcree.vy=b.py-a.py;
    return vecteurcree;
}

void affiche(Point2D p){
    printf("x=%.2f\n",p.px);
    printf("y=%.2f\n",p.py);
}

Circle creerCercle(Point2D point, Vecteur2D vecteur){
    Circle c;
    c.p=point;
    c.v=vecteur;
    return c;
}

float norme(Vecteur2D v){
    float n;
    n = sqrt(v.vx*v.vx+v.vy*v.vy);
    return n;
}

float aire(Circle c){
    float area;
    area=norme(c.v)*norme(c.v)*M_PI;
    return area;
}

int main (){
    float x;
    float y;
    float vx;
    float vy;
    Point2D centre=creerPoint(x,y);
    affiche(centre);
    Point2D point_du_cercle=creerPoint(vx,vy);
    affiche (point_du_cercle);
    Vecteur2D rayon = creerVecteur(centre,point_du_cercle);
    Circle cercle = creerCercle(centre, rayon);
    float area = aire(cercle);
    printf("%f\n",area);
}