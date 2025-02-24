package aston.group86.hospitalboot.test;

public class Test66 {

  public static void main(String[] args) {
    TreeNode a = new TreeNode(1);
    TreeNode aL = new TreeNode(2);
    TreeNode aR = new TreeNode(3);

    a.left = aL;
    a.right = aR;

    TreeNode b = new TreeNode(1);
    TreeNode bL = new TreeNode(2);
    TreeNode bR = new TreeNode(3);

    b.left = bL;
    b.right = bR;

    System.out.println(isSameTree(a, b));//true

    ////////////////////////////////////////
    TreeNode a1 = new TreeNode(1);

    a1.left = new TreeNode(2);

    TreeNode b1 = new TreeNode(1);

    b1.right = new TreeNode(2);

    System.out.println(isSameTree(a1, b1));//false

  }

  //Этот код проверяет, являются ли два бинарных дерева идентичными
  //(то есть имеют ли они одинаковую структуру и значения в узлах)
  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if ((p == null && q != null) || (p != null && q == null)) {
      return false;
    }

    if (p == null) {
      return true;
    }

    if (p.val == q.val) {
      if (p.left == null && p.right == null) {
        return true;
      }
      boolean sameTree = isSameTree(p.left, q.left);
      boolean sameTree2 = isSameTree(p.right, q.right);
      return sameTree && sameTree2;
    }
    return false;
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
