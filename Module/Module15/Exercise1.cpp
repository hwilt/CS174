#include <stdio.h>
#include <iostream>
using namespace std;

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
};

BinaryTree* makeTree() {
  BinaryTree* T = new BinaryTree();
  T->root = new TreeNode(9);
  T->root->left = new TreeNode(4);
  // TODO: Finish this
  T->root->left->left = new TreeNode(1);
  T->root->left->right = new TreeNode(8);
  T->root->right = new TreeNode(20);
  T->root->right->right = new TreeNode(25);
  T->root->right->left = new TreeNode(15);
  return T;
}

void traverse(TreeNode* N) {
  if (N != NULL) {
    traverse(N->left);
    printf("%i ", N->value);
    traverse(N->right);
  }
}

int main() {
    BinaryTree* T = makeTree();
    traverse(T->root);
    printf(".\n");
    delete T;
    return 0;
}