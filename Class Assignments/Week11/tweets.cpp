#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ifstream file("tweets.txt");
    if (file.is_open()) {
        int i = 0;
        string line;
        while(getline(file, line)) {
            if((i+3)%5 == 0){
                cout << line << "\n";
            }
            i++;
        }
    }


    return 0;
}