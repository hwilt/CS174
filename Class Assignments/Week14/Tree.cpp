#include <stdio.h>
#include <iostream>

using namespace std;

class Line{
    private:
        string vis;
    public:
        Line(int treeSize, int lineNum){
            vis = "";
            for(int  i = lineNum; i < treeSize; i++){
                vis += "    ";
            }
        }
        void put(int value){
            vis += to_string(value);
            vis += "    ";
        }
        string getLine(){
            return vis;
        }
};


class TreeNode {
    public:
        int value;
        TreeNode* left;
        TreeNode* right;
        TreeNode(int value) {
            this->value = value;
            left = NULL;
            right = NULL;
        }
};

class BinaryTree {
    public:
        TreeNode* root;
    BinaryTree() {
        root = NULL;
    }
    ~BinaryTree() {
      cleanup(root);
    }
    void cleanup(TreeNode* N) {
      if (N != NULL) {
        cleanup(N->left);
        cleanup(N->right);
        delete N;
      }
    }
    void preorder(TreeNode* node) {
        if(node->left != NULL){
            preorder(node->left);
        }
        if(node->right != NULL){
            preorder(node->right);
        }
        printf("%i ", node->value);
    }

    void postorder(TreeNode* node) {
        if(node->left != NULL){
            postorder(node->left);
        }
        if(node->right != NULL){
            postorder(node->right);
        }
        printf("%i ", node->value);
    }

    void inorder(TreeNode* node) {
        if(node->left != NULL){
            inorder(node->left);
        }
        printf("%i ", node->value);
        if(node->right != NULL){
            inorder(node->right);
        }   
    }
};


void printTree(){
    Line l1(5,1);
    l1.put(10);
    Line l2(5,2);
    l2.put(7);
    l2.put(15);
    Line l3(5,3);
    l3.put(3);
    l3.put(9);
    l3.put(12);
    l3.put(20);
    Line l4(5,4);
    l4.put(8);
    l4.put(14);
    Line l5(5,5);
    l5.put(13);
    cout << l1.getLine() << endl;
    cout << l2.getLine() << endl;
    cout << l3.getLine() << endl;
    cout << l4.getLine() << endl;
    cout << l5.getLine();
}


TreeNode* makeLeftSubtree() {
  TreeNode* node = new TreeNode(7);
  node->left = new TreeNode(3);
  node->right = new TreeNode(9);
  node->right->left = new TreeNode(8);
  return node;
}

TreeNode* makeRightSubtree() {
  TreeNode* node = new TreeNode(15);
  node->left = new TreeNode(12);
  node->right = new TreeNode(20);
  node->left->right = new TreeNode(14);
  node->left->right->left = new TreeNode(13);
  return node;
}

BinaryTree* makeTree() {
  BinaryTree* T = new BinaryTree();
  T->root = new TreeNode(10);
  T->root->left = makeLeftSubtree();
  T->root->right = makeRightSubtree();
  return T;
}

int main() {
    BinaryTree* T = makeTree();
    T->postorder(T->root);
    printf(".\n");
    printTree();
    return 0;
}