typedef struct {
    int stack [STACK_SIZE];
    int top;
} stack;

int top (stack *s){
    assert(!isEmpty(s));
    return (s->stack[s->top]);
}