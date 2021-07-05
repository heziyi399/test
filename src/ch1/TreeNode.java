package ch1;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
 TreeNode left;
  TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        int maxwidth=0;
        if(root==null) return  0;
        Deque<TreeNode>qu=new LinkedList<>();
        qu.offer(root);
        root.val=1;
while (!qu.isEmpty()){
    int len=qu.size();

        int left=qu.peekFirst().val;
        int right=qu.peekLast().val;
        maxwidth=Math.max(maxwidth,right-left+1);
    for(int i =0;i <len;i++){
        TreeNode node=qu.poll();
        int position = node.val;
        if(node.left!=null){
            node.left.val = position*2;
            qu.offer(node.left);
        }
        if(node.right!=null){
            node.right.val = position*2+1;
            qu.offer(node.right);
        }

    }
}
        return maxwidth;

    }
}
