#include <stdio.h>

void printArray(int* x, int N) {
    for (int i = 0; i < N; i++) {
        printf("%i ", x[i]);
    }
    printf("\n");
}

void printArray(float* x, int N) {
    for (int i = 0; i < N; i++) {
        printf("%.3g ", x[i]);
    }
    printf("\n");
}

int main(int argc, char** argv) {
    int N = 20;
    int* x = new int[N];
    for (int i = 0; i < N; i++) {
        x[i] = 2*(i+1);
    }
    printArray(x, N);
    float* y = new float[N-1];
    for (int i = 0; i < N; i++) {
        y[i] = 0.5*(x[i+1]+x[i]);
    }
    printArray(y, N-1);
    delete[] x;
    delete[] y;
    return 0;
}