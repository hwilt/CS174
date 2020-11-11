 #include <stdio.h>

/* 
 * Dynamically allocate a new array which is the reverse
 * of a specified array
 * @param arr The array to reverse
 * @param N The size of the array
 * @return the reversed array
 */
int* reverseArray(int* arr, int N) {
  int* rev = new int[N]; // Dynamically allocate array to fill in
  int j = 0; // Index in the original array
  for (int i = N-1; i >= 0; i--) {
      rev[i] = arr[j];
      j++;
      // Ex) N = 10,   i=0 -> 9, 1 -> 8, 2 -> 7
  }
  return rev;
}

void printArray(int* arr, int N) {
  for (int i = 0; i < N; i++) {
    printf("%i ", arr[i]);
  }
}
int main() {
    printf("\n");
    int arr1[] = {1, 7, 3, 3, 0, 1};
    int* rev = reverseArray(arr1, 6);
    printArray(rev, 6);
    delete[] rev;
    int arr2[] = {4, 7, 6, 1, 7, 4, 3, 7, 1};
    rev = reverseArray(arr2, 9);
    printf(".");
    printArray(rev, 9);
    printf("\n");
    delete[] rev;
    return 0;
}