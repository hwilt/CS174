#include "Hashable.h"
#include <iostream>

int main(){
    HashableString hello("Hello");
    HashableString cs("CS 174");
    HashableString computer("Computers rock");
    cout << hello.getHash() << endl;
    cout << cs.getHash() << endl;
    cout << computer.getHash() << endl;
    
    return 0;
}