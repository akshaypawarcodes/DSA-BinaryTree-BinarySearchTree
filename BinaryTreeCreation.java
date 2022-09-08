import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class BinaryTreeCreation {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    //problem 1
    //to build a binary tree
    static class Binarytree {
        static int indx = -1;

        public Node Buildtree(int[] nodes) {
            indx++;
            if (nodes[indx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[indx]);
            newNode.left = Buildtree(nodes);
            newNode.right = Buildtree(nodes);
            return newNode;
        }

        //problem 2
        //traversal in postorder(LRN)
        public void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //traversal on tree inorder(LNR)
        public void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
            //System.out.print(root.data+" ");

        }

        //traversal in preorder(NLR)
        public void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);

        }

        //problem 3
        //print node in level order
        public void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                    System.out.print(currNode.data + " ");
                }
            }
        }

        //problem 4
        //Count total number of nodes
        public int CountOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftcount = CountOfNodes(root.left);
            int rightcount = CountOfNodes(root.right);
            return leftcount + rightcount + 1;
        }

        //problem 5
        //sum of data of nodes
        public int sumOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftsum = sumOfNodes(root.left);
            int rightsum = sumOfNodes(root.right);
            return leftsum + rightsum + root.data;
        }

        //problem 6
        //calculate height of tree
        public int height(Node root){
            if(root == null){
                return 0;
            }
            int leftheight=height(root.left);
            int rightheight=height(root.right);
            int totalheight=Math.max(leftheight,rightheight);
            return totalheight+1;
        }

        //problem 7(Approach 1)
        //diameter of tree TC[O(n^2)]
        public int Diameter(Node root){
            if(root == null){
                return 0;
            }
            int diameter1=Diameter(root.left);
            int diameter2=Diameter(root.right);
            int diameter3=height(root.left)+height(root.right)+1;
            int diameter=Math.max(diameter3,Math.max(diameter1,diameter2));
            return diameter;
        }


    }

    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,-1};
        //1,3,7,-1,-1,11,-1,-1,5,17,-1,-1,-1
        Binarytree tree=new Binarytree();
        Node root=tree.Buildtree(nodes);
        //System.out.println(root.data);
        //tree.postorder(root);

        tree.levelorder(root);
        System.out.println();
        System.out.println("total number of nodes in tree are: "+tree.CountOfNodes(root));
        System.out.println("sum of data of all nodes is: "+tree.sumOfNodes(root));
        System.out.println("height of tree is: "+tree.height(root));
        System.out.println("diameter of tree is: "+tree.Diameter(root));
       // System.out.println("nodes in inorder");
        tree.inorder(root);
        System.out.println();
        tree.preorder(root);

    }
}
