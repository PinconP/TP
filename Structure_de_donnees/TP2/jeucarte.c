#include <stdio.h>
#include <stdlib.h>
#include <time.h>
enum couleur {TREFLE,CARREAU,PIQUE,COEUR};
enum valeur {SEPT=7, HUIT=8, NEUF=9, DIX=10, VALET=11, DAME=12, ROI=13, AS=14};
typedef struct carte{
    enum couleur c;
    enum valeur v;
    } Carte;

void initjeu(Carte jeu[]) /* remplit le tableau avec les 32 cartes */
    {
        int indice = 0; //on  initialise l'indice de la carte à 0
        int couleur = 0 ; //on initialise la couleur à TREFLE
        for (couleur = 0; couleur <4; couleur ++){
            int valeur = 7; //on initialise la valeur à SEPT
            for (valeur = 7; valeur <15; valeur++){
                Carte carteinit;
                carteinit.c= couleur;
                carteinit.v= valeur;
                jeu [indice] = carteinit;
                indice ++;
            }
        }
    }
int alea32() /* genere un entier aleatoirecompris entre 0 et 31 */
    {
        int nombreMystere = 0;
        const int MAX = 31, MIN = 0;
        nombreMystere = (rand() % (MAX - MIN + 1)) + MIN;
        return(nombreMystere);
    }
void permute(Carte *carte1, Carte *carte2) /* permute 2 cartes */
    {
        Carte *jetable;
        jetable = carte1;
        carte1->v= carte2->v;
        carte1->c = carte2->c;
        carte2->v = jetable->v;
        carte2->c = jetable->c;

    }
void melange(Carte jeu[]) /* melange les cartes */
    {
        int i=0; //on initialise le nombre d'échanges aléatoires 
        for (i=0; i<100; i++){
            Carte *carte1= &jeu[alea32()];
            Carte *carte2= &jeu[alea32()];
            permute (carte1, carte2 );
            i++;
        }
    }
void affiche_carte(Carte X) /* affiche une carte (valeur,couleur)*/
    {
        char * c;
        char * v;
        switch(X.c)
        {
        case TREFLE:
            c = "TREFLE";
            break;
        case COEUR:
            c = "COEUR";
            break;
        case PIQUE:
            c = "PIQUE";
            break;
        case CARREAU:
            c = "CARREAU";
            break;
        default : 
            printf("ERREUR 404 COULEUR NOT FOUND");
            break;
        }
        switch(X.v)
        {
            case SEPT:
                v = "7";
                break;
            case HUIT:
                v="8";
                break;
            case NEUF:
                v="9";
                break;
            case DIX:
                v="10";
                break;
            case VALET:
                v="VALET";
                break;
            case DAME:
                v="DAME";
                break;
            case ROI:
                v="ROI";
                break;
            case AS:
                v="AS";
                break;
            default:
                printf("WARNING: carte non referencee");
                break;
        }
        printf("%s de %s",v,c);
    }
void affiche(Carte jeu[],int N) /* affiche N cartes */
    {
    for (int i = 0; i < N; i++)
    {
        affiche_carte(jeu[i]);
    }
    }
void  distribue(Carte  jeu[],  Carte  jeu1[],  Carte  jeu2[])/*  distribue  les cartes aux deux joueurs */
    {
        int i = 0;
        for (i=0; i<31; i+=2)
        {
            jeu1[i]=jeu[i];
            jeu2[i+1]=jeu[i+1];
        }
    }
void  joue1coup(  Carte  jeu1[],  Carte  jeu2[],  int*N1,  int*N2)/*  gere  le resultat d’une bataille (1 coup) */
{
    if (jeu1[0].v>jeu2[0].v){
        printf("Le joueur 1 gagne la manche à la valeur\n");
        //ajout carte du J2 au fond du paquet du J1
        jeu1[*N1]=jeu1[0];
        jeu1[*N1+1]=jeu2[0];
        //maj nb cartes
        *N1=*N1+1;
        *N2=*N2-1;
        }else if(jeu1[0].v<jeu2[0].v){
            printf("Le joueur 2 gagne la manche à la valeur\n");
            //ajout carte du J1 au fond du paquet du J2
            jeu2[*N2]=jeu2[0];
            jeu2[*N2+1]=jeu1[0];
            //maj nb cartes
            *N1=*N1-1;
            *N2=*N2+1;
        }else if(jeu1[0].c>jeu2[0].c){
            printf("Le joueur 1 gagne la manche à la couleur\n");
            //ajout carte J2 au fond du paquet de J1
            jeu1[*N1]=jeu1[0];
            jeu1[*N1+1]=jeu2[0];
            //maj nb cartes
            *N1=*N1+1;
            *N2=*N2-1;
            }else{
                printf("Le joueur 2 gagne la macnche à la couleur\n");
                //ajout carte J1 au fond du paquet de J2
                jeu2[*N2]=jeu2[0];
                jeu2[*N2+1]=jeu1[0];
                //maj nb cartes
                *N1=*N1-1;
                *N2=*N2+1;
            }
    //on remet les indices à 0
    int i;
	for (i=0;i<*N1-1;i++)
		jeu1[i] = jeu1[i+1];
	for (i=0;i<*N2-1;i++)
		jeu2[i] = jeu2[i+1]; 

}
int main(){
    srand(time(NULL));
    Carte jeu[32];
    Carte jeu1[32]; /* cartes du joueur 1 */
    Carte jeu2[32];
    int N1=15; /* indice de la derniere carte joueur 1 */
    int N2=15;
    initjeu(jeu);
    srand(12500); /* initialisation du générateur aléatoire */
    melange(jeu);
    distribue(jeu,jeu1,jeu2);
    int NBtours =0;
    while ((N1>0)&&(N2>0)) { /* tant que la partie n’est pas terminee */
    joue1coup(jeu1,jeu2,&N1,&N2);
    NBtours ++;
    printf("Le joueur 1 a %d cartes et le joueur 2 a %d cartes\n",N1,N2);
    }
    if (N1==0){
        printf("Le joueur 2 gagne");
    }else{
        printf("Le joueur 1 gagne");
    }
    printf(" en %d coups", NBtours);
    /* afficher qui gagne et en combien de coups */
    return 0;}