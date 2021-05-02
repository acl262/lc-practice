class MyLinkedList {
    
    Node dummyHead;
    int size;
    Node curTail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new Node(0);
        size = 0;
        curTail = null; 
        curTail =    dummyHead.next;
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = dummyHead;
        for(int i = 0; i<= index; i++) {
            cur = cur.next;
        }
        
        return cur.val;
       
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        Node tmp = dummyHead.next;
        dummyHead.next = cur;
        cur.next = tmp;
        //tmp = null;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = dummyHead;
        while (cur.next != null) {
            cur = cur.next;
            
        }
        Node tail = new Node(val);
        cur.next = tail;
        curTail = tail;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) {
            return;
        }
        if (index == size && curTail != null) { 
            curTail.next = new Node (val);
            curTail = curTail.next;   
            size++;
            return;
        }
        Node first = dummyHead;
        for(int i = 0; i < index; i++) {
            first = first.next;
        }
        Node tmp = first.next;
        Node ins = new Node(val);
        first.next = ins;
        ins.next = tmp;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        Node del = dummyHead;

        for(int i= 0; i < index; i++) {
            del = del.next;
        }
        if(del.next != null) {
            del.next = del.next.next;
        }
        size--;
    }

}

class Node {
    int val;
    Node next;
    public Node (int val) {
        this.val = val;
        this.next = null;
    }
    
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
