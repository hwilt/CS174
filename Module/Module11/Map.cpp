#include <stdio.h>
#include <string>

using namespace std;

template <class K, class V> class Node {
    private:
        K key;
        V value;
        Node* next;
    public:
        Node(K key, V value) {
            this->key = key;
            this->value = value;
            next = nullptr;
        }
        void setNext(Node* next) {
            this->next = next;
        }
        Node* getNext() {
            return next;
        }
        void setKey(K key) {
            this->key = key;
        }
        K getKey() {
            return key;
        }
        void setValue(V value) {
            this->value = value;
        }
        V getValue() {
            return value;
        }
};

template <class K, class V> class LinkedMap {
    private:
        Node<K, V>* head;
        void removeFirst() {
            Node<K, V>* oldHead = head;
            head = head->getNext();
            delete oldHead;
        }

    public:
        LinkedMap() {
            head = nullptr;
        }
        ~LinkedMap() {
            // Delete all nodes that have been allocated
            while (head != nullptr) {
                removeFirst();
            }
        }

        /**
        * Put in a new <key, value> pair
        */
        void put(K key, V value) {
            // Add a new key/value pair at the beginning
            Node<K, V>* newNode = new Node<K, V>(key, value);
            if (head == nullptr) {
                head = newNode;
            }
            else {
                newNode->setNext(head);
                head = newNode;
            }
        }

        /* 
        * Find the value corresponding to a key
        */
        V get(K key) {
            V ret;
            Node<K, V>* node = head;
            while (node != nullptr && node->getKey() != key) {
                node = node->getNext();
            }
            if (node != nullptr) {
                ret = node->getValue();
            }
            else {
                printf("Warning: key not found\n");
            }
            return ret;
        }

        /**
          * Remove a key/value pair and return
          * the corresponding value
          */
        V remove(K key) {
            V ret;
            if (head != nullptr) {
                if (head->getKey() == key) {
                    ret = head->getValue();
                    removeFirst();
                }
                else {
                    Node<K, V>* last = head;
                    Node<K, V>* node = head->getNext();
                    while (node != nullptr && !(node->getKey() == key)) {
                        last = node;
                        node = node->getNext();
                    } 
                    if (node != nullptr) {
                        ret = node->getValue();
                        last->setNext(node->getNext());
                    }
                }
            }
            return ret;
        }

        /**
        * Return true if the map contains this key
        * or false otherwise
        */
        bool containsKey(K key) { //Module 11 Exercise 1
            bool contain = false;
            Node<K, V>* node = head;
            while (node != nullptr && node->getKey() != key) {
                node = node->getNext();
            }
            if (node != nullptr) {
                contain = true;
            }
            return contain;
        }


};

int main() {
    LinkedMap<string, int> L;
    L.put("james", 24);
    L.put("chris", 31);
    L.put("celia", 30);
    printf("\n");
    printf("%i", (int)L.containsKey("chris"));
    L.remove("chris");
    printf("%i", (int)L.containsKey("chris"));
    printf("%i", (int)L.containsKey("celia"));
    printf("%i", (int)L.containsKey("bear"));
    return 0;
}