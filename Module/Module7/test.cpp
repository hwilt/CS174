#include <stdio.h>

void passMeIt(int x[]){
    printf("passMeIt address: %p\n", &x[2]);
}

void modify(int x){
    x = 20;
}

void modifyRef(int* xptr, int* yptr){
    *yptr = 40;
    *xptr = 20; // Go to that address (*x) and change it to 20
}


int main(){
    //int x = 10;
    //printf("%i", sizeof(&x));
    /*
    for(int i = 0; i < 4; i++){
        printf("%p, ", &arr[i]);
    }
    */
    //int arr[4] = {5, 2, 8, 3};
    int x = 10;
    int y =0;
    int* xptr = &x;
    modifyRef(&x, &y);
    printf("%i, %i\n", x,y);

    return 0;
}