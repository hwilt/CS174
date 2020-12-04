#include <stdio.h>
#include <iostream>
using namespace std;
/**
 * A recursive implementation of binary search on a sorted array
 * @param x The array to sort
 * @param i1 First index of range to consider
 * @param i2 Last index of range to consider
 * @param value Value under search
 * @return Index of value in the array, or -1 if it isn't there
 */
int binarySearch(int* x, int i1, int i2, int value) {
    int index = -1;
    if (i1 == i2) {
        if (x[i1] == value) {
            index = i1;
        }
    }
    else {
        // Find the halfway point, the "pivot"
        int mid = (i1+i2)/2;
        // Is the halfway point < value I'm looking for?
        if (x[mid] < value) {
            index = binarySearch(x, mid+1, i2, value);
        }
        else {
            index = binarySearch(x, i1, mid, value);
        }
    }
    return index;
}

int main() {
    int x[17] = {0, 3, 8, 13, 14, 17, 19, 30, 32, 39, 41, 46, 53, 61, 70, 75, 82};
    for (int i = 0; i < 17; i++) {
      printf("%i\n", binarySearch(x, 0, 16, x[i]));
    }
    printf("\n");
    return 0;
} 