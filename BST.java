/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bst;
public class BST {
    BSTNode root;

    // Insert a node into the BST
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private BSTNode insertRecursive(BSTNode node, int val) {
        if (node == null) {
            return new BSTNode(val); // Create a new node if the spot is empty
        }
        if (val < node.data) {
            node.left = insertRecursive(node.left, val); // Insert in left subtree
        } else if (val > node.data) {
            node.right = insertRecursive(node.right, val); // Insert in right subtree
        }
        return node; // Return the unchanged node pointer
    }

    // In-order Traversal (Left, Root, Right)
    public void inorder(BSTNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Search for a value in the BST
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(BSTNode node, int key) {
        if (node == null) {
            return false; // Value not found
        }
        if (node.data == key) {
            return true; // Value found
        }
        return key < node.data
                ? searchRecursive(node.left, key) // Search in left subtree
                : searchRecursive(node.right, key); // Search in right subtree
    }

    // Main method for testing
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // In-order Traversal
        System.out.println("In-order Traversal:");
        bst.inorder(bst.root);
        System.out.println();

        // Search for a value
        int key = 60;
        System.out.println("Is " + key + " present? " + bst.search(key));

        key = 90;
        System.out.println("Is " + key + " present? " + bst.search(key));
    }
}
