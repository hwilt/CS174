#include <iostream>
#include <string>
using namespace std;

int factorial(int N){
    if(N == 1){
        return 1;
    }
    return N*factorial(N-1);
}

int main(int argc, char** argv){
    int N = stoi(argv[1]);
    cout << N << "! = " << factorial(N) << endl;
    return 0;
}