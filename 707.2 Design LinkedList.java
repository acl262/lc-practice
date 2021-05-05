/*cleaner solution with generated addAtIndex method.
1. tailNode pointing to dummyHead instead of dummyHead.next at initialiation.
2. corner case in the addAtIndex method when index == size (appending to the end), don't forget size++ and then return.
3. general case in the addAtIndex method also needs to make sure that the tailNode points the last node after insertion.
4. when deleting the last node (index == size - 1), point tailNode to the new last node.
5. be careful with corner case in terms of invalid index, index == 0 is valid, index < 0 needs to consider, not index == 0.
*/

class MyLinkedList {
    
    int size;
    Node dummyHead;
    Node tailNode;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummyHead = new Node(0);
        tailNode = dummyHead;
        size = 0;
    }
    
    // DH -> 0 -
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node cur = dummyHead;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // dh -> 7 -> null 
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size ) return;
        if(index == size) {
            tailNode.next = new Node(val);
            tailNode = tailNode.next;
            size ++;
            return;
        }
        Node cur = dummyHead;
        for(int i= 0; i < index; i++) {
            cur = cur.next;
        }
        Node tmp = cur.next;
        cur.next = new Node(val);
        cur = cur.next;
        cur.next = tmp;
        while (cur.next != null) {
            cur =cur.next;
        }
        tailNode = cur;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        Node cur = dummyHead;
        
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if(index == size -1) {
            tailNode = cur;
        }
        //if(cur.next != null) {
            
            cur.next = cur.next.next;
            
        //} 
        size--;
    }
}
// DH -> 1 -> 2 -> 3 

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val= val;
        next = null;
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
