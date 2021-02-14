typedef struct {
    int stack [STACK_SIZE];
    int top;
} stack;

void pop(stack *s){
    //vérfifier si la pil n'est pas vide
    assert(!isEmpty());
    s->top;
}