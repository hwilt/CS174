#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

int main(int argc, char** argv) {
    LinkedList L;
    L.addFirst(3);
    L.addFirst(2);
    L.addLast(4);
    L.addLast(5);
    L.addFirst(1);
    L.addLast(6);
    L.addLast(7);
    L.printList();
    printf("\n");
    return 0;
}