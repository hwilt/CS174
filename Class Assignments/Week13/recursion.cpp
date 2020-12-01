#include <iostream>
#include <stdio.h>
using namespace std;

int g(int x){
    int result;
    if(x > 0){
        result = g(x-3) + 1; 
    }
    else{
        result = 3 * x;
    }
    return result;
}

int h(int x){
    int result;
    if(x > 5){
        result = h(x-7) + 1;
    }
    else if(x <= 5 && x >= 0){
        result = x;
    }
    else{
        result = h(x+3);
    }
    return result;
}

int f(int x, int y){
    int result;
    if(x > y){
        result = f(x-y,y-1) + 2;
    }
    else{
        result = x + y;
    }
    return result;
}

int A(int m, int n){
    if (m == 0){ 
        return n + 1; 
    } 
    else if(n == 0){ 
        return A(m - 1, 1); 
    } 
    else{ 
        return A(m - 1, A(m, n - 1)); 
    }
}


int main(){
    cout << "g(10) = " << g(10) << endl;
    cout << "h(13) = " << h(13) << endl;
    cout << "f(12,6) = " << f(12,6) << endl;
    cout << "A(2,3) = " << A(2,3) << endl;
    cout << "A(3,2) = " << A(3,2) << endl;
    cout << "A(3,3) = " << A(3,3) << endl;
    cout << "A(3,4) = " << A(3,4) << endl;
    //seg fault
    //cout << "A(4,3) = " << A(4,3) << endl;


    return 0;
}