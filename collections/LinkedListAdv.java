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

    // Slow-Fast(turtle-hare) approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // 1 2 3
            fast = fast.next.next; // 1 3 5
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null) {
            return true;
        }
        Node mid = findMid(head);

        Node prev = null;
        Node currNode = mid;
        Node next;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        Node right = prev; // head of other half
        Node left = head;

        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Floyd's CFA
    // 1 2 3 4 5 6 - 1 2 3 4 5 6
    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true; // cycle exists
            }
        }
        return false;
    }

    public void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean isCycle= false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            return;
        }

        // finding meeting point 
        slow = head;
        Node prev = null; // last node for which next to be assigned as null later
        while(slow != fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void main(String[] args) {
        LinkedListAdv linkedList = new LinkedListAdv();

        linkedList.print();
        linkedList.addFirst(1);
        linkedList.print();
        linkedList.addFirst(2);
        linkedList.print();
        linkedList.addLast(1);
        linkedList.print();
        linkedList.addLast(2);
        linkedList.print();
        linkedList.add(2, 9);
        linkedList.print();

        linkedList.printSize();

        System.out.println("head:" + head.data + " tail:" + tail.data);

        //System.out.println(linkedList.checkPalindrome());



        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        System.out.println(linkedList.isCycle());
        linkedList.removeCycle();
        System.out.println(linkedList.isCycle());
    
        
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

