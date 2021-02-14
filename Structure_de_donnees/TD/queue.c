#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "queue.h";
#define QUEUE_MAX_SIZE
struct s_queue {
    int head;
    int tail;
    unsigned int size;
    }
Queue queue(){
    Queue q = (Queue)malloc(sizeof(struct s_queue));
    q->size=0;
    q->head=0;
    q->tail=0;
    return(q);
}
Queue push(Queue q, int e){
    assert(q->size<QUEUE_MAX_SIZE);
    q->queue[q->tail]=e;
    q->size++;
    q->tail++;
    q->tail = q->tail % QUEUE_MAX_SIZE;
    return q;
}
Queue pop(Queue q){
    assert(q->size >0);
    q->head=(q->head+1)%QUEUE_MAX_SIZE;
    q->size--;
    return q;
}
bool isEmpty(Queue q){
    return(q->size==0);
}
int top(Queue q){
    assert (q->size>0);
    return(q->queue[q->head]);
}