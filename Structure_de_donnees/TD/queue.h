#ifndef __QUEUE_H__
#define __QUEUE_H__
//définition opaque de la file
typedef struct s_queue* Queue;
typedef enum {false = 0, true =1} bool;
//opérateurs constructeurs
Queue queue();
Queue push(Queue, int);
//Opérateurs
Queue pop(Queue);
bool isEmpty(Queue);
int top(Queue);
#endif
