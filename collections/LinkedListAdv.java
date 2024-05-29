package collections;

public class LinkedListAdv {

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

    public static void main(String[] args) {
        LinkedListAdv linkedList = new LinkedListAdv();

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

