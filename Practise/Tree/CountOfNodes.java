package Practise.Tree;

public class CountOfNodes {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
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

    //Counting All The Node ::::  Sum of all left-sub-tree + Sum of all right-sub-tree + 1
    public static int count(Node root){
        if(root == null){
            return 0;
        }
        int leftSubTree = count(root.left);
        int rightSubTree = count(root.right);

        return leftSubTree + rightSubTree + 1;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("==== Count ====");
        System.out.println(count(root));
    }
}
