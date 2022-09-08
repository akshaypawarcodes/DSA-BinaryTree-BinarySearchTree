public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right= null;
        }
    }
    public static Node insert(Node root, int val){
        Node newNode=new Node(val);
        if(root == null){
            root=newNode;
            return root;
        }
        if(root.data>val){
            //insert into left subtree
            root.left=insert(root.left,val);
        }else{
            //insert into right subtree
            root.right=insert(root.right,val);
        }
        return root;
    }

    //inorder
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    //search key in BST
    public static boolean search(Node root, int key){
        //base case
        if(root == null){
            return false;
        }
        if(root.data>key){
            return search(root.left,key);
        } else if (root.data == key){
            return true;
        }else {
            return search(root.right,key);
        }
    }

    //delete a key
    public static Node deleteKey(Node root, int val){
        if(root == null){
            return null;
        }
        if(root.data>val){
            root.left= deleteKey(root.left,val);
        } else if (root.data<val) {
            root.right= deleteKey(root.right,val);
        }
        else{//root.data == val
            //case 1 for leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 for one child
            if(root.left == null){
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //case 3 for two child
            Node IS=InorderSuccessor(root.right);
            root.data= IS.data;
            root.right=deleteKey(root.right,IS.data);
        }
        return root;
    }
    public static Node InorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }

    //print in range
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data >=x && root.data <=y){
            printInRange(root.left, x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        } else if (root.data>=y){
            printInRange(root.left,x,y);
        } else if (root.data<=x){
            printInRange(root.right,x,y);
        }
    }

    public static void main(String[] args) {

        int[] values={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<values.length;i++){//be can use 'for-each' here
            root=insert(root,values[i]);
        }
        inOrder(root);
//        System.out.println();
//        if(search(root,1)){
//            System.out.println("key is in tree");
//        }else {
//            System.out.println("key is not in tree");
//        }

        //deleteKey(root,3);
        //inOrder(root);
        System.out.println();
        printInRange(root,4,7);
    }
}
