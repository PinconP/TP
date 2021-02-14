#ifndef __GEOMETRIE_H__
#define __GEOMETRIE_H__

typedef struct{
    float px;
    float py;
}Point2D;

typedef struct{
    float vx;
    float vy;
}Vecteur2D;

typedef struct{
    Point2D p;
    Vecteur2D v;
}Circle;

//Prototypes
Point2D creerPoint(float x ,float y);
Vecteur2D creerVecteur(Point2D a, Point2D b);
void affiche(Point2D p);
Circle creerCercle(Point2D p, Vecteur2D v);
float aire(Circle c);
#endif