/*
 * Return true if number is even, false otherwise
 * @param x int The number we're checking
 */
bool isEven(int x);

class Node {
  public:
      Node* next; // Arrow to next node
      int value;
      Node(int value);
};

class LinkedList {
    private:
        Node* head;
    public:
        LinkedList();
        ~LinkedList();
        bool isEmpty();
        void addLast(int value);
        void addFirst(int value);
        int removeFirst();
        void printList();
};