#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* 
 * Dynamically allocate a new array which is the reverse
 * of a specified array
 * @param arr The array to reverse
 * @param N The size of the array
 * @return the reversed array
 */
int* reverseArray(int* arr, int N) {
    // TODO: Fill this in
    int* rev = new int[N]; // Dynamically allocate array to fill in
    for(int i = 0; i < N; i++){
        rev[i] = arr[N-1-i];
    }
    return rev;
}


void printArray(int* arr, int N) {
  for (int i = 0; i < N; i++) {
    printf("%i ", arr[i]);
  }
}


int main(){
    int N = 10;
    //int arr[] = {8,10,3,4}; like array in java
    int* arr = new int[N]; // like arrayList in java
    for(int i = 0; i < N; i++){
        arr[i] = pow(2, i);
        printf("%i ", arr[i]);
    }
    delete[] arr; //Clean it up!
    return 0; //Everything is A-Okay
}