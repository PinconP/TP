#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define FERME 0
#define OUVERT 1
#define LIGNES 10
#define COLONNES 10

int affichelaby(int laby[LIGNES][COLONNES])
{
    int i;
    for (i=0; i<LIGNES; i++)
    {
        int j;
        for (j=0; j<COLONNES; j++)
        {
            if (laby[i][j]==0)
            {
                printf("X");
            }
            if (laby[i][j]==1)
            {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}
/*
int creerlaby(int laby[LIGNES][COLONNES])
{
    int franchissable = 1;
    for (int i = 0; i < COLONNES; i++){
        for ( int j =0; j<LIGNES; j++){
            if ((i!=0) || (i!=COLONNES) || (j!=0) || (j!=LIGNES) || (laby[j][i]==laby[0][COLONNES - 1]) || (laby[j][i]==laby[LIGNES][COLONNES - 1])){
                franchissable = 1;
            }else{
                franchissable= 0;
            }
        }
    }
}
*/
void creerlaby(int laby[LIGNES][COLONNES]){
    for (int i = 0; i < COLONNES; i++){
        laby[0][i] = 0;
        laby[LIGNES-1][i] = 0;
    }
    for (int i = 0; i<LIGNES; i++){
        laby[i][0] = 0;
        laby[i][COLONNES-1]=0;
    }
    laby[0][COLONNES - 1 ] = 1;
    laby[LIGNES][COLONNES + 1] = 1 ;
    for (int i = 1; i<COLONNES-1; i++){
        for ( int j = 1; j <LIGNES-1;j++){
            if (rand()%100<60){
                laby[j][i]=0;
            }else{
                laby[j][i]=1;
            }
        }
    }
}
int main(int argc, char * argv[]){
    srand( time( NULL));
    int laby[LIGNES][COLONNES];
    char reponse ='n';
    while (reponse!='Y'){
        creerlaby(laby);
        affichelaby(laby);
        printf("[Y/n]");
        scanf("%c", &reponse);
        printf("\n \n ************************************ \n \n");
    }
}