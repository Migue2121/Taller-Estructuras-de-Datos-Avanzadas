class CBTInserter {

    List<TreeNode> list = new ArrayList<>();
    TreeNode root;

    public CBTInserter(TreeNode root) {
       this.root = root;   /

       LinkedList<TreeNode> tree = new LinkedList<>();
        tree.add(root);  
        while(!tree.isEmpty()) {  
            for(int i = 0; i < tree.size(); i++) {
                TreeNode node = tree.poll();
                list.add(node);
                if(node.left != null) tree.add(node.left);
                if(node.right != null) tree.add(node.right);
            }

        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        list.add(node);
        TreeNode parent = list.get(list.size()/2-1);
        if(list.size() % 2 == 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}