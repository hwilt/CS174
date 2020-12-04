#include <stdio.h>

/**
 * A method to recursively compute how many moves
 * there are in an optimal solution to the towers of
 * hanoi problem
 * @param N Number of discs
 * @return Number of optimal moves needed to move discs
 */
int h(int N) {
    if (N == 1) {
        return 1;
    }
    else{
        return h(N - 1)*2 + 1;
    }
}

int main() {
    for (int N = 1; N < 10; N++) {
        printf("%i ", h(N));
    }
    printf("\n");
    return 0;
}