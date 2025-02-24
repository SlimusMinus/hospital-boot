package aston.group86.hospitalboot.test;

public class Test65 {

  public static void main(String[] args) {
    TreeNode a1 = new TreeNode(3);
    TreeNode a2 = new TreeNode(9);
    TreeNode a3 = new TreeNode(20);
    TreeNode a4 = new TreeNode(15);
    TreeNode a5 = new TreeNode(7);

    a1.left = a2;
    a1.right = a3;

    a3.left = a4;
    a3.right = a5;

    System.out.println(maxDepth(a1)); // 3 3->20->15

  }
  //Этот код вычисляет максимальную глубину бинарного дерева.
  public static int maxDepth(TreeNode root) {

    if(root == null){
      return 0;
    }

    int i = maxDepth(root.left);
    int i1 = maxDepth(root.right);

    return Math.max(i, i1) + 1;

  }


  public static class TreeNode {
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
}

