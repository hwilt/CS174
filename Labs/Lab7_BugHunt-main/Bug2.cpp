#include <stdio.h>

/**
 * Given an array of numbers, filter out numbers
 * which are a multiple of num
 * @param arr The array of numbers
 * @param N The length of the array
 * @param NOut Pointer to an address in memory holding the length
 *             of the filtered array
 * @param num Filter out multiples of this number
 */
int* filterMultiples(int* arr, int N, int* NOut, int num) {
    int numPrimes = 0;
    *NOut = 0;
    for (int i = 0; i < N; i++) {
        if (arr[i] >= num && arr[i]%num == 0) {
            (*NOut)++;
        }
    }
    int* multiples = new int[*NOut];
    int idx = 0;
    for (int i = 0; i <= N; i++) {
        if (arr[i] >= num && arr[i]%num == 0) {  
            multiples[idx] = arr[i];
            idx++;
        }
    }
    return multiples;
}

int main() {
    int arr[10] = {5, 6, 12, 20, 18, 24, 48, 58, 60, 68};
    // Multiples of 6
    int NOut;
    int* multiples = filterMultiples(arr, 10, &NOut, 6);
    for (int i = 0; i < NOut; i++) {
        printf("%i ", multiples[i]);
    }
    printf("\n");
    delete[] multiples;
    return 0;
}