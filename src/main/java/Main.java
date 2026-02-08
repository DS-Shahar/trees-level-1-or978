public class Trees1 {

    public static void main(String[] args) {
        BinNode<Integer> root = buildTree();
        task1(root);
        System.out.println(task2(root));
        System.out.println(task3(root));
        System.out.println(task4(root));
        BinNode<Integer> tree1 = buildTree1();
        BinNode<Integer> tree2 = buildTree2();
        System.out.println(task14(tree1));
        System.out.println(task18(tree1, tree2));
        System.out.println(task20(tree1));
    }

    public static BinNode<Integer> buildTree() {
        BinNode<Integer> node1 = new BinNode<>(2);
        BinNode<Integer> node2 = new BinNode<>(4);
        BinNode<Integer> node3 = new BinNode<>(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        return node1;
    }

    public static void task1(BinNode<Integer> t) {
        if (t == null) 
            return;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            System.out.println(t.getValue());
        task1(t.getLeft());
        task1(t.getRight());
    }

    public static int task2(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int result = 0;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            result = 1;
        return result + task2(t.getLeft()) + task2(t.getRight());
    }

    public static boolean task3(BinNode<Integer> t) {
        if (t == null) 
            return false;
        if (t.getValue() % 2 == 0 && !hasOddChild(t))
            return true;
        return task3(t.getLeft()) || task3(t.getRight());
    }

    public static boolean task4(BinNode<Integer> t) {
        if (t == null) 
            return true;
        if (t.getValue() % 2 != 0 || hasOddChild(t)) 
            return false;
        return task4(t.getLeft()) && task4(t.getRight());
    }

    public static boolean hasOddChild(BinNode<Integer> t) {
        if (t.hasLeft() && t.getLeft().getValue() % 2 != 0)
            return true;
        if (t.hasRight() && t.getRight().getValue() % 2 != 0) 
            return true;
        return false;
    }

    public static BinNode<Integer> buildTree1() {
        BinNode<Integer> node1 = new BinNode<>(10);
        BinNode<Integer> node2 = new BinNode<>(-5);
        BinNode<Integer> node3 = new BinNode<>(20);
        node1.setLeft(node2);
        node1.setRight(node3);
        return node1;
    }

    public static BinNode<Integer> buildTree2() {
        BinNode<Integer> node1 = new BinNode<>(10);
        BinNode<Integer> node2 = new BinNode<>(-5);
        node1.setLeft(node2);
        return node1;
    }

    public static int task14(BinNode<Integer> t) {
        int count = 0;
        if (t == null)
            return 0;
        if (!t.hasLeft() && !t.hasRight())
            count++;
        return count + task14(t.getLeft()) + task14(t.getRight());
    }

    public static boolean task18(BinNode<Integer> t1, BinNode<Integer> t2) {
        if (t2 == null)
            return true;
        if (!containsValue(t1, t2.getValue()))
            return false;
        return task18(t1, t2.getLeft()) && task18(t1, t2.getRight());
    }

    public static boolean containsValue(BinNode<Integer> t, int val) {
        if (t == null)
            return false;
        if (t.getValue() == val)
            return true;
        return containsValue(t.getLeft(), val) || containsValue(t.getRight(), val);
    }

    public static int task20(BinNode<Integer> t) {
        if (t == null)
            return 0;
        return positiveSum(t) - Math.abs(negativeSum(t));
    }

    public static int positiveSum(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = 0;
        if (t.getValue() > 0) {
            current = t.getValue();
        }
        return current + positiveSum(t.getLeft()) + positiveSum(t.getRight());
    }

    public static int negativeSum(BinNode<Integer> t) {
        if (t == null)
            return 0;
        int current = 0;
        if (t.getValue() < 0) {
            current = t.getValue();
        }
        return current + negativeSum(t.getLeft()) + negativeSum(t.getRight());
    }
}
