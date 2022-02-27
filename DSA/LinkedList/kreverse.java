
// itrative method.
public static Node reverseKList(Node head, int n){
    if(head==null || head.next==null){
           return;
    }

    Node prevNode=head;
    Node currNode=head.next;
    int count=0;
    while(currNode!=null && count<n){
        Node nextnode=currNode.next;
        prevNode=currNode;
        currNode=nextNode;
        count++;
    }
    if(nextNode!=null){
        head.next=reverseKList(nextNode,n);
    }
    return prevNode;
}

// recursive method.

public Node reverseListRecursive(Node head){
    if(head==null || head.next==null){
        return head;
    }

    Node newHead=reverseListRecursive(head.next);

    head.next.next=head;
    head.next=null;
    return newHead;
}