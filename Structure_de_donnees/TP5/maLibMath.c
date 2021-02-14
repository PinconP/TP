#include <stdio.h>
#include <stdlib.h>
#include <math.h>
typedef struct{
    float ptX;
    float ptY;
    float ptZ;
} point;
typedef struct{
    float ptX;
    float ptY;
    float ptZ;
} vecteur;
typedef struct{
    float a;
    float b;
    float c;
    float d;
} equation;

point DemandePoint(){
    point p;
    float x = scanf("%f",&p.ptX);
    float y = scanf("%f",&p.ptY);
    float z = scanf("%f",&p.ptZ);
    return p;
}

point Creer_point(float x, float y, float z){
    point p;
    p.ptX= x;
    p.ptY= y;
    p.ptZ= z;
    return p;
}
vecteur vectorise(point ptdepart, point ptarrive){
    vecteur v;
    v.ptX= ptarrive.ptX - ptdepart.ptX;
    v.ptY= ptarrive.ptY - ptdepart.ptY;
    v.ptZ= ptarrive.ptZ - ptdepart.ptZ;
    return v;
}
vecteur produit_vectoriel(vecteur v1, vecteur v2){
    vecteur vproduit;
    vproduit.ptX=v1.ptY*v2.ptZ+v1.ptZ*v2.ptY;
    vproduit.ptY=v1.ptZ*v2.ptX+v1.ptX*v2.ptZ;
    vproduit.ptZ=v1.ptX*v2.ptY+v1.ptY*v2.ptX;
    return vproduit;
}
float produit_scalaire(vecteur v1, vecteur v2){
    float PS;
    PS=v1.ptX*v2.ptX+v1.ptY*v2.ptY+v1.ptZ*v2.ptZ;
    return PS;
}
float norme(vecteur v){
    float n;
    n = sqrt(((v.ptX)*(v.ptX))+((v.ptY)*(v.ptY))+((v.ptZ)*(v.ptZ)));
    return n;
}
equation equation_plan(point pt1, point pt2, point pt3){
    equation EP;
    vecteur v1=vectorise(pt1,pt2);
    vecteur v2=vectorise(pt1,pt3);
    vecteur n=produit_vectoriel(v1,v2);
    EP.a=n.ptX;
    EP.b=n.ptY;
    EP.c=n.ptZ;
    EP.d=-1*(pt3.ptX*EP.a+pt3.ptY*EP.b+pt3.ptZ*EP.c);
    return EP;
}
void affiche_equation(equation EP){
    printf"(%fx+%fy+%fz+%f",&EP.a &EP.b &EP.c, &EP.d );
}