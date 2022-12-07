class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        TreeNode node = root ;
		   TreeNode pre = null ;		   
		   while (!stack.isEmpty() || node != null) {			   
			   if (node != null) {
				   stack.push(node);
				   node = node.left ;
			   } else {				   
				   TreeNode p = stack.pop() ;
				   if (pre != null && p.val <= pre.val) {					   
					   return false ;
				   }				   
				   pre = p ;					   
				   node = p.right ;
			   }
		   }
		   return true ; 
    }
}