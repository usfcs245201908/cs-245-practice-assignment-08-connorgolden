public class BST<S> {

    class Node {
        private Comparable data;
        private Node leftChild;
        private Node rightChild;

        Node(Comparable item){
            data = item;
        }
    }

    Node root;

    boolean find (Comparable item){
        //Return true if item is found in the BST; false otherwise.
        return find(root, item);
    }

    private boolean find (Node node, Comparable item){
        if (node == null){
            return false;
        } else if (item.compareTo(node.data) == 0){
            return true;
        } else if (item.compareTo(node.data) < 0){
            return find(node.leftChild, item);
        } else {
            return find(node.rightChild, item);
        }
    }

    void insert(Comparable item){
        root = insert(root, item);
    }

    private Node insert(Node node, Comparable item){
        if (node == null){
            return new Node(item);
        } else if (item.compareTo(node.data) < 0){
            node.leftChild = insert(node.leftChild, item);
            return node;
        } else {
            node.rightChild = insert(node.rightChild, item);
            return node;
        }
    }

    void print(){
        //Using println, output each item in the BST,  in order.
       print(root);
    }
    private void print(Node node){
        if (node != null){
            print(node.leftChild);
            System.out.println(node.data);
            print(node.rightChild);
        }
    }

    void delete(Comparable item){
        //Delete first instance of item from the BST.
        root = delete(root, item);
    }

    private Node delete(Node node, Comparable item){
        if (node == null){
            return null;
        }

        if (node.data.compareTo(item) == 0){
            if (node.leftChild == null){
                return node.rightChild;
            } else if (node.rightChild == null){
                return node.leftChild;
            } else {
                if (node.rightChild.leftChild == null){
                    node.data = node.rightChild.data;
                    node.rightChild = node.rightChild.rightChild;
                    return node;
                } else {
                    node.data = removeSmallest(node.rightChild);
                    return node;
                }
            }
        } else if (item.compareTo(node.data)<0){
            node.leftChild = delete(node.leftChild, item);
            return node;
        } else {
            node.rightChild= delete(node.rightChild, item);
            return node;
        }
    }


    Comparable removeSmallest(Node node){
        if(node.leftChild.leftChild == null){
            Comparable smallest = node.leftChild.data;
            node.leftChild = node.leftChild.rightChild;
            return smallest;
        } else {
            return removeSmallest(node.leftChild);
        }
    }
}
