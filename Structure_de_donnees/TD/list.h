#ifndef __LIST_H__
#define __LIST_H__
//PROTOTYPES DES FONCTIONS//
typedef struct s_element * Element;
typedef struct s_list * List;
List push_front(List,Element);//ajoute un élément en tête de liste
List push_back(List,Element);//ajoute un élément en fin de liste
List pop_front(List)//retire un élément en tête de liste 
List pop_back(List)//retire un élément en fin de liste 
List insert_at(List,int,Element)//ajoute un élément à une certaine position
List remove_at(//supprime un élément à une certaine position
Element front(List) //accède à la valeur en tête de liste 
Element back(List)//accède à la valeur en fin de liste
Element ith(List,int)//accède au ième élément
#endif