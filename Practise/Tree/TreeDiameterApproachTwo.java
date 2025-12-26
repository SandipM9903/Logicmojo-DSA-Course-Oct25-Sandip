package Practise.Tree;

public class TreeDiameterApproachTwo {
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

    // Diameter calculation steps (Optimized – O(n)):
    // 1) Recursively get left subtree height & diameter
    // 2) Recursively get right subtree height & diameter
    // 3) Calculate current height = max(left, right) + 1
    // 4) Calculate diameter as max(left.diameter, right.diameter, left.height + right.height + 1)
    // 5) Return both height and diameter together

    static class TreeInfo{
        int height;
        int diameter;

        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo calDiameter(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = calDiameter(root.left);
        TreeInfo right = calDiameter(root.right);

        int treeHeight = Math.max(left.height, right.height) + 1;

        int diameter1 = left.diameter;
        int diameter2 = right.diameter;
        int diameter3 = left.height + right.height + 1;

        int treeDiameter = Math.max(diameter3, Math.max(diameter1,diameter2));
        TreeInfo treeInfo = new TreeInfo(treeHeight, treeDiameter);
        return treeInfo;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BuildTree.build(nodes);
        System.out.println(root.data);
        System.out.println("==================");
        System.out.println(calDiameter(root).diameter);
    }
}
