package algo.algo_4;

import algo.BTreePrinter;
import algo.TreeNode;
import org.junit.Test;

/**
 * Created by we on 2016. 6. 13..
 */
public class algo4_1 {
    @Test
    public void test(){

        TreeNode test = getTestTreeNode();


        test.print();
        System.out.println(isBalanced(test));
    }

    int checkHeight(TreeNode root){
        if( root == null ){
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if( leftHeight == -1 ){
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if( rightHeight == -1 ){
            return -1;
        }
        System.out.println("leftHeight = " + leftHeight + ", rightHeight = " + rightHeight + ", Data = " + root.data);
        int heightDiff = leftHeight - rightHeight;
        System.out.println("heightDiff = " + heightDiff + "\n");
        if( Math.abs(heightDiff) > 1 ){
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced(TreeNode root){
        int result = checkHeight(root);
        System.out.println(result);
        if( result == -1 ){
            return false;
        } else {
            return true;
        }
    }

    TreeNode getTestTreeNode(){
        TreeNode t = new TreeNode(1);
        t.setLeftChild(new TreeNode(2));
        t.setRightChild(new TreeNode(3));

        t.left.setLeftChild(new TreeNode(4));
        t.left.setRightChild(new TreeNode(5));
        t.right.setLeftChild(new TreeNode(6));
        t.right.setRightChild(new TreeNode(7));
        t.right.setLeftChild(new TreeNode(6));
        t.right.setRightChild(new TreeNode(7));

//        t.left.left.setLeftChild(new TreeNode(8));
        return t;
    }
}
