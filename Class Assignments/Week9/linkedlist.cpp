#include <stdio.h>

template <class Item> class Node {
  private:
      Node* next; // Arrow to next node
      Item value;
  
  public:
      Node(Item value) {
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
      Item getValue() {
          return this->value;
      }
      void setValue(Item value) {
          this->value = value;
      }
};

template <class Item> class LinkedList {
    private:
        Node<Item>* head;
    public:
        LinkedList() {
            head = nullptr;
        }

        ~LinkedList() {
            while (head != nullptr) {
                removeFirst();
            }
        }

        bool isEmpty() {
            return head == nullptr;
        }

        void addLast(Item value) {
            Node<Item>* newNode = new Node<Item>(value);
            if (head == nullptr){
                head = newNode;
            }
            else {
                Node<Item>* node = head;
                // Go until I find the end of the list
                // where the arrow points to nothing
                while (node->getNext() != nullptr) {
                    node = node->getNext();
                }
                node->updateReference(newNode);
            }
        }

        void addFirst(Item value) {
          Node<Item>* newNode = new Node<Item>(value);
          if (head == nullptr) {
              head = newNode;
          }
          else {
              newNode->updateReference(head);
              head = newNode;
          }
        }

        Item removeFirst() {
            Item ret;
            if (head != nullptr) {
                ret = head->getValue();
                Node<Item>* newHead = head->getNext();
                delete head;
                head = newHead;
            }
            return ret;
        }

        void printList() {
          Node<Item>* node = head;
          while (node != nullptr) {
            printf("%g", node->getValue());
            if (node->getNext() != nullptr) {
              printf(", ");
            }
            node = node->getNext();
          }
        }
};

int main() {
    LinkedList<float> L;
    L.addFirst(3);
    L.addFirst(2);
    L.addLast(4);
    L.addLast(5);
    L.addFirst(1);
    L.addLast(6);
    printf("\n");
    L.printList();
    printf("\n");
}