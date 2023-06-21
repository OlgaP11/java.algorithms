package homework4;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private Node root;

    public boolean add(int value){
        if (root == null){
            root = new Node();
           root.value = value;
           root.color = Color.BLACK;
           return true;
        } else{
            boolean result =  addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        }
    }
    private boolean addNode (Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild  = rebalance(node.rightChild);
                    return result;
                } else{
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needBalance;
        do{
            needBalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                needBalance = true;
                result = rightSwat(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
            result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED){
                needBalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
            result.rightChild != null && result.rightChild.color == Color.RED){
                needBalance = true;
                colorSwap(result);
            }
        } while (needBalance);
        return result;
    }
    private Node rightSwat(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }
    private Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }
    private void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public boolean contains (int value){
        final Node node = findNode(root,value);
        return node != null;
    }

    private Node findNode (Node node, int value){
        if (node.value == value){
            return node;
        } else{
            if (node.value > value){
                if (node.leftChild != null){
                    return findNode(node.leftChild, value);
                } else{
                    return null;
                }
            } else {
                if (node.rightChild != null){
                    return findNode(node.rightChild, value);
                } else {
                    return null;
                }
            }
        }
    }

    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        private Color color;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", color=" + color +
                    '}';
        }
    }
}
