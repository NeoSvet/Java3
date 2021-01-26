package ru.neosvet.algoritmy6;

//Задание 6.2
public class Tree<T extends HasID> {
    enum Place {
        ROOT, LEFT, RIGHT
    }
    public enum Order {
        PRE, IN, POST
    }

    private Node<T> root;

    //Задание 6.3
    public void insert(T data) {
        Node<T> new_node = new Node<>(data);
        if (root == null) {
            root = new_node;
            return;
        }

        Node<T> node = root;
        Node<T> prev;
        while (true) {
            prev = node;
            if (data.getId() < node.getId()) {
                node = node.left;
                if (node == null) {
                    prev.left = new_node;
                    return;
                }
            } else {
                node = node.right;
                if (node == null) {
                    prev.right = new_node;
                    return;
                }
            }
        }
    }

    //Задание 6.3
    public Node<T> find(int key) {
        Node<T> node = root;
        while (node.getId() != key) {
            if (key < node.getId())
                node = node.left;
            else
                node = node.right;
            if (node == null)
                return null;
        }
        return node;
    }

    //Задание 6.4
    private void preOrder(Node<T> rootNode) {
        if (rootNode == null)
            return;
        rootNode.display();
        preOrder(rootNode.left);
        preOrder(rootNode.right);
    }

    //Задание 6.4
    private void postOrder(Node<T> rootNode) {
        if (rootNode == null)
            return;
        postOrder(rootNode.left);
        postOrder(rootNode.right);
        rootNode.display();
    }

    //Задание 6.4
    private void inOrder(Node<T> rootNode) {
        if (rootNode == null)
            return;
        inOrder(rootNode.left);
        rootNode.display();
        inOrder(rootNode.right);
    }

    //Задание 6.4
    public Node<T> foundMin() {
        Node<T> node, last = null;
        node = root;
        while (node != null) {
            last = node;
            node = node.left;
        }
        return last;
    }

    //Задание 6.4
    public Node<T> foundMax() {
        Node<T> node, last = null;
        node = root;
        while (node != null) {
            last = node;
            node = node.right;
        }
        return last;
    }

    //Задание 6.4
    public void display(Order order) {
        System.out.println("Tree:");
        switch (order) {
            case IN:
                inOrder(root);
                break;
            case PRE:
                preOrder(root);
                break;
            case POST:
                postOrder(root);
                break;
        }
    }

    //Задание 6.5
    public boolean delete(int id) {
        Node<T> node = root;
        Node<T> prev = root;

        Place place = Place.ROOT;

        while (node.getId() != id) {
            prev = node;
            if (id < node.getId()) {
                place = Place.LEFT;
                node = node.left;
            } else {
                place = Place.RIGHT;
                node = node.right;
            }
            if (node == null)
                return false;
        }

        if (node.left == null && node.right == null) {
            changeNode(prev, null, place);
            return true;
        }

        if (node.right == null) {
            changeNode(prev, node.left, place);
            return true;
        }

        if (node.left == null) {
            changeNode(prev, node.right, place);
            return true;
        }

        changeNode(prev, getSuccesor(node), place);
        return true;
    }

    //Задание 6.5
    private Node<T> getSuccesor(Node<T> source) {
        Node<T> sPrev = source;
        Node<T> sCur = source;
        Node<T> node = source.right;

        while (node != null) {
            sPrev = sCur;
            sCur = node;
            node = node.left;
        }
        if (sCur != node.right) {
            sPrev.left = sCur.right;
            sCur.right = node.right;
        }

        return sCur;
    }

    //Задание 6.5
    private void changeNode(Node<T> current, Node<T> node, Place place) {
        switch (place) {
            case LEFT:
                current.left = node;
                break;
            case RIGHT:
                current.right = node;
                break;
            default:
                root = node;
                break;
        }
    }
}
