package Practise.Tree;

public class BstInsert {
    static class Node{
        int data;
        Node left;
        Node right;
        int count;

        Node(int data){
            this.data = data;
            this.count = 1;
            this.left = null;
            this.right = null;
        }
    }

    static class BST{
        static Node root;
        public static void insert(int data){
            Node node = new Node(data);
            //First Check
            if(root == null){
                root = node;
                return;
            }

            //Second we have to put one counter so that we can point the current node
            Node curr = root;

            //Third we have to start a loop until value is inserted
            while(true){
                //1️⃣ Ignore duplicates
                //Just do nothing if the value already exists.
                //2️⃣ Always put duplicates on left or right
                //This can break balance and make the tree skewed.
                //3️⃣ Use a count variable ✅
                if(data == curr.data){
                    curr.count++;
                    return;
                } else if (data < curr.data) {
                    if(curr.left == null){
                        curr.left = node;
                        return;
                    }
                    curr = curr.left;
                } else {
                    if(curr.right == null){
                        curr.right = node;
                        return;
                    }
                    curr = curr.right;
                }
            }
        }
    }
    public static void main(String[] args) {

        BST.insert(5);
        BST.insert(3);
        BST.insert(7);
        BST.insert(3);
        BST.insert(5);
        BST.insert(5);

        // Simple check
        System.out.println("Root value: " + BST.root.data);
        System.out.println("Root count: " + BST.root.count);

        System.out.println("Left child value: " + BST.root.left.data);
        System.out.println("Left child count: " + BST.root.left.count);

        System.out.println("Right child value: " + BST.root.right.data);
        System.out.println("Right child count: " + BST.root.right.count);
    }

}
