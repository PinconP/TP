//†
#include "queue.h"
#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

//structure d'un élément de la file
typedef struct s_element {
    int value;
    struct s_element * next;**
} Element;
struct s_queue{
    Element *head;
    Element *tail;
    unsigned int size;
};
bool isEmpty(Queue q){
    return(q->size==0);
}
Queue push( Queue q , int e){
    //créer l'élément
    Element ele;
    ele.value=e;
    ele.next=NULL;
    //ajouter un élément à la file
    (q->tail)->next=&ele;
    //changer la queue
    q->tail=&ele;
    //modifier la taille
    q->size++;
    return q;
}
Queue pop(Queue q){
    //on crée un élément poubelle
    Element oldHead;
    //cet élément poublelle stocke l'adresse de le tête
    oldHead = q->head;
    //la tête pointe vers la nouvelle tête
    q->head=q->head->next;
    //on libère l'ancienne tête
    free(oldHead);
    //la taille diminue de 1
    q->size--;
}