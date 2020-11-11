#include <stdio.h>

int main(){
    int arr[2][3] = {{1,2,3},{4,5,6}};

    int** arr2 = new int*[2];
    int x = 1;
    for(int i = 0; i < 2; i++){
        arr2[i] = new int[3];
        for(int j = 0; i < 3; j++){
            arr2[i][j] = x;
            x++;
        }
    }
    //arr2[1][2]
    *(*(arr2+1) + 2) =174;
    printf("%i\n", arr2[1][2]);

    //to de-allocate
    //de-allocate inner arrays
    for(int i = 0; i < 2; i++){
        delete arr2[i];
    }
    delete[] arr2;


    return 0;
}