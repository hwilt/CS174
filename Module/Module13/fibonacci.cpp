#include <stdio.h>
//exercise 1
int slowfib(int N) {
  if (N == 1 || N == 2) {
    return 1;
  }
  else {
    return slowfib(N - 1) + slowfib(N - 2);
  }
}

//exercise 2
int counts = 0;
int memory[11] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

int fib(int N) {
  counts++;
  int result = 1;
  if (memory[N] != -1) {
    // If we remembered fib(N) previously, then pull it out
    result = memory[N];
  }
  else if (N > 2) {
    result = fib(N-1) + fib(N-2);
    // TODO: Remember the result here for use next time
    // so we don't have to compute it again
    memory[N] = result;
  }
  return result;
}

int main() {
    for (int N = 1; N < 10; N++) {
      printf("%i ", fib(N));
    }
    printf("\n");
    printf("counts = %i.\n", counts);
    return 0;
}