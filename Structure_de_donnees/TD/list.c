#include <stdio.h>
#include <stdlib.h>
#include "list.h"

struct s_elem{
    int item;
    struct s_elem * next;
    struct s_elem * previous;
    };
    struct s_list{
        Elem head;
        Elem tail;
        int size;
    };
List push_front (List l, int e){
    //créer un élément
    Elem elem = (Elem) malloc (sizeof)
}