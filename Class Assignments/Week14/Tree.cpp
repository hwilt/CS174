#include <stdio.h>
#include "BMP.h"

#define NODE_WIDTH 40

class TreeNode {
    public:
        int value;
        int index; // Index in a tree order
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
        int N; // Number of nodes in the tree
        int depth; // Depth of the tree
    BinaryTree() {
        root = NULL;
        N = 0;
        depth = 0;
    }
    void deleteSubtree(TreeNode* node) {
        if (node->left != NULL) {
            deleteSubtree(node->left);
        }
        if (node->right != NULL) {
            deleteSubtree(node->right);
        }
        delete node;
    }
    ~BinaryTree() {
        if (root != NULL) {
            deleteSubtree(root);
        }
    }
    /**
     * Recursively compute the indices (order)
     * of each node and the depth of the tree
     * @param node Current node
     * @param depth Current depth
     */
    void reindex(TreeNode* node, int depth) {
        if (node->left != NULL) {
            reindex(node->left, depth+1);
        }
        node->index = N;
        N++;
        if (node->right != NULL) {
            reindex(node->right, depth+1);
        }
        if (depth > this->depth) {
            this->depth = depth;
        }
    }
    /** 
     * Compute the indices (order)  of each node and 
     * the depth of the tree
     */
    void reindex() {
        N = 0;
        if (root != NULL) {
            reindex(root, 1);
        }
    }
    /**
     * Recursively draw nodes as circles with links to their
     * children if they exist (this assumes reindex() has been
     * called first)
     * @param canvas BMP to which to draw the tree
     * @param node Current node that's being drawn
     * @param depth Current depth
     */
    void draw(BMP& canvas, TreeNode* node, int depth) {
        int x = NODE_WIDTH/2 + NODE_WIDTH*2*node->index;
        int y = canvas.bmp_info_header.height + NODE_WIDTH - depth*NODE_WIDTH*2;
        if (node->left != NULL) {
            int x2 = NODE_WIDTH/2 +NODE_WIDTH*2*node->left->index;
            int y2 = canvas.bmp_info_header.height + NODE_WIDTH  - (depth+1)*NODE_WIDTH*2;
            canvas.plotLine(x, y, x2, y2, NODE_WIDTH/10, 0, 0, 0);
            draw(canvas, node->left, depth+1);
        }
        if (node->right != NULL) {
            int x2 = NODE_WIDTH/2 + NODE_WIDTH*2*node->right->index;
            int y2 = canvas.bmp_info_header.height + NODE_WIDTH  - (depth+1)*NODE_WIDTH*2;
            canvas.plotLine(x, y, x2, y2, NODE_WIDTH/10, 0, 0, 0);
            draw(canvas, node->right, depth+1);
        }
        canvas.plotCircle(x, y, NODE_WIDTH/2, 0xFF, 0xFF, 0);
        std::stringstream ss;
        ss << node->value;
        canvas.drawString(ss.str(), x-NODE_WIDTH/2, y-NODE_WIDTH/3);
    }
    /**
     * Draw a tree with circles for nodes and lines segments between 
     * parent and children nodes
     * @param filename Path to which to save the drawing
     */
    void draw(const char* filename) {
        reindex();
        int width = 2*N*NODE_WIDTH;
        int height = depth*2*NODE_WIDTH;
        BMP canvas(width, height, 1);
        canvas.clearRect(0xFF, 0xFF, 0xFF, 0xFF);
        if (root != NULL) {
            draw(canvas, root, 1);
        }
        canvas.write(filename);
    }

    bool containsValue(TreeNode* node, int value){
        bool ret;
        if(value > node->value && node->right != NULL){
            ret = containsValue(node->right, value);
        }
        else if(value < node->value && node->left != NULL){
            ret = containsValue(node->left, value);
        }
        else if(value == node->value){
            ret = true;
        }
        return ret;
    }
    bool containsValue(int value) {
        bool ret;
        if(value > root->value && root->right != NULL){
            ret = containsValue(root->right, value);
        }
        else if(value < root->value && root->left != NULL){
            ret = containsValue(root->left, value);
        }
        else if(value == root->value){
            ret = true;
        }
        return ret;
    }

    void insertValue(TreeNode* node, int value){
        if(value > node->value && node->right != NULL){
            insertValue(node->right, value);
        }
        else if(value < node->value && node->left != NULL){
            insertValue(node->left, value);
        }
        //TODO: Fix this 
    }
    void insertValue(int value) {
        if(!containsValue(value)){
            if(value > root->value && root->right != NULL){
                insertValue(root->right, value);
            }
            else if(value < root->value && root->left != NULL){
                insertValue(root->left, value);
            }
        }
        //TODO: Fix this 
    }


    void removeValue(int value) {
        // TODO: Fill this in
    }
};

////////////////////////////////////////////////
//            An Example Tree                 //
////////////////////////////////////////////////
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



int main() {
    BinaryTree* T = makeExampleTree();
    printf("%i \n", T->containsValue(7));
    T->draw("tree.bmp");
    delete T;
    return 0;
}