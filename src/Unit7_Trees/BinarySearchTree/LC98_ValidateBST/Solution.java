package Unit7_Trees.BinarySearchTree.LC98_ValidateBST;


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

public class Solution {
    public int isValidBST(TreeNode A) {

        return isValidHelper(A,Integer.MIN_VALUE,Integer.MAX_VALUE)?1:0;

    }
    public boolean isValidHelper(TreeNode currRoot,int lowerbound,int upprbound)
    {
        if(currRoot==null)
            return true;

        if(currRoot.val<=lowerbound || currRoot.val>=upprbound)
        {
            return false;
        }

        //OR ki jgah AND aayega
        return isValidHelper(currRoot.left,lowerbound,currRoot.val)&&
                isValidHelper(currRoot.right,currRoot.val,upprbound);
    }

}
