#include "hashtable.h"

using namespace std;
// TODO: Fill in your implementation of the Hash Table here


/*********************HashNode Class****************************/

/**
 * Create a node that hold copies of this key/value pair
 * @param key A key which is hashable (and by extension cloneable)
 * @param value The value, which is cloneable
 */
HashNode::HashNode(Hashable* key, Cloneable* value) {
    this->key = (Hashable*)key->clone();
    this->value = value->clone();
    next = NULL;
}

/**
 * Delete this node, also deleting copies of the key/value
 * that were made
 */
HashNode::~HashNode() {
    delete key;
    delete value;
}


/*********************HashTable Class****************************/

/**
 * A private helper method that removes the node
 * at the front of the map
 */
void HashTable::removeFirst(size_t i) {
    HashNode* entry = table[i];
    while (entry != NULL) {
        numOps++;
        HashNode* prev = entry;
        entry = entry->next;
        delete prev;
    }
    table[i] = NULL;
    delete entry;
}

/**
 * Constructor: Start off with an empty map where the head
 * is a null pointer
 */
HashTable::HashTable(size_t NBins) {
    this->NBins = NBins;
    table = new HashNode*[NBins];
    for(int i = 0; i < NBins; i++){
        table[i] = NULL;
    }
}

/**
 * Clear this linked list while properly de-allocating memory
 * by removing each node one at a time
 */
HashTable::~HashTable() {
    // Delete all nodes that have been allocated
    for(int i = 0; i < NBins; i++){
        removeFirst(i);
    }
    delete[] table;
}


/**
 * A simplified version of the put command where we add
 * a key/value pair to the map, without worrying about
 * duplicate keys
 * @param key A key which is hashable (and by extension cloneable)
 * @param value The value, which is cloneable
 */
void HashTable::put(Hashable* key, Cloneable* value) {
    int h = (key->getHash())%NBins;
    HashNode* newHashNode = new HashNode(key, value);
    if (table[h] == NULL) {
        table[h] = newHashNode;
    }
    else {
        newHashNode->next = table[h];
        table[h] = newHashNode;
    }
    numOps++;
}

/** 
* Find the value corresponding to a key
* @param key A key which is hashable (and by extension cloneable)
* @return The corresponding value, or nullpointer if key is not in the map
*/
Cloneable* HashTable::get(Hashable* key) {
    Cloneable* ret = NULL;
    int h = (key->getHash())%NBins;
    HashNode* node = table[h];
    while (node != NULL && !node->key->equals(key)) {
        numOps++;
        node = node->next;
    }
    if (node != NULL) {
        ret = node->value;
    }
    return ret;
}

/**
 * Remove a key/value pair and return
 * the corresponding value
 * @param key A key which is hashable (and by extension cloneable)
 * @return value A pointer to the associated copy of the value
 */
void HashTable::remove(Hashable* key) {
    int h = (key->getHash())%NBins;
    HashNode* node = table[h];
    if (node != NULL) {
        if (node->key->equals(key)) {
            numOps++;
            HashNode* prev = node;
            node = node->next;
            delete prev;
        }
        else {
            HashNode* last = node;
            HashNode* node1 = node->next;
            while (node1 != NULL && !node1->key->equals(key)) {
                last = node1;
                node1 = node1->next;
                numOps++;
            } 
            if (node1 != NULL) {
                last->next = node1->next;
                numOps++;
                delete node;
            }
        }
    }
}

/**
* Return true if the map contains this key
* or false otherwise
* @param key A key which is hashable (and by extension cloneable)
* @return true if key is in map, false otherwise
*/
bool HashTable::containsKey(Hashable* key) {
    int h = (key->getHash())%NBins;
    bool contains = false;
    HashNode* node = table[h];
    while (node != NULL && !node->key->equals(key)) {
        node = node->next;
        numOps++;
    }
    if (node != NULL) {
        contains = true;
    }
    return contains;
}

/**
 * Dynamically create an array to hold all of the keys in
 * this map in an arbitrary order.
 * @param N A pointer to the location that will hold the size
 *          of the array
 * @return A pointer to the pointers of the keys in the list
 */
Hashable** HashTable::getKeyList(size_t* N) {
    for(int j = 0; j < NBins; j++){
        HashNode* entry = table[j];
        HashNode* node = entry;
        *N = 0;
        while (node != NULL) {
            (*N)++;
            node = node->next;
        }
        node = entry;
    }
    Hashable** keyList = new Hashable*[*N];
    for(int j = 0; j < NBins; j++){
        HashNode* entry = table[j];
        HashNode* node = entry;
        size_t i = 0;
        while (node != NULL) {
            keyList[i] = node->key;
            i++;
            node = node->next;
        }
    }
    return keyList;
}