#include <stdio.h>

template <class K, class V> class Node {
  private:
      Node* next; // Arrow to next node
      K key;
      V value;
  
  public:
        Node(K value, V value) {
            // x->y
            // (*x).y
            this->value = value;
            next = nullptr;
        }
        void updateReference(Node* next) {
            this->next = next;
        }
        Node* getNext() {
            return this->next;
        }
        V getValue() {
            return this->value;
        }
        K getKey(){
            return this->key;
        }

        void setValue(V value) {
            this->value = value;
        }
};

template <class K, class V> class Map {
    private:
        Node<K, V>* head;
    public:
        Map() {
            head = nullptr;
        }

        ~Map() {
            while (head != nullptr) {
                //TODO: CLEAN UP MEMORY
                //removeFirst();
            }
        }

        bool isEmpty() {
            return head == nullptr;
        }

        void put(K key, V value) {
          Node<K, V>* newNode = new Node<K, V>(value);
          if (head == nullptr) {
              head = newNode;
          }
          else {
              newNode->updateReference(head);
              head = newNode;
          }
        }

        V get(K key){
            
            Node<K, V>* node = head;
            while(head != nullptr && node->getKey() != key){
                node = node->getNext();
            }
            if(node != nullptr){
                ret = node->getValue();
            }
            return ret;
        }
};

int main() {
    const char* chris = "chris";
    const char* joe = "joe";
    const char* celia = "celia";
    Map<const char*, int> M;
    M.put(chris, 31);
    M.put(joe, 78);
    M.put(celia, 31);
}