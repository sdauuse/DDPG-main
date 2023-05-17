package com.miao.algorithm.tree;


import com.miao.algorithm.linear.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }


    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {

        if (x == null) {
            N++;
            Node node = new Node(key, value, null, null);
            return node;
        }

        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }

    }

    public Node delete(Key key) {
        return delete(root, key);
    }

    private Node delete(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            N--;
            if (x.right == null) {
                return x.left;
            }

            if (x.left == null) {
                return x.right;
            }


            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            //删除右子树的最小节点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = n.left.right;
                } else {
                    n = n.left;
                }
            }
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;

        }

        return x;
    }

    public Key getMax() {
        return getMax(root).key;
    }

    private Node getMax(Node n) {

        if (n.right != null) {
            return getMax(n.right);
        } else {
            return n;
        }

    }

    public Queue<Key> preOrder() {
        Queue<Key> keys = new Queue<Key>();
        preOrder(root, keys);
        return keys;
    }

    private void preOrder(Node x, Queue keys) {

        if (x == null) {
            return;
        }

        keys.enqueue(x.key);

        if (x.left != null) {
            preOrder(x.left, keys);
        }

        if (x.right != null) {
            preOrder(x.right, keys);
        }
    }

    public Queue<Key> inOrder() {
        Queue<Key> keys = new Queue<Key>();
        inOrder(root, keys);
        return keys;
    }

    public void inOrder(Node x, Queue keys) {
        if (x == null) {
            return;
        }

        if (x.left != null) {
            inOrder(x.left, keys);
        }

        keys.enqueue(x.key);

        if (x.right != null) {
            inOrder(x.right, keys);
        }
    }


    public Queue<Key> layerOrder() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();

        nodes.enqueue(root);

        while (nodes.isEmpty()) {
            Node node = nodes.dequeue();
            keys.enqueue(node.key);
            if (node.left != null) {
                nodes.enqueue(node.left);
            }

            if (node.right != null) {
                nodes.enqueue(node.right);
            }
        }

        return keys;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    public int maxDepth(Node n) {
        if (n == null) {
            return 0;
        }

        int max = 0;
        int maxL = 0;
        int maxR = 0;

        if (n.left != null) {
            maxL = maxDepth(n.left);
        }

        if (n.right != null) {
            maxR = maxDepth(n.right);
        }

        max = maxL > maxR ? maxL + 1 : maxR + 1;

        return max;
    }
}
