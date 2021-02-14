#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "Complexe.h"

Complexe PoltoCart(Complexe c){
    if(c.t==POLAIRE){
        Complexe cc1;
        cc1.t=CARTESIEN;
        cc1.cc.a=c.cp.rho*cos(c.cp.theta);
        cc1.cc.b=c.cp.rho*sin(c.cp.theta);
        return cc1;
    }else return c;
}
Complexe CarttoPol(Complexe c){
    if(c.t==CARTESIEN){
        Complexe cp1;
        cp1.t=POLAIRE;
        cp1.cp.rho=sqrt(c.cc.a*c.cc.a+c.cc.b*c.cc.b);
        cp1.cp.theta=atan(c.cc.b/c.cc.a);
        return cp1;
    }else return c;
}
Complexe EntreCart(){
    Complexe c;
    c.t=CARTESIEN;
    printf("Complexe de la forme a+ib\n");
    printf("Tapez a\n");
    scanf("%f",&c.cc.a);
    printf("Tapez b\n");
    scanf("%f",&c.cc.b);
    return c;
}
void affiche(Complexe c){
    if(c.t==CARTESIEN){
        printf("a = %f et b = %f\n",c.cc.a,c.cc.b);
    }else if(c.t==POLAIRE){
        printf("theta = %f et rho = %f\n",c.cp.theta,c.cp.rho);
    }
}
Complexe Additionne(Complexe c1,Complexe c2){
    Complexe c1copie=PoltoCart(c1);
    Complexe c2copie=PoltoCart(c2);
    Complexe cAdd;
    cAdd.t=CARTESIEN;
    cAdd.cc.a=c1copie.cc.a+c2copie.cc.a;
    cAdd.cc.b=c1copie.cc.b+c2copie.cc.b;
    return cAdd;
}
int main(){
    Complexe c1=EntreCart();
    Complexe c2=EntreCart();
    Complexe c1copie=CarttoPol(c1);
    Complexe c3=Additionne(c1copie,c2);
    affiche(c3);
}