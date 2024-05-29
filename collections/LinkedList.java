package collections;

public class LinkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;


    public void addFirst(int data){
        Node node = new Node(data);
        size++;
        if(head == null) {
            head = tail = node;
            return;
        }
    
        node.next = head;
        head = node;
    }

    public void addLast(int data){
        Node node = new Node(data);
        size++;
        if(head == null) {
            head = tail = node;
            return;
        }
    
        tail.next = node;
        tail = node;
    }

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        } 
        Node node = new Node(data);
        size++;
        if(head == null) {
            head = tail = node;
            return;
        }

        int i = 0;
        Node temp = head;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
        
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } if(size == 1){
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        } if(size == 1){
            int value = tail.data;
            head = tail = null;
            size = 0;
            return value;
        }
        int val = tail.data;
        int i=0;
        Node prev = head;
        while(i<size-2){
            prev = prev.next;
            i++;
        }
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // O(n)
    public int itrSearch(int element){
        Node temp = head;
        int i=0;
        while(temp != null){
            if(temp.data == element){
                return i;
            } else {
                temp = temp.next;
            }
            i++;
        }
        return -1;
    }


    // O(n)
    public int helper(int key, Node head){
        if(head == null) return -1;
        if(head.data == key){
            return 0;
        } else {
            int result = helper(key, head.next);
            return result != -1 
                ? result + 1
                : result;
        }
    }

    public int recSearch(int key){
        return helper(key, head);
    }


    // O(n)
    public void reverse(){
        Node previous = null;
        Node current = tail = head;
        Node next;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }


    //O(n)
    public int remove(int element){
        Node current = head;
        Node prev = null;
        while(current != null){
            if(current.data == element){
                if(prev != null) {
                    prev.next = current.next;
                    if(current.next == null) tail = prev;
                }
                else head = current.next;
                size--;
                return 1;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return -1;
    }

    public int removeByIdx(int idx){
        if(idx==size) {
            head = head.next;
            size--;
            return head.data;
        }
        
        int startIdx = size - idx; // 5-4 = 1 -1 = 1
        int i = 1;
        Node prev = head;
        int current = -1;

        while(i < startIdx){
            prev = prev.next;
            i++;
        }
        if(prev.next.next == null) tail = prev;
        current = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return current;
    }

    public static void main(String[] args) {
        // LinkedList<String> list = new LinkedList<>();
        // list.add("Abc");1
        // list.add("Mno");
        // list.add("Xyz");

        LinkedList linkedList = new LinkedList();
        // linkedList.head = new Node(1);
        // linkedList.head.next = new Node(2);

        linkedList.print();
        linkedList.addFirst(1);
        linkedList.print();
        linkedList.addFirst(2);
        linkedList.print();
        linkedList.addLast(3);
        linkedList.print();
        linkedList.addLast(4);
        linkedList.print();
        linkedList.add(2, 9);
        linkedList.print();

        linkedList.printSize();

        // linkedList.removeFirst();
        // linkedList.print();

        // linkedList.printSize();

        // linkedList.removeLast();
        // linkedList.print();

        // linkedList.printSize();

        System.out.println("Itr Search Result:" + linkedList.itrSearch(10));

        System.out.println("Rec Search Result:" + linkedList.recSearch(1));

        System.out.println("head:" + head.data + " tail:" + tail.data);

        // linkedList.reverse();
        // linkedList.print();
        // linkedList.printSize();

        // System.out.println("Remove status:" + linkedList.remove(4));
        // linkedList.print();
        // linkedList.printSize();
        // System.out.println("head:" + head.data + " tail:" + tail.data);


        System.out.println("Removed Element:" + linkedList.removeByIdx(2));
        linkedList.print();
        linkedList.printSize();
        System.out.println("head:" + head.data + " tail:" + tail.data);
        
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printSize(){
        System.out.println("Size:" + size);
    }
    
}
