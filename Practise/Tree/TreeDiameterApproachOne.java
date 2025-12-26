package Practise.Tree;
//This Approach One is the basic one where time complexity is O(n^2)
public class TreeDiameterApproachOne {
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

    static class BuildTree{
        static int index = -1;
        public static Node build(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = build(nodes);
            newNode.right = build(nodes);

            return newNode;
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int treeHeight = Math.max(leftHeight, rightHeight) + 1;
        return treeHeight;
    }

    // Diameter logic (O(n^2)):
    // 1) Find diameter of left subtree
    // 2) Find diameter of right subtree
    // 3) Find diameter passing through current node = height(left) + height(right) + 1
    // 4) Return the maximum of all three
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }

        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = height(root.left) + height(root.right) + 1;

        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BuildTree.build(nodes);
        System.out.println(root.data);
        System.out.println("==== Diameter ====");
        System.out.println(diameter(root));
    }
}
