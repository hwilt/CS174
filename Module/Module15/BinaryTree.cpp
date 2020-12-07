#include <stdio.h>

class TreeNode{
    public:
        int value;
        TreeNode* left;
        TreeNode* right;
        //TreeNode* parent;
        TreeNode(int value){
            this->value = value;
            left = NULL;
            right = NULL;
        }
};

class BinaryTree{
    public:
        TreeNode* root;
        BinaryTree(){
            root = NULL;
        }
};

void makeExampleTree(){
    BinaryTree T;
    TreeNode ten(10);
    TreeNode seven(7);
    TreeNode three(3);
    TreeNode fifteen(15);
    TreeNode twelve(12);
    TreeNode twenty(20);
    T.root = &ten;
    ten.left = &seven;
    ten.right = &fifteen;
    seven.left = &three;
    fifteen.left = &twelve;
    fifteen.right = &twenty;

    printf("T.root->right->left->value = %i", T.root->right->left->value);
}

int main(){
    makeExampleTree();
    return 0;
}