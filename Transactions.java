package com.datastructure.gl;

/* Question 2.
You are working in an MNC, which manages the Transactions, where only BST is used as a Data Structure. 
The company stores all the data of transactions in BST such that the tree is always a complete BST.
A new business requirement has arrived where the BST should not contain any left node.
You are required to modify the existing BST and display the node values present in ascending order.
 */


import java.io.*;
class Node
{
    int val;
    Node left, right;


    Node(int item)
    {
        val = item;
        left = right = null;
    }
}
class Skewed
{
    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;


    static void flattenBTToSkewed(Node root, int order)
    {

        if(root == null)
        {
            return;
        }


        if(order > 0)
        {
            flattenBTToSkewed(root.right, order);
        }
        else
        {
            flattenBTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;


        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }


        if (order > 0)
        {
            flattenBTToSkewed(leftNode, order);
        }
        else
        {
            flattenBTToSkewed(rightNode, order);
        }
    }


    static void traverseRightSkewedTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        traverseRightSkewedTree(root.right);
    }

    public static void main (String[] args)
    {

        Skewed tree = new Skewed();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);


        int order = 0;
        flattenBTToSkewed(node, order);
        traverseRightSkewedTree(headNode);
    }
}

