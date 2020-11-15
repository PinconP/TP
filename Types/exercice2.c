#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv [])
{
    int x[3] ;
    printf("l'adresse de x[0] est %p \n",& x[0]);
    printf("l'adresse de x[1] est %p \n",& x[1]);
    printf("l'adresse de x[2] est %p \n",& x[2]);
    printf("la valeur de x est %p.\n", x);
    printf("l'adresse de x est %p.\n", & x);
    printf("l'adresse de x[1] - celle de x[0] = %1d\n",& x[1]-& x[0]);
    printf("l'adresse de x[2] - celle de x[1] = %1d\n",& x[2] - & x[1]);
    printf("l'adresse de x[2] - celle de x[0] = %1d\n",& x[2] - & x[0]);
    printf("*(& x0 - 2 ) vaut %d\n",* (& x0 - 2 ));
    printf("*(& x0 + 1 ) vaut %d\n",* (& x0 + 1 ));
    printf("*(& x0 + 2 ) vaut %d\n",* (& x0 + 2 ));
    printf("*(& x0 + 3 ) vaut %d\n",* (& x0 + 3 ));
    * (& x[0] - 2 ) = 0;
    * ( & x[0] + 1) = 1;

    * ( & x[0] + 2) = 2;

    * ( & x[0] + 3) = 3;
    printf("x[0] = %d, x[1] = %d, x[2] = %d\n", x[0],x[1],x[2]);
    printf ("sizeof ( x ) = %1d \n" , sizeof ( x ) ) ;
    printf("sizeof ( & x ) = , sizeof ( & x ) ");
    return 0;





    return 0;
}
