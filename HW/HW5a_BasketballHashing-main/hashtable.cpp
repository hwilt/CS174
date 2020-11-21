#include "hashtable.h"

using namespace std;
// TODO: Fill in your implementation of the Hash Table here


/*********************HashNode Class****************************

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


/*********************HashTable Class****************************

/**
 * A private helper method that removes the node
 * at the front of the map
 */
void Hashtable::removeFirst(size_t i) {
    numOps++;
    LinkedNode* oldHead = head;
    head = head->next;
    delete oldHead;
}

/**
 * Constructor: Start off with an empty map where the head
 * is a null pointer
 */
HashTable::HashTable(size_t NBins) {
    this->NBins = NBins;
    for(int i = 0; i < NBins; i++){
        HashNode* hn = new HashNode(nullptr);
    }
}

/**
 * Clear this linked list while properly de-allocating memory
 * by removing each node one at a time
 */
HashTable::~HashTable() {
    // Delete all nodes that have been allocated
    while (head != NULL) {
        removeFirst();
    }
}
