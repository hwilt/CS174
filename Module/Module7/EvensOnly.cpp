#include <stdio.h>

int* filter(int* x, size_t N, size_t* finalLength) {
  // Step 1: Count how many elements are even
  size_t NOut = 0;
  for (size_t i = 0; i < N; i++) {
    if (x[i] % 2 == 0) {
      NOut++;
    }
  }
  // Step 2: Allocate new array and fill in even elements
  int* xout = new int[NOut];
  int idx = 0;
  for (size_t i = 0; i < N; i++) {
    if (x[i] % 2 == 0) {
      xout[idx] = x[i];
      idx++;
    }
  }
  *finalLength = NOut;
  return xout;
}

void printArray(int* arr, int N) {
  for (int i = 0; i < N; i++) {
    printf("%i ", arr[i]);
  }
}

int main() {
    printf("\n|");
    int x1[] = {1, 9, 4, 5, 2, 3, 1, 8, 2, 13};
    size_t NOut = 0;
    int* xout = filter(x1, 10, &NOut);
    printArray(xout, NOut);
    delete[] xout;
    int x2[] = {1, 2, 3, 4, 5, 6, 7, 8};
    xout = filter(x2, 8, &NOut);
    printf(".");
    printArray(xout, NOut);
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        