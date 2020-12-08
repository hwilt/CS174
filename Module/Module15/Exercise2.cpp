#include <stdio.h>

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

void inorder(TreeNode* node) {
    if(node->left != NULL){
        inorder(node->left);
    }
    printf("%i ", node->value);
    if(node->right != NULL){
        inorder(node->right);
    }   
}

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
    inorder(T->root);
    printf(".\n");
    return 0;
}