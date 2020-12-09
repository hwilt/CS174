#include <stdio.h>
#include <string>
#include <iostream>
#include <fstream>
#include "hashable.h"
#include "cloneable.h"
#include "hashtable.h"
#include "linkedmap.h"
#include "player.h"


void compareMaps() {
    // TODO: Fill this in
    // 1. Create a map m1 of type LinkedMap and a map m2 of type HashMap
    // and fill them with the players.
    // 2. Reset the operation counts of each map
    // 3. Loop through all of the keys in m1 and make sure they're in m2
    //    by calling the containsKey() method.  If they're not, print out
    //    the ones that are missing to help you debug
    // 4. Loop through all of the keys in m2 and make sure they're in m1
    //    by calling the containsKey() method.  If they're not, print out
    //    the ones that are missing to help you debug
    // 5. Report the number of operations in steps 3 and 4, and the average
    //    number of operations per player
    //Step 1
    Map* m1 = new LinkedMap();
    Map* m2 = new HashTable(100);
    loadPlayers(m1);
    loadPlayers(m2);
    //Step 2
    m1->resetOps();
    m2->resetOps();
    //Step 3
    size_t N;
    Hashable** LinkedKeyList = m1->getKeyList(&N);
    for(int i = 0; i < N; i++){
        Hashable* linkedKey = LinkedKeyList[i];
        if(linkedKey != NULL && !m2->containsKey(linkedKey)){
            cout << linkedKey << ": Does not Exist" << endl;
        }
    }
    //Step 4
    Hashable** HashKeyList = m2->getKeyList(&N);
    for(int i = 0; i < N; i++){
        Hashable* hashKey = HashKeyList[i];
        if(hashKey != NULL && !m1->containsKey(hashKey)){
            cout << hashKey << ": Does not Exist" << endl;
        }
    }
    //Step 5
    printf("%zu number of Players\n", N);
    printf("Number of Operations in hash table: %zu\nAverage %zu per player\n", m2->numOps, m2->numOps/N);
    printf("Number of Operations in linked map: %zu\nAverage %zu per player", m1->numOps, m1->numOps/N);
    delete m1;
    delete m2;
}

int main() {
    compareMaps();
    return 0;
}
