#include <stdio.h>
#include <stdlib.h>

int* first10ByK(int K) {
    int* x = new int[10];
    int j = 0;
    for (int i = 1; i <= 10; i++) {
        x[j] = K*i;
        j++;
    }
    return x;
}

int main(int argc, char** argv) {
    int K = atoi(argv[1]);
    int* x = first10ByK(K);
    for (int i = 0; i < 10; i++) {
        printf("%i ", x[i]);
    }
    printf("\n");
    delete[] x;
    return 0;
}