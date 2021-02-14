#ifndef __COMPLEXE_H__
#define __COMPLEXE_H__
typedef struct {
    float a;
    float b;
}Complexe_Cartesien;
typedef struct {
    float theta;
    float rho;
}Complexe_Polaire;
enum type {CARTESIEN=0,POLAIRE=1};
typedef struct{
    enum type t;
    union{
        Complexe_Cartesien cc;
        Complexe_Polaire cp;
    };
}Complexe;
//Prototypes
Complexe PoltoCart(Complexe c);
Complexe CarttoPol(Complexe c);
Complexe EntreCart();
void affiche(Complexe c);
Complexe Additionne(Complexe c1, Complexe c2);
#endif