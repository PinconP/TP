#ifndef __STACK_H__
#define __STACK_H__
//defintion opaque de la pile 
typedef struct s_stack* Stack;
//opérateurs constructeurs 
Stack stack();
Stack push(stack, int);
//opérateurs 
bool isEmpty(stack);
int top(stack);
Stack pop(stack);

#endif
