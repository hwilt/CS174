#include <stdio.h>
#include <iostream>
#include <string>

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

int getDepth(TreeNode* node, int depth){
    int left = depth;
    int right = depth;
    if(node->left != NULL){
        left = getDepth(node->left, depth+1);
    }
    if(node->right != NULL){
        right = getDepth(node->right, depth+1);
    }
    int ret = left;
    if(right > left){
        ret = right;
    }
    return ret;
}

int getDepth(BinaryTree* T){
    int depth = 0;
    if(T->root != NULL){
        depth = getDepth(T->root, 1);
    }
    return depth;
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

BinaryTree* makeExampleTree() {
    BinaryTree* T = new BinaryTree();
    T->root = new TreeNode(10);
    T->root->left = makeLeftSubtree();
    T->root->right = makeRightSubtree();
    return T;
}

void printNode(int node, int depth, int level){
    //printf("%i       ", node);
    string ret = "" + to_string(node);
    for(int i = level; i <= depth; i++){
        ret += "  ";
    }
    cout << ret;
}

void printLevel(TreeNode* node, int curr, int level, int depth) {
    // TODO: Modify this
    if (node != NULL) {
        printLevel(node->left, curr+1, level, depth);
        if(curr == level){
            printNode(node->value, depth, level);
        }
        printLevel(node->right, curr+1, level, depth);
    }
}

void printLevel(BinaryTree* T, int level) {
    printLevel(T->root, 1, level, getDepth(T));
}

void spacing(int level, int depth){
    string ret = "";
    for(int i = level; i <= depth; i++){
        ret += "    ";
    }
    cout << ret;
}

int main() {
    BinaryTree* T = makeExampleTree();
    int depth = getDepth(T);
    for(int i = 1; i <= depth; i++){
        spacing(i, depth);
        printLevel(T, i);
        printf("\n");
    }
    delete T;
    return 0;
}