#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv [])
{
    int x0 =0;
    int x1 =0;
    int x2 =0;
    printf("l'adresse de x0 est %p \n",& x0);
    printf("l'adresse de x1 est %p \n",& x1);
    printf("l'adresse de x1 - celle de x0 = %1d\n",& x1-& x0);
    printf("l'adresse de x2 - celle de x1 = %1d\n",& x2 - & x1);
    printf("l'adresse de x2 - celle de x0 = %1d\n",& x2 - & x0);
    printf("*(& x0 - 2 ) vaut %d\n",* (& x0 - 2 ));
    printf("*(& x0 + 1 ) vaut %d\n",* (& x0 + 1 ));
    printf("*(& x0 + 2 ) vaut %d\n",* (& x0 + 2 ));
    printf("*(& x0 + 3 ) vaut %d\n",* (& x0 + 3 ));
    * (& x0 - 2 ) = 0;
    printf("*(& x0 - 2 ) vaut %d\n",* (& x0 - 2 ));
    * ( & x0 + 1) = 1;
    printf("*(& x0 + 1 ) vaut %d\n",* (& x0 + 1 ));
    * ( & x0 + 2) = 2;
    printf("*(& x0 + 2 ) vaut %d\n",* (& x0 + 2 ));
    * ( & x0 + 3) = 3;
    printf("*(& x0 + 3 ) vaut %d\n",* (& x0 + 3 ));
    printf("x0 = %d, x1 = %d, x2 = %d\n", x0,x1,x2);







    return 0;
}
//note personnelle faire attention aux espaces
