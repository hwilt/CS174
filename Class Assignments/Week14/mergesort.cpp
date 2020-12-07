#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/**
 * Make a pseudo-array of integers of a particular length
 * given a particular seed to make sure it is repeatable
 * @param seed Seed for choosing the sequence
 * @param N Number of elements in the array
 */
int* makeRandomArray(int seed, int N) {
    int* x = new int[N];
    srand(N);
    for (int i = 0; i < N; i++) {
        x[i] = rand() % N;
    }
    return x;
}

/**
 * Do an in-place swap of two elements in an array using XOR
 * @param x The array
 * @param i1 First index
 * @param i2 Second index
 */
void swap(int* x, int i1, int i2) {
    x[i1] ^= x[i2];
    x[i2] ^= x[i1];
    x[i1] ^= x[i2];
}

/**
 * Print out the elements of an array in a particular range
 * (useful for debugging)
 * @param x The array
 * @param i1 First index to print, inclusive
 * @param i2 Last index to print, inclusive
 */
void printArray(int* x, int i1, int i2) {
    for (int i = i1; i <= i2; i++) {
        printf("%i ", x[i]);
    }
    printf("\n");
}

/**
 * Perform a merge of two contiguous sorted sub-chunks of
 * the array x, using y as a staging area
 * @param x The main array
 * @param y The array to copy into as the two chunks are being merged
 * @param i1 Left of first chunk
 * @param mid Right of first chunk
 * @param i2 End of second chunk
 */
void merge(int* x, int* y, int i1, int mid, int i2) {
    int i = i1;
    int j = mid+1;
    int k = 0;
    
    while(i <= mid && j <= i2) {
		if(x[i] <= x[j]) {
			y[k] = x[i];
			k++; 
            i++;
		}
		else {
			y[k] = x[j];
			k++; 
            j++;
		}
	}

    while(i <= mid) {
		y[k] = x[i];
		k++; 
        i++;
	}
    
    while(j <= i2) {
		y[k] = x[j];
		k++; 
        j++;
	}
    
    for(i = i1; i <= i2; i += 1) {
		x[i] = y[i - i1];
	}
}

/**
 * An entry point for merge sort on the entire array
 * @param x Array to sort
 * @param y A temporary array to store intermediate results
 * @param N Length of x and y
 * @param i1 First index of chunk to sort, inclusive
 * @param i2 Second index of chunk to sort, inclusive (i2 >= i1)
 */
void mergeSort(int* x, int* y, int N, int i1, int i2) {
    if (i1 == i2) {
        // Base case: A single number
        return;
    }
    else if (i2 - i1 == 1) {
        // Base case: A pair of numbers right next to each other
        if (x[i2] < x[i1]) {
            swap(x, i1, i2);
        }
    }
    else {
        // More than two; need to "divide and conquer"
        int mid = (i1 + i2)/2;
        mergeSort(x, y, N, i1, mid);
        mergeSort(x, y, N, mid+1, i2);
        merge(x, y, i1, mid, i2);
    }
}

/**
 * An entry point for merge sort on the entire array
 * @param x Array to sort
 * @param N Length of the array
 */
void mergeSort(int* x, int N) {
    int* y = new int[N];
    mergeSort(x, y, N, 0, N-1);
    delete[] y;
}

int main () {
    int N = 100;
    int* x = makeRandomArray(1, N);
    // Print the array before it's sorted
    printArray(x, 0, N-1);
    // Perform the sort
    mergeSort(x, N);
    // Print the array after it's sorted
    printf("\n\n");
    printArray(x, 0, N-1);
    // Clean up memory
    delete[] x;
    return 0;
}