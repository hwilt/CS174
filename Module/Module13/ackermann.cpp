#include <iostream>
#include <string>
using namespace std;

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

int main(int arg, char** argv){
    int m = stoi(argv[1]);
    int n = stoi(argv[2]);
    cout << "A(" << m << ", " << n << ") = " << A(m,n) << endl;
    return 0;
}