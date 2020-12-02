#include <iostream>
#include <string>
#include <vector> //c++ version of an ArrayLsit

using namespace std; // Standard Template Library (STL)

/**
* Concatenate one vector onto the back of another one
* @param first vector, passed by reference
* @param second vector, passed by reference
*                       All elements of this vector should be added directly
*                       after the elements in v1
*/
void concatenate(vector<int>* v1, vector<int>* v2) {
  for (size_t i = 0; i < v2->size(); i++) {
      v1->push_back(v2->at(i));
  }
}



int main() {
    vector<int> v1;
    v1.push_back(1);
    v1.push_back(2);
    v1.push_back(3);
    vector<int> v2;
    v2.push_back(4);
    v2.push_back(5);
    v2.push_back(6);
    v2.push_back(7);
    concatenate(&v1, &v2);
    for (int i = 0; i < v1.size(); i++) {
      printf("%i ", v1.at(i));
    }
    printf(".\n");
    return 0;
}