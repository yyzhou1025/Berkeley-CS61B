package lab9;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Implementation of interface Map61B with BST as core data structure.
 *
 * @author Yuanyuan Zhou
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class Node {
        /* (K, V) pair stored in this Node. */
        private K key;
        private V value;

        /* Children of this Node. */
        private Node left;
        private Node right;

        private Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    private Node root;  /* Root node of the tree. */
    private int size; /* The number of key-value pairs in the tree */

    /* Creates an empty BSTMap. */
    public BSTMap() {
        this.clear();
    }

    /* Removes all of the mappings from this map. */
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    /** Returns the value mapped to by KEY in the subtree rooted in P.
     *  or null if this map contains no mapping for the key.
     */
    private V getHelper(K key, Node p) {
        if (p == null) {
            return null;
        }
        Node current = p;
        if (current.key.compareTo(key) == 0 ) {
            return current.value;
        }
        if (current.key.compareTo(key) < 0) {
            return getHelper(key, current.right);
        } else {
            return getHelper(key, current.left);
        }

    }

    /** Returns the value to which the specified key is mapped, or null if this
     *  map contains no mapping for the key.
     */
    @Override
    public V get(K key) {
        return getHelper(key, this.root);


    }

    /** Returns a BSTMap rooted in p with (KEY, VALUE) added as a key-value mapping.
      * Or if p is null, it returns a one node BSTMap containing (KEY, VALUE).
     */
    private Node putHelper(K key, V value, Node p) {

        //if p is null
        if (p == null) {
            p = new Node(key,value);;
            size++;
        } else if (p.key.compareTo(key) > 0) {
            p.left = putHelper(key, value, p.left);
        } else if(p.key.compareTo(key) < 0) {
            p.right = putHelper(key, value, p.right);
        } else  {
            p.value = value;
        }

        return p;


    }

    /** Inserts the key KEY
     *  If it is already present, updates value to be VALUE.
     */
    @Override
    public void put(K key, V value) {
        //size++;
        this.root = putHelper(key, value,this.root);
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
        return this.size;
    }



    //////////////// EVERYTHING BELOW THIS LINE IS OPTIONAL ////////////////

    /* Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet() {
        //if the tree is empty
        if (root == null) {
            return null;
        }
        Set<K> keys = new HashSet<>(size);
        keySetHelper(keys, root);
        return keys;

    }

    private void keySetHelper(Set<K> keys, Node p) {
        if (p != null){
            keys.add(p.key);
            keySetHelper(keys, p.left);
            keySetHelper(keys, p.right);

        }
    }

    /** Removes KEY from the tree if present
     *  returns VALUE removed,
     *  null on failed removal.
     */
    @Override
    public V remove(K key) {
        Node parent = root;
        Node current = root;
        //if the tree is empty
        if (root == null) {
            return null;
        }
        boolean isLC = true;  // flag: is left child or not
        while (current.key != key) {
            parent = current;
            if (current.key.compareTo(key) < 0) {
                isLC = false;
                current = current.right;

            } else {
                isLC = true;
                current = current.left;
            }
            // not found
            if (current == null) {
                return null;
            }
        }
        //case 2: the node has no child
        if(current.left == null && current.right == null) {
            size--;
            if (current == root) {
                root = null;
            } else if (isLC) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // case 3: the node has one child
        //the node has left child
        if (current.left == null && current.right != null) {
            size--;
            if (current == root ) {
                root = root.right;
            } else if (isLC) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else if (current.left != null && current.right == null) {  //the node has right child
            size--;
            if (current == root) {
                root = current.left;
            } else if (isLC) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left != null && current.right != null) {//the node has two child
            size--;
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLC) {
                parent.left = successor;
            } else {
                parent.right  = successor;
            }
            successor.left = current.left;
        }

        return current.value;
    }

    private Node getSuccessor(Node remover) {
        Node sp = remover;
        Node successor  = remover;
        Node current = remover.right;
        while ( current != null){
            sp = successor;
            successor = current;
            current = current.left;
        }

        if (successor != remover.right) {
            sp.left = successor.right;
            successor.right = remover.right;
        }
        return  successor;

    }

    /** Removes the key-value entry for the specified key only if it is
     *  currently mapped to the specified value.  Returns the VALUE removed,
     *  null on failed removal.
     **/
    @Override
    public V remove(K key, V value) {
        Node remover = new Node(key, this.get(key));
        if (!remover.value.equals(value)) {
            return null;
        } else {
            return remove(key);
        }



    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> bstmap = new BSTMap<>();
        bstmap.put("hello", 5);
        bstmap.put("cat", 10);
        bstmap.put("fish", 22);
        bstmap.put("zebra", 90);
        bstmap.put("dog", 80);
        System.out.println(bstmap.size);
        bstmap.remove("dog", 33);
        bstmap.remove("dog",80);
        System.out.println(bstmap.size);
        System.out.println(bstmap.get("zebra"));




    }
}
