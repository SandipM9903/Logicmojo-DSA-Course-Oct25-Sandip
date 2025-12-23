package Practise.Tree;

public class TreeFormation {
    static class Node{
        int data;     // value stored in the node
        Node left;    // reference to left child
        Node right;   // reference to right child
        /*
                data
               /    \
             left   right
        */

        //Now we have to create the constructor
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        //It will take all the nodes and return the root node from the given node array
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    //Preorder traversal 1.Root 2.All Left Subtree 3.All Right Subtree
    public static void preorder(Node root){
        //Base case
        if(root == null){
            return;
        }
        //First we need to print the root data
        //Then left data
        //Then right data
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //Inorder Traversal 1. Print all left subtree 2. Print Root 3. Print all right subtree
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
//        System.out.println(root.data);
        System.out.println("Preorder Traversal");
        preorder(root);
    }
}
