#include <stdio.h>
#include <string>

class TreeNode {
    public:
        int value;
        int index;
        TreeNode* left;
        TreeNode* right;
        //TreeNode* parent;
        TreeNode(int value) {
            this->value = value;
            left = NULL;
            right = NULL;
        }
};

class BinaryTree {
    public:
        TreeNode* root;
        int N;
    BinaryTree() {
        root = NULL;
        N = 0;
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
    node->left->right->left->left = new TreeNode(13);
    return node;
}

BinaryTree* makeExampleTree() {
    BinaryTree* T = new BinaryTree();
    T->root = new TreeNode(10);
    T->root->left = makeLeftSubtree();
    T->root->right = makeRightSubtree();
    return T;
}

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

void printLevel(TreeNode* node, int curr, int level) {
    // TODO: Modify this
    if (node != NULL) {
        printLevel(node->left, curr+1, level);
        if(curr == level){
            printf("%i ", node->value);
        }
        printLevel(node->right, curr+1, level);
    }
}

void printLevel(BinaryTree* T, int level) {
    printLevel(T->root, 1, level);
}

void spacing(int level){
    string ret 
}

int main() {
    BinaryTree* T = makeExampleTree();
    int depth = getDepth(T);
    for(int i = 1; i <= depth; i++){
        printLevel(T, i);
        printf("\n");
    }
    delete T;
    return 0;
}
