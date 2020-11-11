#include <stdio.h>
#include <stdlib.h>

/**
 * 
 * Prints out all the even nubers from 0 to N, inclusive
 * @param N the upper limit to check
*/
void printEvens(int N){
    for(int i = 0; i <= N; i++){
        if(i % 2 == 0){
            printf("%i ", i);
        }
    }
}

void printDivisibleBy6(int N){
    for(int i = 6; i <= N; i++){
        if(i % 2 == 0 && i % 3 == 0){
            printf("%i ", i);
        }
    }
}


// public static void main(String[] args)
int main(int argc, char* argv[]){
    int N = atoi(argv[1]);
    printDivisibleBy6(N); 
    return 0; //Everything is OK!
}