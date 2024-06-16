package collections;

import java.util.LinkedList;



public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        System.out.println("Value for key 'one': " + hashMap.get("one"));
        System.out.println("Value for key 'two': " + hashMap.get("two"));

        hashMap.remove("two");

        System.out.println("Value for key 'two' after removal: " + hashMap.get("two"));
        System.out.println("Current size: " + hashMap.size());
    }
}

class HashMap<K, V> {
    private LinkedList<HashNode<K, V>>[] chainArray;
    private int numBuckets;
    private int size;

    // Constructor
    public HashMap() {
        chainArray = new LinkedList[10];
        numBuckets = 10;
        size = 0;

        // Initialize each chain
        for (int i = 0; i < numBuckets; i++) {
            chainArray[i] = new LinkedList<>();
        }
    }

    // Hash function to find the index for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % numBuckets);
    }

    // Method to add a key-value pair to the hash map
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                node.value = value; // Update the value if key is found
                return;
            }
        }

        // If key is not found, insert a new node
        HashNode<K, V> newNode = new HashNode<>(key, value);
        chain.add(newNode);
        size++;

        // Resize if load factor goes beyond a threshold
        if ((1.0 * size) / numBuckets >= 0.7) {
            resize();
        }
    }

    // Method to get the value for a key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Method to remove a key-value pair from the hash map
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<HashNode<K, V>> chain = chainArray[bucketIndex];

        HashNode<K, V> toRemove = null;
        for (HashNode<K, V> node : chain) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }

        if (toRemove == null) {
            return null; // Key not found
        }

        chain.remove(toRemove);
        size--;
        return toRemove.value;
    }

    // Method to resize the hash map when the load factor exceeds the threshold
    private void resize() {
        LinkedList<HashNode<K, V>>[] temp = chainArray;
        chainArray = new LinkedList[numBuckets * 2];
        numBuckets = numBuckets * 2;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            chainArray[i] = new LinkedList<>();
        }

        for (LinkedList<HashNode<K, V>> chain : temp) {
            for (HashNode<K, V> node : chain) {
                put(node.key, node.value);
            }
        }
    }

    // Method to get the size of the hash map
    public int size() {
        return size;
    }

    // Method to check if the hash map is empty
    public boolean isEmpty() {
        return size == 0;
    }
}

class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    // Constructor
    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
